//
//  NavigationSteps.swift
//  iosApp
//
//  Created by Yurii Goroshenko on 11.03.2024.
//

import SwiftUI

enum Steps: Hashable {
    case splash
    case splashAfter
    case welcome
    case enterCode(String)
    case createProfile
    case dashboard
    
    var PageView: some View {
        switch self {
        case .splash:
            AuthPageBuilder.constructSplashView().eraseToAnyView()
            
        case .splashAfter:
            AuthPageBuilder.detectSplashNavigationView().eraseToAnyView()
            
        case .welcome:
            AuthPageBuilder.constructWelcomeView().eraseToAnyView()
            
        case .enterCode(let phone):
            AuthPageBuilder.constructEnterCodeView(phoneMask: phone).eraseToAnyView()
            
        case .createProfile:
            ProfilePageBuilder.constructCreateProfileView().eraseToAnyView()
            
        case .dashboard:
            AuthPageBuilder.constructEnterCodeView(phoneMask: "").eraseToAnyView()

        }
    }
}
