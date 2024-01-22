//
//  AppStyle.swift
//  BookMeNow-Develop
//
//  Created by Yurii Goroshenko on 01.08.2023.
//

import SwiftUI

enum BrandFontType: String {
    case black = "Urbanist-Black"
    case bold = "Urbanist-Bold"
    case semibold = "Urbanist-SemiBold"
    case medium = "Urbanist-Medium"
    case regular = "Urbanist-Regular"
}

// MARK: - Fonts
extension Font {
    static let H0Bold = Font.custom(BrandFontType.black.rawValue, size: 48.0)
    // Headers
    static let H1Bold = Font.custom(BrandFontType.bold.rawValue, size: 48.0)
    static let H2Bold = Font.custom(BrandFontType.bold.rawValue, size: 40.0)
    static let H3Bold = Font.custom(BrandFontType.bold.rawValue, size: 32.0)
    static let H4Bold = Font.custom(BrandFontType.bold.rawValue, size: 24.0)
    static let H5Bold = Font.custom(BrandFontType.bold.rawValue, size: 20.0)
    static let H6Bold = Font.custom(BrandFontType.bold.rawValue, size: 18.0)
    // BodyXLarge
    static let BodyXLargeBold = Font.custom(BrandFontType.bold.rawValue, size: 18.0)
    static let BodyXLargeSemibold = Font.custom(BrandFontType.semibold.rawValue, size: 18.0)
    static let BodyXLargeMedium = Font.custom(BrandFontType.medium.rawValue, size: 18.0)
    static let BodyXLargeRegular = Font.custom(BrandFontType.regular.rawValue, size: 18.0)
    // BodyLarge
    static let BodyLargeBold = Font.custom(BrandFontType.bold.rawValue, size: 16.0)
    static let BodyLargeSemibold = Font.custom(BrandFontType.semibold.rawValue, size: 16.0)
    static let BodyLargeMedium = Font.custom(BrandFontType.medium.rawValue, size: 16.0)
    static let BodyLargeRegular = Font.custom(BrandFontType.regular.rawValue, size: 16.0)
    // BodyMedium
    static let BodyMediumBold = Font.custom(BrandFontType.bold.rawValue, size: 14.0)
    static let BodyMediumSemibold = Font.custom(BrandFontType.semibold.rawValue, size: 14.0)
    static let BodyMediumMedium = Font.custom(BrandFontType.medium.rawValue, size: 14.0)
    static let BodyMediumRegular = Font.custom(BrandFontType.regular.rawValue, size: 14.0)
    // BodySmall
    static let BodySmallBold = Font.custom(BrandFontType.bold.rawValue, size: 12.0)
    static let BodySmallSemibold = Font.custom(BrandFontType.semibold.rawValue, size: 12.0)
    static let BodySmallMedium = Font.custom(BrandFontType.medium.rawValue, size: 12.0)
    static let BodySmallRegular = Font.custom(BrandFontType.regular.rawValue, size: 12.0)
    // BodyXSmall
    static let BodyXSmallBold = Font.custom(BrandFontType.bold.rawValue, size: 10.0)
    static let BodyXSmallSemibold = Font.custom(BrandFontType.semibold.rawValue, size: 10.0)
    static let BodyXSmallMedium = Font.custom(BrandFontType.medium.rawValue, size: 10.0)
    static let BodyXSmallRegular = Font.custom(BrandFontType.regular.rawValue, size: 10.0)
}
