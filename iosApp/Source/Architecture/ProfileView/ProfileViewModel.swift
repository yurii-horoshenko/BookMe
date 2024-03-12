//
//  ProfileViewModel.swift
//  iosApp
//
//  Created by Yurii Goroshenko on 19.01.2024.
//

import shared
import SwiftUI

final class ProfileViewModel: ObservableObject {
    // MARK: - Properties
    private let repository = shared.UserRepository()
    @Published var toLogoutConfirm = false
    @Published var toSignIn = false
    var profile = Profile()
    var view: ProfileViewProtocol?
    
    // MARK: - Lifecycle
    deinit {
        printLog("deinit -> ", self)
    }
    
    func logout() {
        view?.logout()
    }
}
