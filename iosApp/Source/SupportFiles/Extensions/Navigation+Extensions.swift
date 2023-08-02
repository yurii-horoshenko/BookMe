//
//  Navigation+Extensions.swift
//  BookMeNow-Develop
//
//  Created by Yurii Goroshenko on 29.07.2023.
//

import UIKit

extension UINavigationController {
    static func appearance(with color: UIColor = UIColor.clear, textColor: UIColor = UIColor.black, shadowColor: UIColor = UIColor.clear) -> UINavigationBarAppearance {
        let appearance = UINavigationBarAppearance()
        appearance.configureWithOpaqueBackground()
        appearance.backgroundColor = color
        appearance.shadowColor = shadowColor
        appearance.titleTextAttributes = [
            NSAttributedString.Key.foregroundColor: UIColor.brandMainColor,
            NSAttributedString.Key.font: UIFont.brandFont(ofSize: 16, type: .medium)
        ]

        return appearance
    }
}
