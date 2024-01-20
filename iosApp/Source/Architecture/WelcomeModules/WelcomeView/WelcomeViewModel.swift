//
//  WelcomeViewModel.swift
//  iosApp
//
//  Created by Yurii Goroshenko on 16.01.2024.
//

import shared
import SwiftUI

final class WelcomeViewModel: ObservableObject {
    // MARK: - Properties
    private let repository = shared.UserRepository()
    @Published var toLogin = false
    @Published var toSignIn = false
    
    // MARK: - Lifecycle
    deinit {
        printLog("deinit -> ", self)
    }
    
    // MARK: - Public
    func loginViaFacebook() {
        // FacebookSDK
        // RepositoryLogin
        
        repository.login { _, _ in
            printLog("")
        }
        
        toSignIn = true
    }
    
    func loginViaGoogle() {
        // GoogleSDK
        // RepositoryLogin
        
        toSignIn = true
        
    }
    
    func signIn() {
        toLogin = true
    }
}
