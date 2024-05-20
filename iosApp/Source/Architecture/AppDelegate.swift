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
        
        // Setup push notifications
        PermissionManager.shared.setupNotifications()
        
        // Setup
        HelperKtKt.doInitKoin()
        
        // Initialize Facebook SDK
        FBSDKCoreKit.ApplicationDelegate.shared.application(
            application,
            didFinishLaunchingWithOptions: launchOptions
        )
        return true
    }
    
    func application(_ application: UIApplication, didRegisterForRemoteNotificationsWithDeviceToken deviceToken: Data) {
        PermissionManager.shared.setupNotificationsToken(deviceToken, completionHandler: { _ in
            // send to server
            print("token")
        })
    }
}
