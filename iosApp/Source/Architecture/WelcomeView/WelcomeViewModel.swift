//
//  WelcomeViewModel.swift
//  iosApp
//
//  Created by Yurii Goroshenko on 16.01.2024.
//

import shared

protocol WelcomeViewModelProtocol: ObservableObject {
    var profile: shared.ProfileModel? { get set }
    var toLogin: Bool { get set }
    var toSignIn: Bool { get set }
    
    func loginViaFacebook(sender: WelcomeViewProtocol)
    func loginViaGoogle(sender: WelcomeViewProtocol)
    func signIn()
}

final class WelcomeViewModel: WelcomeViewModelProtocol {
    // MARK: - Properties
    private let repository: ProfileRepositoryProtocol = ServiceLocator.shared.profileRepository
    @Published var toLogin = false
    @Published var toSignIn = false
    var profile: shared.ProfileModel?
    
    // MARK: - Lifecycle
    deinit {
        printLog("deinit -> ", self)
    }
    
    // MARK: - Public
    func signIn() {
        toLogin = true
    }
    
    func loginViaFacebook(sender: WelcomeViewProtocol) {
        FacebookManager.loginWithFacebook { [weak self] facebookObject in
            self?.profile = ProfileModel(
                fullName: facebookObject.name ?? "",
                birthday: 0,
                gender: UserGenderType.other,
                email: facebookObject.email ?? "",
                phone: "",
                facebookToken: facebookObject.token,
                googleToken: nil,
                isExist: false
            )
            
            self?.login(facebookToken: facebookObject.token, sender: sender)
        }
    }
    
    func loginViaGoogle(sender: WelcomeViewProtocol) {
        GoogleManager.signIn { [weak self] googleObject in
            self?.profile = ProfileModel(
                fullName: googleObject.name ?? "",
                birthday: 0,
                gender: UserGenderType.other,
                email: googleObject.email ?? "",
                phone: "",
                facebookToken: nil,
                googleToken: googleObject.token,
                isExist: false
            )

            self?.login(facebookToken: googleObject.token, sender: sender)
        }
    }
}

// MARK: - Private
private extension WelcomeViewModel {
    func login(facebookToken: String? = nil, googleToken: String? = nil, phone: String? = nil, sender: WelcomeViewProtocol) {
        repository.validation(facebookToken: facebookToken, googleToken: googleToken, phone: phone) { result, _ in
            DispatchQueue.main.async { [weak self] in
                result?
                    .onSuccess(result: { object in
                        guard let profile = object as? ProfileModel else { return }
                        
                        if profile.isExist {
                            let view = AuthPageBuilder.constructDashboardView()
                            sender.moveToDashboard(view: view)
                        } else {
                            self?.toSignIn = true
                        }
                    })?
                    .onError(result: { _ in
                        self?.toSignIn = true
                    })
            }
        }
    }
}
