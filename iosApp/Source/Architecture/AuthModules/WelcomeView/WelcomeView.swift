//
//  WelcomeView.swift
//  BookMeNow-Develop
//
//  Created by Yurii Goroshenko on 20.07.2023.
//

import shared
import SwiftUI

struct WelcomeView: View {
    private let imageInsets = EdgeInsets(top: 40.0, leading: 90.0, bottom: 0.0, trailing: 90.0)
    @ObservedObject var presenter = WelcomePresenter()
    
    // MARK: - BODY
    var body: some View {
        NavigationView {
            NavigationLink(destination: LoginView(), isActive: $presenter.toLogin) {
                ContentView
            }
        }
    }
    
    // Image, title, buttons
    var ContentView: some View {
        VStack(spacing: 0.0) {
            Spacer()
            
            Images.Welcome
                .padding(imageInsets)
            
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
            AppBorderButton(imageName: ICON.facebook.value, title: WELCOME.facebookButton.text) {
                presenter.login()
            }
            
            AppBorderButton(imageName: ICON.google.value, title: WELCOME.googleButton.text) {
                presenter.login()
            }
            
            ORView
            
            NavigationLink(destination: CreateProfileView(), isActive: $presenter.toCreateProfile) {
                AppButton(
                    state: .constant(.active),
                    title: WELCOME.signInButton.text,
                    titleColor: Color.white,
                    backgroundColor: Color.primary500,
                    action: {
                        presenter.createProfile()
                    }
                )
            }
        })
        .padding(24.0)
    }
    
    // OR label
    var ORView: some View {
        HStack(spacing: 16.0) {
            Rectangle()
                .frame(height: 1.0)
                .foregroundColor(Color.greyscale200)
            
            Text(shared.GENERAL.or_.text)
                .font(Font.BodyXLargeSemibold)
                .foregroundColor(Color.greyscale900)
            
            Rectangle()
                .frame(height: 1.0)
                .foregroundColor(Color.greyscale200)
        }
    }
}

struct WelcomeView_Previews: PreviewProvider {
    static var previews: some View {
        WelcomeView()
    }
}
