//
//  NavigationSteps.swift
//  iosApp
//
//  Created by Yurii Goroshenko on 11.03.2024.
//

import SwiftUI

enum Steps: Hashable {
    case splash
    case welcome
    case enterCode(String)
    case createProfile
    case dashboard
    
    @ViewBuilder var PageView: some View {
        switch self {
        case .splash:
            AuthPageBuilder.constructSplashView()
            
        case .welcome:
            AuthPageBuilder.constructWelcomeView()
            
        case .enterCode(let phone):
            AuthPageBuilder.constructEnterCodeView(phoneMask: phone)
            
        case .createProfile:
            ProfilePageBuilder.constructCreateProfileView()
            
        case .dashboard:
            AuthPageBuilder.constructEnterCodeView(phoneMask: "")

        }
    }
}
