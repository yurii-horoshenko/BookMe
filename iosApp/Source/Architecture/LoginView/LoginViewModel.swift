//
//  LoginViewModel.swift
//  iosApp
//
//  Created by Yurii Goroshenko on 19.01.2024.
//

import shared

protocol LoginViewModelProtocol: ObservableObject {
    var phone: FieldData { get set }
    var toCode: Bool { get set }
    var view: LoginViewProtocol? { get set }
    
    func login()
}

final class LoginViewModel: LoginViewModelProtocol {
    // MARK: - Properties
    private let repository: ProfileRepositoryProtocol = ServiceLocator.shared.profileRepository
    @Published var phone = FieldData(placeholder: "Phone Number")
    @Published var toCode = false
    var view: LoginViewProtocol?
    
    // MARK: - Lifecycle
    deinit {
        printLog("deinit -> ", self)
    }
    
    // MARK: - Public
    func login() {
        repository.validation(
            facebookToken: nil,
            googleToken: nil,
            phone: phone.value
        ) { result, _ in
            DispatchQueue.main.async { [weak self] in
                result?
                    .onSuccess(result: { object in
                        guard let profile = object as? ProfileModel else { return }
                        
                        if profile.isExist {
                            let nextView = AuthPageBuilder.constructDashboardView()
                            self?.view?.moveToDashboard(view: nextView)
                        } else {
                            self?.toCode = true
                        }
                    })?
                    .onError(result: { _ in
                        // Error
                    })
            }
        }
    }
}
