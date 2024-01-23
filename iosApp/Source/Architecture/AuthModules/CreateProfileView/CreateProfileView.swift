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
                .navigationDestination(isPresented: $viewModel.toCode) {
                    let phone = viewModel.phone.value.phoneMask
                    AuthPageBuilder.constructEnterCodeView(phoneMask: phone)
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
            
            BottomButton
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
    
    // Button Continue
    var BottomButton: some View {
        AppFilledButton(
            state: .constant(.active),
            title: (viewModel.profile != nil) ? String(localized: "BUTTON-UPDATE") : String(localized: "BUTTON-CONTINUE"),
            titleColor: Color.white,
            backgroundColor: Color.primary500,
            action: { viewModel.codeVerification() }
        )
    }
}

#Preview {
    ProfilePageBuilder.constructCreateProfileView()
}
