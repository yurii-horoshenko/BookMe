//
//  Text+Extensions.swift
//  BookMeNow-Develop
//
//  Created by Yurii Goroshenko on 01.08.2023.
//

import SwiftUI

extension Text {
    func attributed(_ font: Font, color: Color = Color.greyscale900) -> some View {
        self
            .font(font)
            .foregroundColor(color)
    }
}
