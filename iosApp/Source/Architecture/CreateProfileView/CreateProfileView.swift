//
//  CreateProfileView.swift
//  BookMeNow-Develop
//
//  Created by Yurii Goroshenko on 03.08.2023.
//

import shared
import SwiftUI

struct CreateProfileView<ViewModel>: View where ViewModel: CreateProfileViewModelProtocol {
    // MARK: - Properties
    @State var viewModel: ViewModel
    var title: String {
        viewModel.currentProfile.isExist
        ? String(localized: "UPDATE-PROFILE-TITLE")
        : String(localized: "CREATE-PROFILE-TITLE")
    }
    
    var nextButtonTitle: String {
        viewModel.currentProfile.isExist
        ? String(localized: "BUTTON-UPDATE")
        : String(localized: "BUTTON-CONTINUE")
    }
    
    // MARK: - Lifecycle
    var body: some View {
        NavigationView {
            BaseView(
                navigationTitle: title,
                content: { ContentView }
            )
            .navigationDestination(isPresented: $viewModel.toCode) {
                let phone = viewModel.phone.value
                AuthPageBuilder.constructEnterCodeView(phone: phone, newProfile: viewModel.isCreate)
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
            
            GenderInput
            
            AppInputField(
                fieldData: $viewModel.email
            )
            
            AppPhoneNumber(
                fieldData: $viewModel.phone
            )
            
            Spacer()
            
            BottomButton
        }
        .padding(defaultEdgeInsets)
    }
    
    var GenderInput: some View {
        AppInputField(
            fieldData: $viewModel.gender,
            trailingView: AnyView(Icons.ArrowDown),
            onTapPress: {
                viewModel.genderSelection()
            }
        )
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
            title: nextButtonTitle,
            titleColor: Color.white,
            backgroundColor: Color.primary500,
            action: { viewModel.codeVerification() }
        )
    }
}

#Preview {
    ProfilePageBuilder.constructCreateProfileView(
        profile: shared.ProfileModel(
            fullName: "",
            birthday: 0,
            gender: ProfileGenderType.other,
            phone: "",
            facebookToken: nil,
            googleToken: nil,
            isExist: false
        )
    )
}
