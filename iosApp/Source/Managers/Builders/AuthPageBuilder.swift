//
//  AuthPageBuilder.swift
//  iosApp
//
//  Created by Yurii Goroshenko on 16.01.2024.
//

import SwiftUI

enum AuthPageBuilder {
    static func constructSplashView() -> some View {
        let viewModel = SplashViewModel()
        let view = SplashView(viewModel: viewModel)
        viewModel.view = view
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
        return view
    }
}
