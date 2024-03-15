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
    
    var PageView: AnyView {
        switch self {
        case .splash:
            AnyView(AuthPageBuilder.constructSplashView())
            
        case .splashAfter:
            AnyView(AuthPageBuilder.detectSplashNavigationView())
            
        case .welcome:
            AnyView(AuthPageBuilder.constructWelcomeView())
            
        case .enterCode(let phone):
            AnyView(AuthPageBuilder.constructEnterCodeView(phoneMask: phone))
            
        case .createProfile:
            AnyView(ProfilePageBuilder.constructCreateProfileView())
            
        case .dashboard:
            AnyView(AuthPageBuilder.constructEnterCodeView(phoneMask: ""))

        }
    }
}
