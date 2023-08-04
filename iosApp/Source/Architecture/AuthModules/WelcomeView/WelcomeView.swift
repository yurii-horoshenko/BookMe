//
//  WelcomeView.swift
//  BookMeNow-Develop
//
//  Created by Yurii Goroshenko on 20.07.2023.
//

import shared
import SwiftUI

struct WelcomeView: View, StateViewProtocol {
    @ObservedObject var presenter = WelcomePresenter()
    @State private var pushToCreateProfileFlow = false
    @State var state: StateView = .idle
    var nextView: AnyView?
    
    // MARK: - BODY
    var body: some View {
        NavigationView {
//            NavigationLink(destination: PhoneView(), isActive: $pushToPhoneFlow) {
                ContentView
//            }
        }
    }
    
    var ContentView: some View {
        VStack(spacing: 0.0) {
            Spacer()
            
            Image("img-welcome")
                .resizable()
                .scaledToFit()
                .padding(EdgeInsets(top: 40.0, leading: 90.0, bottom: 0.0, trailing: 90.0))
            
            Spacer()
            
            Text(WELCOME.pageTitle.text)
                .attributed(.H1Bold)
                .padding(24.0)
            
            Spacer()
            
            ButtonsView
        }
        .background(Color.background)
        .onAppear {
            withAnimation(.easeOut(duration: 0.75)) {
                state = .finished
            }
        }
    }
    
    var ButtonsView: some View {
        VStack(spacing: 16.0, content: {
            AppBorderButton(
                imageName: "ic-facebook",
                title: WELCOME.facebookButton.text,
                action: {
                    //                    self.setRootView(DashboardView())
                }
            )
            
            AppBorderButton(
                imageName: "ic-google",
                title: WELCOME.googleButton.text,
                action: {
                    //
                }
            )
            
            ORView
            
            NavigationLink(destination: CreateProfileView(), isActive: $pushToCreateProfileFlow) {
                AppButton(
                    state: .constant(.active),
                    title: WELCOME.signInButton.text,
                    titleColor: Color.white,
                    backgroundColor: Color.primary500,
                    action: {
                        self.pushToCreateProfileFlow = true
                    }
                )
            }
        })
        .padding(24.0)
    }
    
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
