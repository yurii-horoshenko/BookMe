//
//  NavigationSteps.swift
//  iosApp
//
//  Created by Yurii Goroshenko on 11.03.2024.
//

import shared
import SwiftUI

enum Steps: Hashable {
    case splash
    case welcome
    case enterCode(String, Bool)
    case createProfile(ProfileModel)
    case updateProfile(ProfileModel)
    case dashboard
    
    @ViewBuilder var PageView: some View {
        switch self {
        case .splash:
            AuthPageBuilder.constructSplashView()
            
        case .welcome:
            AuthPageBuilder.constructWelcomeView()
            
        case let .enterCode(phone, newProfile):
            AuthPageBuilder.constructEnterCodeView(phone: phone, newProfile: newProfile)
            
        case .createProfile(let profile):
            ProfilePageBuilder.constructCreateProfileView(profile: profile)

        case .updateProfile(let profile):
            ProfilePageBuilder.constructUpdateProfileView(profile: profile)

        case .dashboard:
            DashboardPageBuilder.constructDashboardView()

        }
    }
}
