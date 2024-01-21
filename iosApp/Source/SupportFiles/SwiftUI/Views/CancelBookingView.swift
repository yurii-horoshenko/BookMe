//
//  CancelBookingView.swift
//  iosApp
//
//  Created by Yurii Goroshenko on 21.01.2024.
//

import SwiftUI

struct CancelBookingView: View {
    // MARK: - Lifecycle
    var body: some View {
        VStack(alignment: .center, spacing: 24.0) {
            Text("Cancel Booking")
                .font(Font.H4Bold)
                .foregroundColor(Color.error)
            
            Divider()
                .background(Color.greyscale200)
                .frame(height: 1.0)
                .padding(.horizontal, 16.0)
            
            Text("Are you sure want to cancel your barber/salon booking?")
                .font(Font.H5Bold)
                .foregroundColor(Color.greyscale900)
                .multilineTextAlignment(.center)
            
            Text("Only 80% of the money you can refund from your payment according to our policy")
                .font(Font.BodyMediumMedium)
                .foregroundColor(Color.greyscale800)
                .multilineTextAlignment(.center)
            
            HStack {
                AppFilledButton(
                    state: .constant(.active),
                    title: "Cancel",
                    titleColor: Color.primary500,
                    backgroundColor: Color.primary100,
                    action: {  }
                )
                
                AppFilledButton(
                    state: .constant(.active),
                    title: "Yes, Cancel Booking",
                    titleColor: Color.white,
                    backgroundColor: Color.primary500,
                    action: { }
                )
            }
            .padding(.horizontal, 16.0)
        }
    }
}

#Preview {
    CancelBookingView()
}
