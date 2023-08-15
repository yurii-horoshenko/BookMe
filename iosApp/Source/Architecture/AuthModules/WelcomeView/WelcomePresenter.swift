//
//  WelcomePresenter.swift
//  BookMeNow-Develop
//
//  Created by Yurii Goroshenko on 20.07.2023.
//

import SwiftUI

final class WelcomePresenter: ObservableObject {
    @Published var toCreateProfile = false
    @Published var toLogin = false

    // MARK: - Lifecycle
    deinit {
        printLog("deinit -> ", self)
    }
    
    // MARK: - Public
    func loginViaFacebook() {
        login()
    }
    
    func loginViaGoogle() {
        login()
    }
    
    func login() {
        toLogin = true
    }
    
    func createProfile() {
        toCreateProfile = true
    }
}
