//
//  NearByItemView.swift
//  iosApp
//
//  Created by Yurii Goroshenko on 05.12.2023.
//

import SwiftUI

struct NearByItemView: View {
    
    // MARK: - Lifecycle
    var body: some View {
        VStack(alignment: .center, spacing: 24.0) {
            Text("Details")
                .font(Font.H4Bold)
                .foregroundColor(Color.greyscale900)
            
            Divider()
                .background(Color.greyscale200)
                .frame(height: 1.0)
                .padding(.horizontal, 16.0)
            
            VisitItemRow()
            
            AppFilledButton(
                state: .constant(.active),
                imageName: "ic-send-bold",
                imageColor: Color.white,
                title: "Get Direction",
                titleColor: Color.white,
                backgroundColor: Color.primary500,
                action: { }
            )
        }
    }
}

#Preview {
    NearByItemView()
}
