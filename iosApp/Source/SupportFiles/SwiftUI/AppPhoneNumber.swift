//
//  AppPhoneNumber.swift
//  BookMeNow-Develop
//
//  Created by Yurii Goroshenko on 24.07.2023.
//

import SwiftUI

struct AppPhoneNumber: View {
    private let shape = RoundedShapeView(color: Color.greyscale50, step: 3.0, isFilled: true)
    private let placeholderFont = UIFont(name: BrandFontType.regular.rawValue, size: 14.0)
    private let font = UIFont(name: BrandFontType.semibold.rawValue, size: 14.0)
    @FocusState var isFocused: Bool
    @Binding var fieldData: FieldData
    @State var isEditing = false
    
    // MARK: - BODY
    var body: some View {
        iPhoneNumberField(fieldData.placeholder, text: $fieldData.value, isEditing: $isEditing)
            .flagHidden(false)
            .flagSelectable(true)
            .font(fieldData.value.isEmpty ? placeholderFont : font)
            .maximumDigits(10)
            .foregroundColor(fieldData.state.foregroundColor)
            .clearButtonMode(.whileEditing)
            .onClear { _ in isEditing.toggle() }
            .accentColor(Color.primary500)
            .padding(EdgeInsets(top: 16.0, leading: 16.0, bottom: 16.0, trailing: 16.0))
            .background(shape)
    }
}

struct AppPhoneNumber_Previews: PreviewProvider {
    @State static var phone = FieldData(placeholder: "Placeholder")
    
    static var previews: some View {
        AppPhoneNumber(fieldData: $phone)
    }
}
