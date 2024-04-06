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
    private let repository: UserRepositoryProtocol = shared.UserRepository(remote: UserRemoteDataSource(client: KtorManager.shared.client))
    @Published var toLogin = false
    @Published var toSignIn = false
    
    // MARK: - Lifecycle
    deinit {
        printLog("deinit -> ", self)
    }
    
    // MARK: - Public
    func detectPage() {
        repository.login { result, error in
            switch result {
            case is ResultWrapperSuccess<ProfileModel>:
                let object = (result as? ResultWrapperSuccess<ProfileModel>)?.value
                printLog("How")
                
            case is ResultWrapperError:
                printLog("How")
                
            default:
                break
            }
        }
    }
}



