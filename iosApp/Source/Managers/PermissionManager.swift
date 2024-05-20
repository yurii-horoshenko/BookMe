//
//  PermissionManager.swift
//  iosApp
//
//  Created by Yurii Goroshenko on 20.05.2024.
//

import FirebaseCore
import FirebaseMessaging
import Foundation

final class PermissionManager: NSObject {
    static let shared = PermissionManager()
    
    // MARK: - Public functions
    func setupNotifications() {
        // Use Firebase library to configure APIs
        FirebaseApp.configure()
    }
    
    func setupNotificationsToken(_ token: Data, completionHandler: @escaping (String) -> Void) {
        Messaging.messaging().apnsToken = token
        Messaging.messaging().token { token, error in
            if let error {
                debugPrint("🔥🔥🔥 Error fetching FCM registration token: \(error)")
            } else if let token {
                debugPrint("🔥🔥🔥FCM registration token: \(token)")
                completionHandler(token)
            }
        }
    }
    
    func registerForRemoteNotifications() {
        UNUserNotificationCenter.current().delegate = self
        
        let authOptions: UNAuthorizationOptions = [.alert, .badge, .sound]
        UNUserNotificationCenter.current().requestAuthorization(
            options: authOptions,
            completionHandler: { [weak self] _, _ in
                self?.checkNotificationSettings()
            }
        )
        
        UIApplication.shared.registerForRemoteNotifications()
    }
    
    func checkNotificationSettings() {
        UNUserNotificationCenter.current().getNotificationSettings(completionHandler: { permission in
            switch permission.authorizationStatus {
            case .authorized:
                Messaging.messaging().delegate = self
                debugPrint("User granted permission for notification")
                
            case .denied:
                debugPrint("User denied notification permission")
                
            case .notDetermined:
                debugPrint("Notification permission haven't been asked yet")
                
            case .provisional:
                // @available(iOS 12.0, *)
                debugPrint("The application is authorized to post non-interruptive user notifications.")
                
            case .ephemeral:
                // @available(iOS 14.0, *)
                debugPrint("The application is temporarily authorized to post notifications. Only available to app clips.")
                
            @unknown default:
                debugPrint("Unknow Status")
            }
        })
    }
}

// MARK: - MessagingDelegate
extension PermissionManager: MessagingDelegate {
    func messaging(_ messaging: Messaging, didReceiveRegistrationToken fcmToken: String?) {
        print("Firebase registration token: \(String(describing: fcmToken))")
        
        let dataDict: [String: String] = ["token": fcmToken ?? ""]
        NotificationCenter.default.post(
            name: Notification.Name("FCMToken"),
            object: nil,
            userInfo: dataDict
        )
        // TODO: If necessary send token to application server.
        // Note: This callback is fired at each app startup and whenever a new token is generated.
    }
}

// MARK: - UNUserNotificationCenterDelegate
extension PermissionManager: UNUserNotificationCenterDelegate {
    func userNotificationCenter(
        _ center: UNUserNotificationCenter,
        willPresent notification: UNNotification,
        withCompletionHandler completionHandler: @escaping (UNNotificationPresentationOptions) -> Void
    ) {
        completionHandler([.alert, .badge, .sound])
    }
    
    func userNotificationCenter(
        _ center: UNUserNotificationCenter,
        didReceive response: UNNotificationResponse,
        withCompletionHandler completionHandler: @escaping () -> Void
    ) {
        
        if let notificationInfo = response.notification.request.content.userInfo as? [String: AnyObject] {
            // Read notification
        }
        
        completionHandler()
    }
}
