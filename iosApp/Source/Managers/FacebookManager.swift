//
//  FacebookManager.swift
//  BookMeNow-Develop
//
//  Created by Yurii Goroshenko on 29.03.2023.
//

import FacebookLogin
import FBSDKCoreKit

struct FacebookUser {
    let token: String?
    let name: String?
    let email: String?
}

enum FacebookManager {
    static func loginWithFacebook(completionHandler: @escaping (FacebookUser) -> Void) {
        guard let controller = UIApplication.shared.rootController else { return }
        
        let loginManager = LoginManager()
        loginManager.logIn(permissions: ["public_profile", "email"], viewController: controller) { result in
            switch result {
            case .success:
                if AccessToken.current != nil {
                    GraphRequest(graphPath: "me", parameters: ["fields": "email, id, name"]).start { _, result, error in
                        if error == nil, let result = result as? [String: String] {
                            
                            let user = FacebookUser(
                                token: result["id"],
                                name: result["name"],
                                email: result["email"]
                            )
                            
                            completionHandler(user)
                        }
                    }
                }
            case .cancelled:
                print("Facebook login was cancelled.")
            case .failed(let error):
                print("Error logging in with Facebook: \(error.localizedDescription)")
            }
        }
    }
    
    static func handle(_ url: URL) -> Bool {
        true
    }
}
