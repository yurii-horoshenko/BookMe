//
//  WelcomeView.swift
//  BookMeNow-Develop
//
//  Created by Yurii Goroshenko on 20.07.2023.
//

import shared
import SwiftUI

struct WelcomeView: View {
    // MARK: - Properties
    @StateObject var viewModel: WelcomeViewModel
    
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
            
            Text(WELCOME.pageTitle.text)
                .attributed(.H1Bold)
                .padding(24.0)
            
            Spacer()
            
            ButtonsView
        }
        .padding(24.0)
        .background(Color.background)
    }
    
    // Login via Facebook, Google or Phone
    var ButtonsView: some View {
        VStack(spacing: 16.0, content: {
            AppBorderButton(
                state: .constant(.active),
                imageName: "ic-facebook",
                title: WELCOME.facebookButton.text,
                action: { viewModel.loginViaFacebook() }
            )
            
            AppBorderButton(
                state: .constant(.active),
                imageName: "ic-google",
                title: WELCOME.googleButton.text,
                action: { viewModel.loginViaGoogle() }
            )
            
            ORView
            
            AppFilledButton(
                state: .constant(.active),
                title: WELCOME.signInButton.text,
                titleColor: Color.white,
                backgroundColor: Color.primary500,
                action: { viewModel.signIn() }
            )
        })
        .padding(.horizontal, 6.0)
    }
    
    // OR label
    var ORView: some View {
        HStack(spacing: 16.0) {
            Rectangle()
                .frame(height: 1.0)
            
            Text(shared.GENERAL.or_.text)
                .font(Font.BodyXLargeSemibold)
                .foregroundColor(Color.greyscale900)
            
            Rectangle()
                .frame(height: 1.0)
        }
        .foregroundColor(Color.greyscale200)
    }
}

#Preview {
    AuthPageBuilder.constructWelcomeView()
}
