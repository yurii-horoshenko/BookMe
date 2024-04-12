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
    
    func login(sender: LoginViewProtocol)
}

final class LoginViewModel: LoginViewModelProtocol {
    // MARK: - Properties
    private let repository: ProfileRepositoryProtocol = ServiceLocator.shared.profileRepository
    @Published var phone = FieldData(placeholder: "Phone Number")
    @Published var toCode = false
    
    // MARK: - Lifecycle
    deinit {
        printLog("deinit -> ", self)
    }
    
    // MARK: - Public
    func login(sender: LoginViewProtocol) {
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
                            let view = AuthPageBuilder.constructDashboardView()
                            sender.moveToDashboard(view: view)
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
