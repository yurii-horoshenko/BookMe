//
//  BookMeNowApp.swift
//  BookMeNow
//
//  Created by Yurii Goroshenko on 19.07.2023.
//

import GoogleSignIn
import SwiftUI

@main
struct BookMeNowApp: App {
    var body: some Scene {
        WindowGroup {
            AuthPageBuilder.constructSplashView()
                .onOpenURL { url in
                    GoogleManager.handle(url)
                }
        }
    }
}

// MARK: - Splash Page
struct SplashView: View {
    // MARK: - Lifecycle
    var body: some View {
        VStack {
            Spacer()
            
            Text(String(localized: "APP-NAME"))
                .attributed(.H0Bold, color: Color.primary500)
                .padding(24.0)
            
            Spacer()
        }
        .ignoresSafeArea(.all)
        .background(Color.background)
        .onAppear {
            setRootView(Steps.splashAfter.PageView)
        }
    }
}

#Preview {
    Steps.splash.PageView
}
