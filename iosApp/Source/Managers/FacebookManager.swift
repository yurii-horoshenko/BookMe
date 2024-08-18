//
//  FacebookManager.swift
//  BookMeNow-Develop
//
//  Created by Yurii Goroshenko on 29.03.2023.
//
//
//
//struct FacebookUser {
//    let token: String?
//    let name: String?
//    let email: String?
//}
//
//enum FacebookManager {
//    static func loginWithFacebook(completionHandler: @escaping (FacebookUser) -> Void) {
//        guard let controller = UIApplication.shared.rootController else { return }
//        
//        let loginManager = LoginManager()
//        loginManager.logIn(permissions: ["public_profile", "email"], from: controller) { result, error in
//            guard let token = AccessToken.current else { return }
//            
//            GraphRequest(graphPath: "me", parameters: ["fields": "email, id, name"]).start { _, result, error in
//                if error == nil, let result = result as? [String: Any] {
//                    
//                    let user = FacebookUser(
//                        token: token.tokenString,
//                        name: result["name"] as? String ?? "",
//                        email: result["email"] as? String ?? ""
//                    )
//                    
//                    completionHandler(user)
//                }
//            }
//        }
//        
//    }
//    
//    static func handle(_ url: URL) -> Bool {
//        true
//    }
//}
