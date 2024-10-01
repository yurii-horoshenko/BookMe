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
    var profile: shared.ProfileModel { get set }
    var view: ProfileViewProtocol? { get set }
    
    func loadData()
    func logout()
}

@Observable
final class ProfileViewModel: ProfileViewModelProtocol {
    // MARK: - Properties
    private let repository: ProfileRepositoryProtocol = ProfileRepository()
    var toLogoutConfirm = false
    var toSignIn = false
    var detectHeight: CGFloat = 0
    var profile: shared.ProfileModel = ProfileModel(fullName: "", birthday: 0, gender: .other, phone: "", facebookToken: nil, googleToken: nil, isExist: false)
    var view: ProfileViewProtocol?
    
    // MARK: - Lifecycle
    deinit {
        printLog("deinit -> ", self)
    }
    
    func loadData() {
//        repository.getProfile { [weak self] result, error in
//            guard let profile = result as? ProfileModel else { return }
//            self?.profile = profile
//        }
    }
    
    func logout() {
        view?.logout()
    }
}
