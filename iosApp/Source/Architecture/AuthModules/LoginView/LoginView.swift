//
//  LoginView.swift
//  BookMeNow-Develop
//
//  Created by Yurii Goroshenko on 15.08.2023.
//

import shared
import SwiftUI

struct LoginView: View {
    @ObservedObject var presenter = CreateProfilePresenter()
    
    var body: some View {
        NavigationView {
            BaseView(navigationTitle: LOGIN.pageTitle.text, content: { ContentView })
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
        AppButton(
            state: .constant(.active),
            title: LOGIN.signInButton.text,
            titleColor: Color.white,
            backgroundColor: Color.primary500,
            action: { presenter.codeVerification() }
        )
        .navigationDestination(isPresented: $presenter.toCodeVerification) {
            EnterCodeView(phone: presenter.phone.value.phoneMask)
        }
    }
}

struct LoginView_Previews: PreviewProvider {
    static var previews: some View {
        LoginView()
    }
}
