//
//  ProfilePageBuilder.swift
//  iosApp
//
//  Created by Yurii Goroshenko on 19.01.2024.
//

import shared
import SwiftUI

enum ProfilePageBuilder {
    static func constructProfileView() -> some View {
        let viewModel = ProfileViewModel()
        let view = ProfileView(viewModel: viewModel)
        return view
    }
    
    static func constructLoginView() -> some View {
        let viewModel = LoginViewModel()
        let view = LoginView(viewModel: viewModel)
        return view
    }
    
    static func constructCreateProfileView(profile: shared.ProfileModel) -> some View {
        let viewModel = CreateProfileViewModel(profile: profile, isCreate: true)
        let view = CreateProfileView(viewModel: viewModel)
        return view
    }
    
    static func constructUpdateProfileView(profile: shared.ProfileModel) -> some View {
        let viewModel = CreateProfileViewModel(profile: profile, isCreate: false)
        let view = CreateProfileView(viewModel: viewModel)
        return view
    }
}
