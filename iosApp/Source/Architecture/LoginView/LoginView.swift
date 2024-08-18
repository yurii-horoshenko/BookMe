//
//  LoginView.swift
//  BookMeNow-Develop
//
//  Created by Yurii Goroshenko on 15.08.2023.
//

import SwiftUI

protocol LoginViewProtocol {
    func moveToDashboard(view: some View)
}

struct LoginView<ViewModel>: View where ViewModel: LoginViewModelProtocol {
    // MARK: - Properties
    @State var viewModel: ViewModel
    
    // MARK: - Lifecycle
    var body: some View {
        NavigationView {
            BaseView(
                navigationTitle: String(localized: "LOGIN-TITLE"),
                content: { ContentView }
            )
            .navigationDestination(isPresented: $viewModel.toCode) {
                let phone = viewModel.phone.value
                AuthPageBuilder.constructEnterCodeView(phone: phone, newProfile: false)
            }
        }
        .navigationBarBackButtonHidden(true)
        .environment(\.colorScheme, .light)
    }
    
    var ContentView: some View {
        VStack {
            Spacer()
            
            AppPhoneNumber(
                fieldData: $viewModel.phone
            )
            
            Spacer()
            
            BottomButton
        }
        .padding(defaultEdgeInsets)
    }
    
    // Button Continue
    var BottomButton: some View {
        AppFilledButton(
            state: .constant(.active),
            title: String(localized: "BUTTON-LOGIN"),
            titleColor: Color.white,
            backgroundColor: Color.primary500,
            action: { viewModel.login() }
        )
    }
}

// MARK: - WelcomeViewProtocol
extension LoginView: LoginViewProtocol {
    func moveToDashboard(view: some View) {
        setRootView(view)
    }
}

#Preview {
    ProfilePageBuilder.constructLoginView()
}
