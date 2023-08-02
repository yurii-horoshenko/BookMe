//
//  SplashView.swift
//  BookMeNow
//
//  Created by Yurii Goroshenko on 19.07.2023.
//

import SwiftUI

struct SplashView: View {
    var body: some View {
        VStack {
            Spacer()
            ContentView
            Spacer()
        }
        .background(Color.brandDarkColor)
        .onAppear {
            DispatchQueue.main.asyncAfter(deadline: .now() + 2.0) {
                self.setRootView(WelcomeView())
            }
        }
    }
    
    var ContentView: some View {
        Image("splash")
            .resizable()
            .scaledToFit()
    }
}

struct SplashView_Previews: PreviewProvider {
    static var previews: some View {
        SplashView()
    }
}
