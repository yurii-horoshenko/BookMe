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
    @StateObject var viewModel: LoginViewModel
    
    // MARK: - Lifecycle
    var body: some View {
        NavigationView {
            BaseView(navigationTitle: LOGIN.pageTitle.text, content: { ContentView })
            .navigationDestination(isPresented: $viewModel.toCode) {
                let phone = viewModel.phone.value.phoneMask
                AuthPageBuilder.constructEnterCodeView(phoneMask: phone)
            }
        }
        .navigationBarBackButtonHidden(true)
        .environment(\.colorScheme, .light)
    }
    
    var ContentView: some View {
        VStack {
            Spacer()
            
            AppPhoneNumber(fieldData: $viewModel.phone)
            
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
            action: { viewModel.codeVerification() }
        )
    }
}

#Preview {
    ProfilePageBuilder.constructLoginView()
}
