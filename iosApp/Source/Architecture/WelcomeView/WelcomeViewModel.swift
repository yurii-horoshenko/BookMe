//
//  WelcomeViewModel.swift
//  iosApp
//
//  Created by Yurii Goroshenko on 16.01.2024.
//

import shared

protocol WelcomeViewModelProtocol: ObservableObject {
    var toLogin: Bool { get set }
    var toSignIn: Bool { get set }
    
    func loginViaFacebook()
    func loginViaGoogle()
    func signIn()
}

final class WelcomeViewModel: WelcomeViewModelProtocol {
    // MARK: - Properties
    private let repository: ProfileRepositoryProtocol = ServiceLocator.shared.profileRepository
    @Published var toLogin = false
    @Published var toSignIn = false
    
    // MARK: - Lifecycle
    deinit {
        printLog("deinit -> ", self)
    }
    
    // MARK: - Public
    func signIn() {
        toLogin = true
    }
    
    func loginViaFacebook() {
        FacebookManager.loginWithFacebook { [weak self] facebookObject in
            self?.login(facebookToken: facebookObject.token)
        }
    }
    
    func loginViaGoogle() {
        GoogleManager.signIn { [weak self] googleObject in
            self?.login(facebookToken: googleObject.token)
        }
    }
}

// MARK: - Private
private extension WelcomeViewModel {
    func login(facebookToken: String? = nil, googleToken: String? = nil, phone: String? = nil) {
        repository.validation(facebookToken: facebookToken, googleToken: googleToken, phone: phone) { result, _ in
            DispatchQueue.main.async { [weak self] in
                result?
                    .onSuccess(result: { object in
                        let profile = object as? ProfileModel
                        // Navigate to Dashboard
                    })?
                    .onError(result: { error in
                        self?.toSignIn = true
                    })
            }
        }
    }
}
