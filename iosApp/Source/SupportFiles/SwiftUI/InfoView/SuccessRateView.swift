//
//  SuccessRateView.swift
//  iosApp
//
//  Created by Yurii Goroshenko on 21.01.2024.
//

import SwiftUI

struct SuccessRateView: View {
    // MARK: - Properties
    var shape = RoundedShapeView(color: Color.primary100, step: 3.0, isFilled: true)
    
    // MARK: - Lifecycle
    var body: some View {
        VStack(alignment: .center, spacing: 24.0) {
            InfoImages.Rate
                .padding(.horizontal, 44.0)
            
            Text("You have done using barber/salon service")
                .font(Font.H4Bold)
                .foregroundColor(Color.primary500)
                .multilineTextAlignment(.center)
            
            Text("Please leave your review so others people can know your opinion")
                .font(Font.BodyLargeRegular)
                .foregroundColor(Color.greyscale900)
                .multilineTextAlignment(.center)
            
            RateView(
                currectIndex: .constant(4),
                action: { selectIndex in
                    
                }
            )
            
            HStack {
                Text("Very good service and satisfying results 🔥")
                    .font(Font.BodyMediumSemibold)
                    .foregroundColor(Color.greyscale900)
                    .padding(EdgeInsets(top: 8.0, leading: 20.0, bottom: 8.0, trailing: 20.0))
            }
            .background(shape)
            
            AppFilledButton(
                state: .constant(.active),
                title: "Ok",
                titleColor: Color.white,
                backgroundColor: Color.primary500,
                action: { }
            )
        }
        .padding(.horizontal, 32.0)
    }
}

#Preview {
    SuccessRateView()
}
