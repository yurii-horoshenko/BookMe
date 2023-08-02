//
//  GoogleManager.swift
//  Created by Yurii Goroshenko on 29.03.2023.
//

// import GoogleSignIn
//
// struct GoogleManagerUser {
//    let token: String?
//    let name: String?
//    let email: String?
// }
//
// enum GoogleManager {
//    // MARK: - Variables
//    static let clientID = "832700470851-e9ug3e3drtcvdicvqkajv86q357vqch1.apps.googleusercontent.com"
//
//    // MARK: - Public
//    static func setup() {
//        // Create Google Sign In configuration object.
//        let config = GIDConfiguration(clientID: clientID)
//        GIDSignIn.sharedInstance.configuration = config
//    }
//
//    static func handle(_ url: URL) -> Bool {
//        GIDSignIn.sharedInstance.handle(url)
//    }
//
//    static func signIn(withPresenting sender: UIViewController, completionHandler: @escaping (GoogleManagerUser) -> Void) {
//        GIDSignIn.sharedInstance.signIn(withPresenting: sender) { signInResult, error in
//            guard error == nil, let value = signInResult?.user else { return }
//            let user = GoogleManagerUser(
//                token: value.idToken?.tokenString,
//                name: value.profile?.name,
//                email: value.profile?.email
//            )
//            completionHandler(user)
//        }
//    }
// }
