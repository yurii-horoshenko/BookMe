//
//  ProfileViewModel.swift
//  iosApp
//
//  Created by Yurii Goroshenko on 19.01.2024.
//

import shared

protocol ProfileViewModelProtocol: ObservableObject {
    var toLogoutConfirm: Bool { get set }
    var toSignIn: Bool { get set }
    var detectHeight: CGFloat { get set }
    var profile: shared.ProfileModel? { get set }
    var view: ProfileViewProtocol? { get set }
    
    func loadData()
    func logout()
}

final class ProfileViewModel: ProfileViewModelProtocol {
    // MARK: - Properties
    private let repository: ProfileRepositoryProtocol = ServiceLocator.shared.profileRepository
    @Published var toLogoutConfirm = false
    @Published var toSignIn = false
    @Published var detectHeight: CGFloat = 0
    @Published var profile: shared.ProfileModel?
    var view: ProfileViewProtocol?
    
    // MARK: - Lifecycle
    deinit {
        printLog("deinit -> ", self)
    }
    
    func loadData() {
        repository.getProfile { [weak self] profile, _ in
            self?.profile = profile
        }
    }
    
    func logout() {
        view?.logout()
    }
}
