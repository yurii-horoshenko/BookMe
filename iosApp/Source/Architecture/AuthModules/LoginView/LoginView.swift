//
//  LoginView.swift
//  BookMeNow-Develop
//
//  Created by Yurii Goroshenko on 15.08.2023.
//

import shared
import SwiftUI

struct LoginView: View {
    // MARK: - Properties
    @ObservedObject var presenter = CreateProfilePresenter()
    
    // MARK: - Lifecycle
    var body: some View {
        NavigationView {
            BaseView(navigationTitle: LOGIN.pageTitle.text, content: { ContentView })
                .navigationDestination(isPresented: $presenter.toCodeVerification) {
                    EnterCodeView(phone: presenter.phone.value.phoneMask)
                }
        }
        .navigationBarBackButtonHidden(true)
        .environment(\.colorScheme, .light)
    }
    
    var ContentView: some View {
        VStack {
            Spacer()
            AppPhoneNumber(fieldData: $presenter.phone)
            Spacer()
            BottomButton
        }
        .padding(defaultEdgeInsets)
    }
    
    // Button Continue
    var BottomButton: some View {
        AppFilledButton(
            state: .constant(.active),
            title: LOGIN.signInButton.text,
            titleColor: Color.white,
            backgroundColor: Color.primary500,
            action: { presenter.codeVerification() }
        )
    }
}

#Preview {
    LoginView()
}
