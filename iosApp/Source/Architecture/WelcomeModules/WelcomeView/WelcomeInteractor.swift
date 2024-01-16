//
//  WelcomeInteractor.swift
//  iosApp
//
//  Created by Yurii Goroshenko on 16.01.2024.
//

import SwiftUI

protocol WelcomeInteractorProtocol {
    func loginViaGoogle()
    func loginViaFacebook()
    func signIn()
}

final class WelcomeInteractor: ObservableObject, WelcomeInteractorProtocol {
    // MARK: - Properties
    var presenter = WelcomePresenter()
    
    // MARK: - Public
    func loginViaFacebook() {
        // FacebookSDK
        // RepositoryLogin
        
        presenter.login()
    }
    
    func loginViaGoogle() {
        // GoogleSDK
        // RepositoryLogin
        
        presenter.login()
    }
    
    func signIn() {
        presenter.signIn()
    }
}
