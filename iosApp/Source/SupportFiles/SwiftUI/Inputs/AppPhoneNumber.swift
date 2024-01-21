//
//  AppPhoneNumber.swift
//  BookMeNow-Develop
//
//  Created by Yurii Goroshenko on 24.07.2023.
//

import SwiftUI

struct AppPhoneNumber: View {
    // MARK: - Properties
    private let shape = RoundedShapeView(color: Color.greyscale50, step: 3.0, isFilled: true)
    private let placeholderFont = UIFont(name: BrandFontType.regular.rawValue, size: 14.0)
    private let font = UIFont(name: BrandFontType.semibold.rawValue, size: 14.0)
    @Binding var fieldData: FieldData
    @State var isEditing = false
    @State var prefix = "+1"
    @State var phone = ""
    
    // MARK: - Lifecycle
    var body: some View {
        iPhoneNumberField(fieldData.placeholder, prefix: $prefix, text: $phone, isEditing: $isEditing)
            .flagHidden(false)
            .flagSelectable(true)
            .font(font)
            .maximumDigits(10)
            .foregroundColor(Color.greyscale900)
            .clearButtonMode(.whileEditing)
            .onClear { _ in isEditing.toggle() }
            .accentColor(Color.primary500)
            .padding(EdgeInsets(top: 16.0, leading: 16.0, bottom: 16.0, trailing: 16.0))
            .background(shape)
            .onChange(of: prefix) {
                fieldData.value = prefix + " " + phone
            }
            .onChange(of: phone) {
                fieldData.value = prefix + " " + phone
            }
    }
}

#Preview {
    AppPhoneNumber(
        fieldData: .constant(FieldData(placeholder: "Placeholder"))
    )
}
