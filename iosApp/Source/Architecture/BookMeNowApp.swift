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
    @UIApplicationDelegateAdaptor(AppDelegate.self) 
    var appDelegate
    
    var body: some Scene {
        WindowGroup {
            AuthPageBuilder.constructSplashView()
                .onOpenURL { url in
                    GoogleManager.handle(url)
                }
        }
    }
}
