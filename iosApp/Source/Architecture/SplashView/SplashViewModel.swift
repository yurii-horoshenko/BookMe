//
//  SplashViewModel.swift
//  iosApp
//
//  Created by Yurii Goroshenko on 06.04.2024.
//

import shared

protocol SplashViewModelProtocol: ObservableObject {
    var toLogin: Bool { get set }
    var toSignIn: Bool { get set }
    
    func detectPage()
}

final class SplashViewModel: SplashViewModelProtocol {
    // MARK: - Properties
    private let repository: UserRepositoryProtocol = ServiceLocator.shared.userRepository
    @Published var toLogin = false
    @Published var toSignIn = false
    
    // MARK: - Lifecycle
    deinit {
        printLog("deinit -> ", self)
    }
    
    // MARK: - Public
    func detectPage() {
        repository.login { result, _ in
            result?.onSuccess(result: { _ in
                print("")
            }).onError(result: { _, _ in
                print("")
            })
        }
    }
}
