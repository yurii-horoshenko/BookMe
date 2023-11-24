//
//  WelcomePresenter.swift
//  BookMeNow-Develop
//
//  Created by Yurii Goroshenko on 20.07.2023.
//

import SwiftUI

final class WelcomePresenter: ObservableObject {
    // MARK: - Properties
    @Published var toCreateProfile = false
    @Published var toLogin = false

    // MARK: - Lifecycle
    deinit {
        printLog("deinit -> ", self)
    }
    
    private func login() {
        toLogin = true
    }

    // MARK: - Public
    func createProfile() {
        toCreateProfile = true
    }
    
    func loginViaFacebook() {
        login()
    }
    
    func loginViaGoogle() {
        login()
    }
}
