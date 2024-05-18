//
//  AppDelegate.swift
//  iosApp
//
//  Created by Yurii Goroshenko on 12.04.2024.
//

import FBSDKCoreKit
import shared
import UIKit

class AppDelegate: NSObject, UIApplicationDelegate {
    func application(
        _ application: UIApplication,
        didFinishLaunchingWithOptions launchOptions: [UIApplication.LaunchOptionsKey: Any]?
    ) -> Bool {
        
        // Setup
        HelperKtKt.doInitKoin()
        
        // Initialize Facebook SDK
        FBSDKCoreKit.ApplicationDelegate.shared.application(
            application,
            didFinishLaunchingWithOptions: launchOptions
        )
        return true
    }
}
