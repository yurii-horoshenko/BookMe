//
//  CreateProfileView.swift
//  BookMeNow-Develop
//
//  Created by Yurii Goroshenko on 03.08.2023.
//

import shared
import SwiftUI

struct CreateProfileView: View {
    // MARK: - Properties
    @StateObject var viewModel: CreateProfileViewModel
    
    // MARK: - Lifecycle
    var body: some View {
        NavigationView {
            BaseView(
                navigationTitle: (viewModel.profile != nil) ? String(localized: "UPDATE-PROFILE-TITLE") : String(localized: "CREATE-PROFILE-TITLE"),
                content: { ContentView }
            )
//            .navigationDestination(isPresented: $viewModel.toCode) {
//                let phone = viewModel.phone.value.phoneMask
//                AuthPageBuilder.constructEnterCodeView(phoneMask: phone)
//            }
            .navigationDestination(for: Steps.self) { step in
                step.PageView
                
//                if step == .empty {
//                    let phone = viewModel.phone.value.phoneMask
//                    AuthPageBuilder.constructEnterCodeView(phoneMask: phone)
//                }
            }
        }
        .navigationBarBackButtonHidden(true)
        .environment(\.colorScheme, .light)
    }
    
    // Profile input fields, button
    var ContentView: some View {
        VStack(spacing: 24.0) {
            AppInputField(
                fieldData: $viewModel.fullname
            )
            .padding(.top, 24.0)
            
            BirthDayInputView(
                dateBirthday: $viewModel.dateBirthday
            )
            
            AppPhoneNumber(
                fieldData: $viewModel.phone
            )
            
            GenderInput
            
            Spacer()
            
            NavigationButton<Steps>(
                title: (viewModel.profile != nil) ? String(localized: "BUTTON-UPDATE") : String(localized: "BUTTON-CONTINUE"),
                navigationType: .enterCode(viewModel.phone.value.phoneMask)
            )
        }
        .padding(defaultEdgeInsets)
    }
    
    var GenderInput: some View {
        AppInputField(fieldData: $viewModel.gender, trailingView: Icons.ArrowDown.eraseToAnyView()) {
            viewModel.genderSelection()
        }
        .confirmationDialog(
            String(localized: "GENDER-TITLE"),
            isPresented: $viewModel.toGenderSelection,
            titleVisibility: .visible
        ) {
            Button(String(localized: "MALE")) {
                viewModel.gender.value = String(localized: "MALE")
                viewModel.gender.state = .active
            }
            
            Button(String(localized: "FEMALE")) {
                viewModel.gender.value = String(localized: "FEMALE")
                viewModel.gender.state = .active
            }
            
            Button(String(localized: "OTHER")) {
                viewModel.gender.value = String(localized: "OTHER")
                viewModel.gender.state = .active
            }
        }
    }
}

#Preview {
    ProfilePageBuilder.constructCreateProfileView()
}
