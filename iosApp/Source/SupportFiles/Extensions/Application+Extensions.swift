//
//  Application+Extensions.swift
//  iosApp
//
//  Created by Yurii Goroshenko on 13.03.2024.
//

import UIKit

extension UIApplication {
    var firstKeyWindow: UIWindow? {
        UIApplication.shared.connectedScenes
            .compactMap { $0 as? UIWindowScene }
            .filter { $0.activationState == .foregroundActive }
            .first?.keyWindow

    }
}
