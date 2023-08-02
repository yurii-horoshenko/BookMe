//
//  AppButton.swift
//  BookMeNow-Develop
//
//  Created by Yurii Goroshenko on 23.07.2023.
//

import SwiftUI

struct AppButton: View {
    enum ButtonState {
        case active
        case disable
        
        var opacity: Double { self == .active ? 1.0 : 0.6 }
    }
    
    @Binding var state: ButtonState
    var imageName: String?
    var title: String?
    var titleColor = Color.greyscale900
    var backgroundColor = Color.black
    let action: () -> Void
    
    var body: some View {
        Button {
            action()
        } label: {
            HStack(alignment: .center) {
                if let imageName {
                    Image(imageName)
                }
                
                if let title {
                    Text(title)
                        .font(Font.BodyLargeSemibold)
                        .foregroundColor(titleColor)
                }
            }
            .padding(16)
            .frame(maxWidth: .infinity)
        }
        .frame(maxHeight: 60.0)
        .disabled(state == .disable)
        .opacity(state.opacity)
        .background(backgroundColor)
        .cornerRadius(30.0)
    }
}

struct AppBorderButton: View {
    enum ButtonState {
        case active
        case disable
        
        var opacity: Double { self == .active ? 1.0 : 0.6 }
    }
    
    @Binding var state: ButtonState
    var imageName: String?
    var title: String?
    var titleColor = Color.greyscale900
    var borderColor = Color.greyscale200
    let action: () -> Void
    
    var body: some View {
        Button {
            action()
        } label: {
            HStack(alignment: .center) {
                if let imageName {
                    Image(imageName)
                }
                
                if let title {
                    Text(title)
                        .font(Font.BodyLargeSemibold)
                        .foregroundColor(titleColor)
                }
            }
            .padding(16)
            .frame(maxWidth: .infinity)
        }
        .frame(maxHeight: 60.0)
        .disabled(state == .disable)
        .opacity(state.opacity)
        .background(RoundedShapeView(color: borderColor, step: 3.0, isFilled: false))
    }
}

struct AppButton_Previews: PreviewProvider {
    static var previews: some View {
        VStack {
            AppBorderButton(
                state: .constant(.active),
                imageName: "ic-google",
                title: "Text",
                action: {}
            )
            
            AppButton(
                state: .constant(.active),
                imageName: "ic-google",
                title: "Text",
                action: {}
            )
        }
        .padding(16.0)
    }
}
