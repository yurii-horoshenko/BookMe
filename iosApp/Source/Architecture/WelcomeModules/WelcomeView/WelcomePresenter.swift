//
//  WelcomePresenter.swift
//  BookMeNow-Develop
//
//  Created by Yurii Goroshenko on 20.07.2023.
//

import SwiftUI

protocol WelcomePresenterProtocol: ObservableObject {
    var toLogin: Bool { get set }
    var toCreateProfile: Bool { get set }
    
    func login()
    func signIn()
}

final class WelcomePresenter: WelcomePresenterProtocol {
    // MARK: - Properties
    @Published var toLogin = false
    @Published var toCreateProfile = false
    
    // MARK: - Lifecycle
    deinit {
        printLog("deinit -> ", self)
    }
    
    func login() {
        toLogin = true
    }
    
    func signIn() {
        toCreateProfile = true
    }
}
