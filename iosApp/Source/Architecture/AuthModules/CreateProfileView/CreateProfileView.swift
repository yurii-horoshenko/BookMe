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
//    @Binding var path: NavigationPath
    @StateObject var presenter = CreateProfilePresenter()
    
    // MARK: - Lifecycle
    var body: some View {
        NavigationView {
            BaseView(navigationTitle: CREATE_PROFILE.pageTitle.text, content: { ContentView })
                .navigationDestination(isPresented: $presenter.toCodeVerification) {
                    EnterCodeView(phone: presenter.phone.value.phoneMask)
                }
        }
        .navigationBarBackButtonHidden(true)
        .environment(\.colorScheme, .light)
    }
    
    // Profile input fields, button
    var ContentView: some View {
        VStack(spacing: 24.0) {
            AppInputField(fieldData: $presenter.fullname)
                .padding(.top, 24.0)
            
            BirthDayInputView(
                dateBirthday: $presenter.dateBirthday
            )
            
            AppPhoneNumber(fieldData: $presenter.phone)
            
            AppInputField(fieldData: $presenter.gender, trailingView: Icons.ArrowDown.eraseToAnyView()) {
                presenter.genderSelection()
            }
            .confirmationDialog(CREATE_PROFILE.genderTitle.text, isPresented: $presenter.toGenderSelection, titleVisibility: .visible) {
                Button(GENDER.male.text) {
                    presenter.gender.value = GENDER.male.text
                    presenter.gender.state = .active
                }
                
                Button(GENDER.female.text) {
                    presenter.gender.value = GENDER.female.text
                    presenter.gender.state = .active
                }
                
                Button(GENDER.other.text) {
                    presenter.gender.value = GENDER.other.text
                    presenter.gender.state = .active
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
            action: { presenter.codeVerification() }
        )
    }
}

#Preview {
    CreateProfileView()
}
