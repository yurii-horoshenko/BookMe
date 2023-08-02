//
//  FacebookManager.swift
//  BookMeNow-Develop
//
//  Created by Yurii Goroshenko on 29.03.2023.
//

// import FBSDKCoreKit
// import FBSDKLoginKit
//
// enum FacebookManager {
//    static func setup(_ application: UIApplication, didFinishLaunchingWithOptions launchOptions: [UIApplication.LaunchOptionsKey: Any]?) -> Bool {
//        FBSDKCoreKit.ApplicationDelegate.shared.application(
//            application,
//            didFinishLaunchingWithOptions: launchOptions
//        )
//    }
//
//    static func signIn(sender: UIViewController?) {
//        let loginManager = LoginManager()
//        loginManager.logIn(permissions: ["email"], from: sender) { result, error in
//            if let error {
//                print("Encountered Erorr: \(error)")
//            } else if let result, result.isCancelled {
//                print("Cancelled")
//            } else {
//                print("Logged In")
//            }
//        }
//    }
//
//    static func handle(_ url: URL) -> Bool {
//        true
//    }
// }
