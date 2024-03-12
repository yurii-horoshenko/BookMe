//
//  ProfileViewModel.swift
//  iosApp
//
//  Created by Yurii Goroshenko on 19.01.2024.
//

import shared
import SwiftUI

protocol ProfileViewModelProtocol: ObservableObject {
    var toLogoutConfirm: Bool { get set }
    var toSignIn: Bool { get set }
    var detectHeight: CGFloat { get set }
    var profile: Profile { get set }
    var view: ProfileViewProtocol? { get set }
    
    func logout()
}

final class ProfileViewModel: ProfileViewModelProtocol {
    // MARK: - Properties
    private let repository = shared.UserRepository()
    @Published var toLogoutConfirm = false
    @Published var toSignIn = false
    @Published var detectHeight: CGFloat = 0
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
