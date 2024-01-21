//
//  EnableLocationView.swift
//  iosApp
//
//  Created by Yurii Goroshenko on 21.01.2024.
//

import SwiftUI

struct EnableLocationView: View {
    var body: some View {
        VStack(alignment: .center, spacing: 24.0) {
            InfoImages.Location
                .padding(.horizontal, 44.0)
            
            Text("Enable Location")
                .font(Font.H4Bold)
                .foregroundColor(Color.primary500)
            
            Text("We need location access to find the nearest barber/salon around you.")
                .font(Font.BodyLargeRegular)
                .foregroundColor(Color.greyscale900)
                .multilineTextAlignment(.center)
            
            AppFilledButton(
                state: .constant(.active),
                title: "Enable Location",
                titleColor: Color.white,
                backgroundColor: Color.primary500,
                action: { }
            )
            
            AppFilledButton(
                state: .constant(.active),
                title: "Cancel",
                titleColor: Color.primary500,
                backgroundColor: Color.primary100,
                action: { }
            )
        }
        .padding(.horizontal, 32.0)
    }
}

#Preview {
    EnableLocationView()
}
