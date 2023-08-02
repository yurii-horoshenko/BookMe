//
//  AppPhoneNumber.swift
//  BookMeNow-Develop
//
//  Created by Yurii Goroshenko on 24.07.2023.
//

import SwiftUI

struct AppPhoneNumber: View {
    @FocusState var isFocused: Bool
    @State var phone = ""
    var placeholder = ""
    var foregroundColor = Color.white
    @State var isEditing = false
    private let shape = RoundedShapeView(color: Color.greyscale900, isFilled: false)
    
    // MARK: - BODY
    var body: some View {
        iPhoneNumberField(placeholder, text: $phone, isEditing: $isEditing)
            .flagHidden(false)
            .flagSelectable(true)
            .font(UIFont(size: 26, weight: .light, design: .monospaced))
            .maximumDigits(10)
            .foregroundColor(foregroundColor)
            .clearButtonMode(.whileEditing)
            .onClear { _ in isEditing.toggle() }
            .accentColor(Color.orange)
            .padding(EdgeInsets(top: 8.0, leading: 16.0, bottom: 8.0, trailing: 16.0))
            .background(shape)
    }
}

struct AppPhoneNumber_Previews: PreviewProvider {
    static var previews: some View {
        AppPhoneNumber()
    }
}
