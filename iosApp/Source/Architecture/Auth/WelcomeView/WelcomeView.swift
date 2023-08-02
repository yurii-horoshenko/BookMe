//
//  WelcomeView.swift
//  BookMeNow-Develop
//
//  Created by Yurii Goroshenko on 20.07.2023.
//

import shared
import SwiftUI

struct WelcomeView: View, StateViewProtocol {
    private var presenter = WelcomePresenter()
    @State private var pushToPhoneFlow = false
    @State var state: StateView = .idle
    
    // MARK: - BODY
    var body: some View {
        NavigationView {
            NavigationLink(destination: PhoneView(), isActive: $pushToPhoneFlow) {
                ContentView
            }
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
            
            Text("Let’s you in")
                .attributed(.H1Bold)
                .padding(24.0)
            
            Spacer()
            
            ButtonsView
        }
        .background(Color.white)
        .onAppear {
            withAnimation(.easeOut(duration: 0.75)) {
                state = .finished
            }
        }
    }
    
    var ButtonsView: some View {
        VStack(spacing: 16.0, content: {
            AppBorderButton(
                state: .constant(.active),
                imageName: "ic-facebook",
                title: "Continue with Facebook",
                action: {
                    //                    self.setRootView(DashboardView())
                }
            )
            
            AppBorderButton(
                state: .constant(.active),
                imageName: "ic-google",
                title: "Continue with Google",
                action: {
                    //
                }
            )
            
            ORView
            
            AppButton(
                state: .constant(.active),
                title: "Sign in with password",
                titleColor: Color.white,
                backgroundColor: Color.gradientOrange,
                action: {
                    //
                }
            )
        })
        .padding(24.0)
    }
    
    var ORView: some View {
        HStack(spacing: 16.0) {
            Rectangle()
                .frame(height: 1.0)
                .foregroundColor(Color.greyscale200)
            
            Text("or")
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
