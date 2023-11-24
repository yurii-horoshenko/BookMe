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
    @ObservedObject var presenter = WelcomePresenter()
    
    // MARK: - Lifecycle
    var body: some View {
        NavigationStack {
            ContentView
                .navigationDestination(isPresented: $presenter.toLogin) {
                    LoginView()
                }
        }
    }
    
    // Image, title, buttons
    var ContentView: some View {
        VStack(spacing: 0.0) {
            Spacer()
            
            Images.Welcome
                .padding(EdgeInsets(top: 40.0, leading: 90.0, bottom: 0.0, trailing: 90.0))
            
            Spacer()
            
            Text(WELCOME.pageTitle.text)
                .attributed(.H1Bold)
                .padding(24.0)
            
            Spacer()
            
            ButtonsView
        }
        .background(Color.background)
    }
    
    // Login via Facebook, Google or Phone
    var ButtonsView: some View {
        VStack(spacing: 16.0, content: {
            AppBorderButton(
                state: .constant(.active),
                imageName: ICON.facebook.value,
                title: WELCOME.facebookButton.text,
                action: { presenter.loginViaFacebook() }
            )
            
            AppBorderButton(
                state: .constant(.active),
                imageName: ICON.google.value,
                title: WELCOME.googleButton.text,
                action: { 
                    presenter.loginViaGoogle()
                    setRootView(DashboardContainerView())
                }
            )
            
            ORView
            
            AppFilledButton(
                state: .constant(.active),
                title: WELCOME.signInButton.text,
                titleColor: Color.white,
                backgroundColor: Color.primary500,
                action: { presenter.createProfile() }
            )
            .navigationDestination(isPresented: $presenter.toCreateProfile) {
                CreateProfileView()
            }
        })
        .padding(24.0)
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
    WelcomeView()
}
