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
            BaseView(navigationTitle: CREATE_PROFILE.pageTitle.text, content: { ContentView })
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
            AppInputField(fieldData: $viewModel.fullname)
                .padding(.top, 24.0)
            
            BirthDayInputView(
                dateBirthday: $viewModel.dateBirthday
            )
            
            AppPhoneNumber(fieldData: $viewModel.phone)
            
            AppInputField(fieldData: $viewModel.gender, trailingView: Icons.ArrowDown.eraseToAnyView()) {
                viewModel.genderSelection()
            }
            .confirmationDialog(
                CREATE_PROFILE.genderTitle.text,
                isPresented: $viewModel.toGenderSelection,
                titleVisibility: .visible
            ) {
                Button(GENDER.male.text) {
                    viewModel.gender.value = GENDER.male.text
                    viewModel.gender.state = .active
                }
                
                Button(GENDER.female.text) {
                    viewModel.gender.value = GENDER.female.text
                    viewModel.gender.state = .active
                }
                
                Button(GENDER.other.text) {
                    viewModel.gender.value = GENDER.other.text
                    viewModel.gender.state = .active
                }
            }
            
            Spacer()
            
            BottomButton
        }
        .padding(defaultEdgeInsets)
    }
    
    // Button Continue
    var BottomButton: some View {
        AppFilledButton(
            state: .constant(.active),
            title: GENERAL.continue_.text,
            titleColor: Color.white,
            backgroundColor: Color.primary500,
            action: { viewModel.codeVerification() }
        )
    }
}

#Preview {
    ProfilePageBuilder.constructCreateProfileView()
}
