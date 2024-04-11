//
//  SplashViewModel.swift
//  iosApp
//
//  Created by Yurii Goroshenko on 06.04.2024.
//

import shared

protocol SplashViewModelProtocol: ObservableObject {
    func detectPage(owner: SplashViewProtocol)
}

final class SplashViewModel: SplashViewModelProtocol {
    // MARK: - Properties
    private let repository: ProfileRepositoryProtocol = ServiceLocator.shared.profileRepository
    
    // MARK: - Lifecycle
    deinit {
        printLog("deinit -> ", self)
    }
    
    // MARK: - Public
    func detectPage(owner: SplashViewProtocol) {
        // Check is loggeIn
        guard LocalManager.shared.kmmDefaults.isLoggedIn else {
            // Check was tutorial
            guard LocalManager.shared.kmmDefaults.wasTutorial else {
                owner.setNextPage(view: TutorialWelcomeModuleView())
                return
            }
            
            // Move to Welcome Page
            owner.setNextPage(view: AuthPageBuilder.constructWelcomeView())
            return
        }
        
        repository.login { result, _ in
            DispatchQueue.main.async {
                result?
                    .onSuccess(result: { _ in
                        // Move to Dashboard Page
                        let view = AuthPageBuilder.constructDashboardView()
                        owner.setNextPage(view: view)
                    })?
                    .onError(result: { error in
                        print(error)
                        // Move to Welcome Page
                        owner.setNextPage(view: AuthPageBuilder.constructWelcomeView())
                    })
            }
        }
    }
}
