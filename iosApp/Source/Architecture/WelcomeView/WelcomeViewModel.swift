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
    var view: WelcomeViewProtocol? { get set }
    
    func loginViaFacebook()
    func loginViaGoogle()
    func signIn()
}

@Observable
final class WelcomeViewModel: WelcomeViewModelProtocol {
    // MARK: - Properties
    private let repository: ProfileRepositoryProtocol = ProfileRepository()
    var toLogin = false
    var toSignIn = false
    var profile: shared.ProfileModel?
    var view: WelcomeViewProtocol?
    
    // MARK: - Lifecycle
    deinit {
        printLog("deinit -> ", self)
    }
    
    // MARK: - Public
    func signIn() {
        toLogin = true
    }
    
    func loginViaFacebook() {
//        FacebookManager.loginWithFacebook { [weak self] facebookObject in
//            self?.profile = ProfileModel(
//                fullName: facebookObject.name ?? "",
//                birthday: 0,
//                gender: UserGenderType.other,
//                email: facebookObject.email ?? "",
//                phone: "",
//                facebookToken: facebookObject.token,
//                googleToken: nil,
//                isExist: false
//            )
//            
//            self?.login(facebookToken: facebookObject.token)
//        }
    }
    
    func loginViaGoogle() {
        GoogleManager.signIn { [weak self] googleObject in
            self?.profile = ProfileModel(
                fullName: googleObject.name ?? "",
                birthday: 0,
                gender: ProfileGenderType.other,
                phone: "",
                facebookToken: nil,
                googleToken: googleObject.token,
                isExist: false
            )
            
            self?.login(googleToken: googleObject.token)
        }
    }
}

// MARK: - Private
private extension WelcomeViewModel {
    func login(
        facebookToken: String? = nil,
        googleToken: String? = nil,
        phone: String? = nil
    ) {
        repository.validation(
            facebookToken: facebookToken,
            googleToken: googleToken,
            phone: phone
        ) { result, _ in
            DispatchQueue.main.async { [weak self] in
                result?
                    .onSuccess(result: { object in
                        guard let profile = object as? ProfileModel else { return }
                        
                        if profile.isExist {
                            let nextView = AuthPageBuilder.constructDashboardView()
                            self?.view?.moveToDashboard(view: nextView)
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
