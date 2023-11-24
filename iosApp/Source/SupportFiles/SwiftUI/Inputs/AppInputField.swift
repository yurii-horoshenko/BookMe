//
//  AppInputField.swift
//  BookMeNow-Develop
//
//  Created by Yurii Goroshenko on 03.08.2023.
//

import SwiftUI

struct FieldData: Equatable {
    var id = UUID()
    var value = ""
    var placeholder = ""
    var state = AppInputField.FieldState.idle
    var isSecure = false
    var keyboardType = UIKeyboardType.default
    
    var color: Color { value.isEmpty ? Color.greyscale500 : Color.greyscale900 }
    var font: Font { value.isEmpty ? Font.BodyMediumRegular : Font.BodyMediumSemibold }
    var backgroundColor: Color { Color.greyscale50 }
}

struct AppInputField: View {
    enum FieldState {
        case idle
        case active
        case error
        case disable
    }
    
    // MARK: - Properties
    @FocusState var isFocused: Bool
    @Binding var fieldData: FieldData
    var leadingView: AnyView?
    var trailingView: AnyView?
    var onTapPress: (() -> Void)?
    let shape = RoundedShapeView(color: Color.greyscale50, step: 3.0, isFilled: true)
    
    // MARK: - Lifecycle
    var body: some View {
        HStack {
            leadingView
                .padding(.leading, 16.0)
            
            if onTapPress != nil {
                Text(fieldData.value.isEmpty ? fieldData.placeholder : fieldData.value)
                    .padding(.horizontal, 16.0)
                    .frame(maxWidth: .infinity, alignment: .leading)
                    .foregroundColor(fieldData.color)
                    .font(fieldData.font)
            } else {
                VStack {
                    if fieldData.isSecure {
                        SecureField("", text: $fieldData.value)
                    } else {
                        TextField("", text: $fieldData.value)
                    }
                }
                .focused($isFocused)
                .padding(.horizontal, 16.0)
                .placeholder(when: fieldData.value.isEmpty) {
                    Text(fieldData.placeholder)
                        .font(Font.BodyMediumRegular)
                        .foregroundColor(Color.greyscale500)
                        .padding(.horizontal, 16.0)
                }
            }
            
            trailingView
                .padding(.trailing, 16.0)
        }
        .accentColor(Color.primary500)
        .disabled(fieldData.state == .disable)
        .keyboardType(fieldData.keyboardType)
        .font(onTapPress != nil ? Font.BodyMediumRegular : Font.BodyMediumSemibold )
        .foregroundColor(onTapPress != nil ? Color.greyscale500 : Color.greyscale900)
        .frame(height: 56.0)
        .background(shape)
        .onTapGesture { onTapPress?() }
    }
}

#Preview {
    AppInputField(
        fieldData: .constant(FieldData(placeholder: "Placeholder"))
    )
}
