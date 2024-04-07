//
//  AuthPageBuilder.swift
//  iosApp
//
//  Created by Yurii Goroshenko on 16.01.2024.
//

import SwiftUI

enum AuthPageBuilder {
    // MARK: - Detect
    static func detectSplashNavigationView() -> any View {
        guard LocalManager.shared.kmmDefaults.isLoggedIn else {
            return detectAuthNavigationView()
        }
        
        return DashboardContainerView()
    }
    
    static func detectAuthNavigationView() -> any View {
        guard LocalManager.shared.kmmDefaults.wasTutorial else {
            return TutorialWelcomeModuleView()
        }
        
        return constructWelcomeView()
    }
    
    // MARK: - Construct
    static func constructSplashView() -> some View {
        let viewModel = SplashViewModel()
        let view = SplashView(viewModel: viewModel)
        return view
    }
    
    static func constructWelcomeView() -> some View {
        let viewModel = WelcomeViewModel()
        let view = WelcomeView(viewModel: viewModel)
        return view
    }
    
    static func constructEnterCodeView(phoneMask: String) -> some View {
        let viewModel = EnterCodeViewModel(phone: phoneMask)
        let view = EnterCodeView(viewModel: viewModel)
        viewModel.view = view
        return view
    }
}
