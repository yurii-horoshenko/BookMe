//
//  FacebookManager.swift
//  BookMeNow-Develop
//
//  Created by Yurii Goroshenko on 29.03.2023.
//

import FacebookLogin

struct FacebookUser {
    let token: String?
    let name: String?
    let email: String?
}

enum FacebookManager {
    static func loginWithFacebook(completionHandler: @escaping (FacebookUser) -> Void) {
        guard let controller = UIApplication.shared.firstKeyWindow?.rootViewController else {
            return
        }
        
        let loginManager = LoginManager()
        loginManager.logIn(permissions: ["public_profile", "email"], viewController: controller) { result in
            switch result {
            case .success(granted: _, declined: _, token: _):
                print("Facebook login successful.")
                // Perform actions after successful login
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
