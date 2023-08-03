//
//  AppBorderButton.swift
//  BookMeNow-Develop
//
//  Created by Yurii Goroshenko on 02.08.2023.
//

import SwiftUI

struct AppBorderButton: View {
    private let shape = RoundedShapeView(color: Color.greyscale200, step: 3.0, isFilled: false)
    var imageName: String?
    var title: String?
    var titleColor = Color.greyscale900
    
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
        .background(shape)
    }
}

struct AppBorderButton_Previews: PreviewProvider {
    static var previews: some View {
        AppBorderButton(
            imageName: "ic-google",
            title: "Text",
            action: {}
        )
        .padding(16.0)
    }
}
