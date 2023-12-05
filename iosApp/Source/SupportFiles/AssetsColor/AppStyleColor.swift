//
//  AppStyleFontColor.swift
//  BookMeNow-Develop
//
//  Created by Yurii Goroshenko on 01.08.2023.
//

import SwiftUI

// MARK: - Colors
extension Color {
    // Main
    static let primary500 = Color(hex: "#FB9400")
    static let primary100 = Color(hex: "#FFF4E6")
    static let secondary500 = Color(hex: "#FFD300")

    // Text & Backgrounds
    static let background = Color("backgroud")
    static let greyscale900 = Color(hex: "#212121")
    static let greyscale800 = Color(hex: "#424242")
    static let greyscale700 = Color(hex: "#616161")
    static let greyscale600 = Color(hex: "#757575")
    static let greyscale500 = Color(hex: "#9E9E9E")
    
    static let greyscale400 = Color(hex: "#BDBDBD")
    static let greyscale300 = Color(hex: "#E0E0E0")
    static let greyscale200 = Color(hex: "#EEEEEE")
    static let greyscale100 = Color(hex: "#F5F5F5")
    static let greyscale50 = Color(hex: "#FAFAFA")
    
    // Alert & Status
    static let success = Color(hex: "#4ADE80")
    static let info = Color(hex: "#246BFD")
    static let warning = Color(hex: "#FACC15")
    static let error = Color(hex: "#F75555")
    static let disabled = Color(hex: "#D8D8D8")
    static let disButton = Color(hex: "#E9A33F")
    
    static let brandMainColor = Color(hex: "#F5793B") // orange
    static let brandButtonsColor = Color(hex: "#f1580c") // orange
    static let brandDarkColor = Color(hex: "#0c0c0c") // splash
    static let brandPlaceholderColor = Color(hex: "#f79a6b")  // #252525
    static let brandTextPlaceholderColor = Color(hex: "#252525")
}

// MARK: -
extension Color {
    init(hex: String) {
        let hex = hex.trimmingCharacters(in: CharacterSet.alphanumerics.inverted)
        var int: UInt64 = 0
        Scanner(string: hex).scanHexInt64(&int)
        let a, r, g, b: UInt64
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
            .sRGB,
            red: Double(r) / 255,
            green: Double(g) / 255,
            blue: Double(b) / 255,
            opacity: Double(a) / 255
        )
    }
}
