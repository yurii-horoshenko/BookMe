//
//  Theme.swift
//  Created by Yurii Goroshenko on 2/9/22.
//

import SwiftUI

extension Font {
    static func brandFont(ofSize size: CGFloat, type: BrandFontType = .regular) -> Font {
        Font.custom(type.rawValue, size: size)
    }
}

extension String {
    func attributed(ofSize size: CGFloat, type: BrandFontType = .regular, color: Color = Color.greyscale900) -> AttributedString {
        var result = AttributedString(self)
        result.font = Font.brandFont(ofSize: size, type: type)
        result.foregroundColor = color
        return result
    }
}

// UIKit
import UIKit.UIColor
import UIKit.UIFont

// MARK: - Colors
extension UIColor {
    static let brandMainColor = UIColor(hex: "#F5793B") // orange
    static let brandButtonsColor = UIColor(hex: "#f1580c") // orange
    static let brandDarkColor = UIColor(hex: "#0c0c0c") // splash
    static let brandPlaceholderColor = UIColor(hex: "#f79a6b")  // #252525
    static let brandTextPlaceholderColor = UIColor(hex: "#252525")
}

extension UIColor {
    convenience init(hex: String) {
        let a, r, g, b: UInt64
        let hex = hex.trimmingCharacters(in: CharacterSet.alphanumerics.inverted)
        var int: UInt64 = 0
        Scanner(string: hex).scanHexInt64(&int)

        switch hex.count {
        case 3: // RGB (12-bit)
            (a, r, g, b) = (255, (int >> 8) * 17, (int >> 4 & 0xF) * 17, (int & 0xF) * 17)
        case 6: // RGB (24-bit)
            (a, r, g, b) = (255, int >> 16, int >> 8 & 0xFF, int & 0xFF)
        case 8: // ARGB (32-bit)
            (a, r, g, b) = (int >> 24, int >> 16 & 0xFF, int >> 8 & 0xFF, int & 0xFF)
        default:
            (a, r, g, b) = (1, 1, 1, 0)
        }

        self.init(
            red: Double(r) / 255,
            green: Double(g) / 255,
            blue: Double(b) / 255,
            alpha: Double(a) / 255
        )
    }
}

// MARK: - Fonts
extension UIFont {
    static func brandFont(ofSize size: CGFloat, type: BrandFontType = .regular) -> UIFont {
        UIFont(name: type.rawValue, size: size) ?? UIFont.systemFont(ofSize: size)
    }
}
