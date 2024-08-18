//
//  SplashViewModel.swift
//  iosApp
//
//  Created by Yurii Goroshenko on 06.04.2024.
//

import shared

protocol SplashViewModelProtocol: ObservableObject {
    var view: SplashViewProtocol? { get set }
    
    func detectPage()
}

@Observable
final class SplashViewModel: SplashViewModelProtocol {
    // MARK: - Properties
    private let repository: ProfileRepositoryProtocol = ProfileRepository()
    var view: SplashViewProtocol?
    
    // MARK: - Lifecycle
    deinit {
        printLog("deinit -> ", self)
    }
    
    // MARK: - Public
    func detectPage() {
        // Check is loggeIn
//        guard LocalManager.shared.kmmDefaults.isLoggedIn else {
//            // Check was tutorial
//            guard LocalManager.shared.kmmDefaults.wasTutorial else {
//                view?.setNextPage(view: TutorialWelcomeModuleView())
//                return
//            }
//            
//            // Move to Welcome Page
//            view?.setNextPage(view: AuthPageBuilder.constructWelcomeView())
//            return
//        }
        
//        repository.login { result, _ in
//            DispatchQueue.main.async { [weak self] in
//                result?
//                    .onSuccess(result: { _ in
//                        // Move to Dashboard Page
//                        let nextView = AuthPageBuilder.constructDashboardView()
//                        self?.view?.setNextPage(view: nextView)
//                    })?
//                    .onError(result: { error in
//                        print(error)
//                        // Move to Welcome Page
//                        self?.view?.setNextPage(view: AuthPageBuilder.constructWelcomeView())
//                    })
//            }
//        }
        
        view?.setNextPage(view: AuthPageBuilder.constructWelcomeView())
    }
}
