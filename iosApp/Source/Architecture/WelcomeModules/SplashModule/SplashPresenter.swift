//
//  SplashPresenter.swift
//  iosApp
//
//  Created by Yurii Goroshenko on 16.01.2024.
//

import SwiftUI

protocol SplashPresenterProtocol {
    func detectNavigation()
}

final class SplashPresenter: SplashPresenterProtocol {
    // MARK: - Properties
    var view: SplashViewProtocol?
    
    // MARK: - Lifecycle
    deinit {
        printLog("deinit -> ", self)
    }
    
    func detectNavigation() {
        guard UserDefaultsManager.wasTutorial else {
            view?.moveToTutorialPage()
            return
        }
        
        view?.moveToWelcomePage()
    }
    
    func loadDashboard() {
        view?.moveToDashboardPage()
    }
}
