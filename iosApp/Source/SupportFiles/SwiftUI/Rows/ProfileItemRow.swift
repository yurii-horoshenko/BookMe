//
//  ProfileItemRow.swift
//  iosApp
//
//  Created by Yurii Goroshenko on 04.12.2023.
//

import SwiftUI

struct ProfileItemRow: View {
    let title: String
    let leftIcon: String
    var rightIcon: String = "ic-arrow-right"
     
    // MARK: - Lifecycle
    var body: some View {
        VStack(alignment: .leading) {
            HStack(spacing: 0.0) {
                Image(leftIcon)
                    .resizable()
                    .renderingMode(.template)
                    .frame(width: 20, height: 20)
                    .padding(16.0)
                
                Text(title)
                    .font(Font.BodyXLargeSemibold)
                
                Spacer()
                
                Image(rightIcon)
                    .resizable()
                    .renderingMode(.template)
                    .frame(width: 20, height: 20)
                    .padding(16.0)
            }
        }
        .background(Color.clear)
    }
}

#Preview {
    ProfileItemRow(title: "Edit Profile", leftIcon: "ic-call")
}
