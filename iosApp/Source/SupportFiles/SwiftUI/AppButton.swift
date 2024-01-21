//
//  AppButton.swift
//  BookMeNow-Develop
//
//  Created by Yurii Goroshenko on 23.07.2023.
//

import SwiftUI

// MARK: - AppButton
struct AppButton: View {
    enum ButtonState {
        case active
        case disable
        
        var opacity: Double { self == .active ? 1.0 : 0.6 }
    }
    
    // MARK: - Properties
    @Binding var state: ButtonState
    var imageName: String?
    var imageColor: Color?
    var title: String?
    var titleColor = Color.greyscale900
    var backgroundColor = Color.black
    let action: () -> Void
    
    // MARK: - Lifecycle
    var body: some View {
        Button {
            action()
        } label: {
            HStack(alignment: .center) {
                if let imageName {
                    if let imageColor {
                        Image(imageName)
                            .resizable()
                            .renderingMode(.template)
                            .frame(width: 20, height: 20)
                            .foregroundColor(imageColor)
                    } else {
                        Image(imageName)
                    }
                }
                
                if let title {
                    Text(title)
                        .font(Font.BodyLargeSemibold)
                        .foregroundColor(titleColor)
                }
            }
            .padding(16)
        }
        .frame(maxHeight: 60.0)
        .disabled(state == .disable)
        .opacity(state.opacity)
    }
}

// MARK: - AppFilledButton
struct AppFilledButton: View {
    // MARK: - Properties
    @Binding var state: AppButton.ButtonState
    var imageName: String?
    var imageColor: Color?
    var title: String?
    var titleColor = Color.greyscale900
    var backgroundColor = Color.black
    let action: () -> Void
    
    // MARK: - Lifecycle
    var body: some View {
        AppButton(
            state: $state,
            imageName: imageName,
            imageColor: imageColor,
            title: title,
            titleColor: titleColor,
            action: action
        )
        .background(backgroundColor)
        .cornerRadius(30.0)
        .shadow(color: backgroundColor.opacity(0.75), radius: 6.0)
    }
}

// MARK: - AppBorderButton
struct AppBorderButton: View {
    // MARK: - Properties
    @Binding var state: AppButton.ButtonState
    var imageName: String?
    var imageColor: Color?
    var title: String?
    var titleColor = Color.greyscale900
    var shape = RoundedShapeView(color: Color.greyscale200, step: 3.0, isFilled: false)
    let action: () -> Void
    
    // MARK: - Lifecycle
    var body: some View {
        AppButton(
            state: $state,
            imageName: imageName,
            imageColor: imageColor,
            title: title,
            titleColor: titleColor,
            action: action
        )
        .background(shape)
    }
}

#Preview {
    VStack {
        AppBorderButton(
            state: .constant(.active),
            imageName: "ic-google",
            title: "Text",
            action: {}
        )
        .padding(16.0)
        
        AppFilledButton(
            state: .constant(.active),
            imageName: "ic-google",
            title: "Text",
            action: {}
        )
        .padding(16.0)
    }
}
