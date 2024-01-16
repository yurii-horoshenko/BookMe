//
//  SplashInteractor.swift
//  iosApp
//
//  Created by Yurii Goroshenko on 16.01.2024.
//

import Foundation

protocol SplashInteractorProtocol {
    var presenter: SplashPresenterProtocol? { get set }
    
    func detectNavigation()
}

final class SplashInteractor: SplashInteractorProtocol {
    // MARK: - Properties
    var presenter: SplashPresenterProtocol?
    
    // MARK: - Lifecycle
    deinit {
        printLog("deinit -> ", self)
    }
    
    // MARK: - Init
    func detectNavigation() {
        guard UserDefaultsManager.isLoggined else {
            presenter?.detectNavigation()
            return
        }
        
        // load data
        presenter?.detectNavigation()
    }
}
