//
//  SuccessCancelBookingView.swift
//  iosApp
//
//  Created by Yurii Goroshenko on 21.01.2024.
//

import SwiftUI

struct SuccessCancelBookingView: View {
    var body: some View {
        VStack(alignment: .center, spacing: 24.0) {
            InfoImages.Registration
                .padding(.horizontal, 44.0)
            
            Text("Successful!")
                .font(Font.H4Bold)
                .foregroundColor(Color.primary500)
            
            Text("You have successfully canceled your booking order. 80% funds will be returned to your account")
                .font(Font.BodyLargeRegular)
                .foregroundColor(Color.greyscale900)
                .multilineTextAlignment(.center)
            
            AppFilledButton(
                state: .constant(.active),
                title: "OK",
                titleColor: Color.white,
                backgroundColor: Color.primary500,
                action: { }
            )
        }
        .padding(.horizontal, 32.0)
    }
}

#Preview {
    SuccessCancelBookingView()
}
