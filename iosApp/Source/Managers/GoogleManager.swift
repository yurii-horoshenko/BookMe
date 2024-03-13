//
//  GoogleManager.swift
//  Created by Yurii Goroshenko on 29.03.2023.
//

 import GoogleSignIn

 struct GoogleManagerUser {
    let token: String?
    let name: String?
    let email: String?
 }

// 832700470851-a7otksgpt4rj8dvkgoj891pnkvfku60j.apps.googleusercontent.com

 struct GoogleManager {
    // MARK: - Properties
    static let clientID = "832700470851-e9ug3e3drtcvdicvqkajv86q357vqch1.apps.googleusercontent.com"

    // MARK: - Public
    static func setup() {
        // Create Google Sign In configuration object.
        let config = GIDConfiguration(clientID: clientID)
        GIDSignIn.sharedInstance.configuration = config
    }

    static func handle(_ url: URL) {
        GIDSignIn.sharedInstance.handle(url)
    }

    static func signIn(completionHandler: @escaping (GoogleManagerUser) -> Void) {
        guard let controller = UIApplication.shared.firstKeyWindow?.rootViewController else {
            return
        }

        GIDSignIn.sharedInstance.signIn(withPresenting: controller) { signInResult, error in
            guard error == nil, let value = signInResult?.user else { return }
            let user = GoogleManagerUser(
                token: value.idToken?.tokenString,
                name: value.profile?.name,
                email: value.profile?.email
            )
            completionHandler(user)
        }
    }
 }
