//
//  ModelViewBuilder.swift
//  iosApp
//
//  Created by Yurii Goroshenko on 16.01.2024.
//

import SwiftUI

struct ModelViewBuilder {
    
    static func constructSplashView() -> some View {
        let presenter = SplashPresenter()
        let interactor = SplashInteractor()
        let view = SplashView(interactor: interactor)
        interactor.presenter = presenter
        presenter.view = view
        
        return view
    }
    
    static func constructWelcomeView() -> some View {
        let presenter = WelcomePresenter()
        let interactor = WelcomeInteractor()
        let view = WelcomeView(interactor: interactor, presenter: presenter)
        interactor.presenter = presenter
        
        return view
    }
}
