//
//  BookMeNowApp.swift
//  BookMeNow
//
//  Created by Yurii Goroshenko on 19.07.2023.
//

import shared
import SwiftUI

@main
struct BookMeNowApp: App {
    var body: some Scene {
        WindowGroup {
            ModelViewBuilder.constructSplashView()
        }
    }
}
