//
//  WelcomeView.swift
//  BookMeNow-Develop
//
//  Created by Yurii Goroshenko on 20.07.2023.
//

import GoogleSignIn
import SwiftUI

protocol WelcomeViewProtocol {
    func moveToDashboard(view: some View)
}

struct WelcomeView<ViewModel>: View where ViewModel: WelcomeViewModelProtocol {
    // MARK: - Properties
    @StateObject var viewModel: ViewModel
    
    // MARK: - Lifecycle
    var body: some View {
        NavigationStack {
            ContentView
                .navigationDestination(isPresented: $viewModel.toLogin) {
                    ProfilePageBuilder.constructLoginView()
                }
                .navigationDestination(isPresented: $viewModel.toSignIn) {
                    ProfilePageBuilder.constructCreateProfileView()
                }
        }
    }
    
    // Image, title, buttons
    var ContentView: some View {
        VStack(spacing: 0.0) {
            Spacer()
            
            Images.Welcome
            
            Spacer()
            
            Text(String(localized: "WELCOME-TITLE"))
                .attributed(.H1Bold)
            
            Spacer()
            
            ButtonsView
        }
        .padding(defaultEdgeInsets)
        .background(Color.background)
    }
    
    // Login via Facebook, Google or Phone
    var ButtonsView: some View {
        VStack(spacing: 16.0, content: {
            AppBorderButton(
                state: .constant(.active),
                imageName: "ic-facebook",
                title: String(localized: "BUTTON-FACEBOOK"),
                action: { viewModel.loginViaFacebook() }
            )
            
            AppBorderButton(
                state: .constant(.active),
                imageName: "ic-google",
                title: String(localized: "BUTTON-GOOGLE"),
                action: { viewModel.loginViaGoogle() }
            )
            
            ORView
            
            AppFilledButton(
                state: .constant(.active),
                title: String(localized: "BUTTON-SIGNIN"),
                titleColor: Color.white,
                backgroundColor: Color.primary500,
                action: { viewModel.signIn() }
            )
        })
    }
    
    // OR label
    var ORView: some View {
        HStack(spacing: 16.0) {
            Rectangle()
                .frame(height: 1.0)
            
            Text(String(localized: "OR"))
                .font(Font.BodyXLargeSemibold)
                .foregroundColor(Color.greyscale900)
            
            Rectangle()
                .frame(height: 1.0)
        }
        .foregroundColor(Color.greyscale200)
    }
}

// MARK: - WelcomeViewProtocol
extension WelcomeView: WelcomeViewProtocol {
    func moveToDashboard(view: some View) {
        setRootView(view)
    }
}

#Preview {
    Steps.welcome.PageView
}
