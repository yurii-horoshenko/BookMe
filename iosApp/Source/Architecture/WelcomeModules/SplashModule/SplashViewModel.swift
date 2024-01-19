//
//  SplashViewModel.swift
//  iosApp
//
//  Created by Yurii Goroshenko on 16.01.2024.
//

import shared
import SwiftUI

final class SplashViewModel: ObservableObject {
    // MARK: - Properties
    private let repository = shared.UserRepository()
    var view: SplashViewProtocol?
    
    // MARK: - Lifecycle
    deinit {
        printLog("deinit -> ", self)
    }
    
    // MARK: - Init
    func detectNavigation() {
        guard UserDefaultsManager.isLoggined else {
            detectAuthNavigation()
            return
        }
        
        // load data
        view?.moveToDashboardPage()
    }
    
    func detectAuthNavigation() {
        guard UserDefaultsManager.wasTutorial else {
            view?.moveToTutorialPage()
            return
        }
        
        view?.moveToWelcomePage()
    }
}
