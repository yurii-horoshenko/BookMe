//
//  AppInputField.swift
//  BookMeNow-Develop
//
//  Created by Yurii Goroshenko on 03.08.2023.
//

import SwiftUI

struct FieldData: Equatable {
    var value = ""
    var placeholder = ""
    var state = AppInputField.FieldState.idle
    var isSecure = false
    var keyboardType = UIKeyboardType.default
}

struct AppInputField: View {
    enum FieldState {
        case idle
        case active
        case error
        case disable
        
        var backgroundColor: Color { Color.greyscale50 }
        var foregroundColor: Color { Color.greyscale500 }
        var font: Font { Font.BodyMediumRegular }
    }
    
    // MARK: - PROPERTIES
    private let shape = RoundedShapeView(color: Color.greyscale50, step: 3.0, isFilled: true)
    @FocusState private var isFocused: Bool
    @Binding var fieldData: FieldData
    var leadingView: AnyView?
    var trailingView: AnyView?
    
    // MARK: - BODY
    var body: some View {
        HStack(spacing: 16.0) {
            leadingView
           
            if fieldData.isSecure {
                SecureField(fieldData.placeholder, text: $fieldData.value)
                    .offset(x: leadingView == nil ? 16.0 : 0.0)
                    .focused($isFocused)
            } else {
                TextField(fieldData.placeholder, text: $fieldData.value)
                    .offset(x: trailingView == nil ? 16.0 : 0.0)
                    .focused($isFocused)
            }
            
            trailingView
        }
        .disabled(fieldData.state == .disable)
        .keyboardType(fieldData.keyboardType)
        .font(fieldData.state.font)
        .foregroundColor(fieldData.state.foregroundColor)
        .frame(height: 56.0)
        .background(shape)
    }
}

struct AppInputField_Previews: PreviewProvider {
    @State static var username = FieldData(placeholder: "Placeholder")
    
    static var previews: some View {
        AppInputField(fieldData: $username)
    }
}
