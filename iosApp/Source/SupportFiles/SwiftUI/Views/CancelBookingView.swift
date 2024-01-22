//
//  CancelBookingView.swift
//  iosApp
//
//  Created by Yurii Goroshenko on 21.01.2024.
//

import SwiftUI

struct CancelBookingView: View {
    // MARK: - Properties
    var onCancelPress: (() -> Void)?
    var onOkPress: (() -> Void)?
    
    // MARK: - Lifecycle
    var body: some View {
        VStack(alignment: .center, spacing: 24.0) {
            Text(String(localized: "BOOKING-CANCEL"))
                .font(Font.H4Bold)
                .foregroundColor(Color.error)
            
            Divider()
                .background(Color.greyscale200)
                .frame(height: 1.0)
            
            Text(String(localized: "BOOKING-CANCEL-TITLE"))
                .font(Font.H5Bold)
                .foregroundColor(Color.greyscale900)
                .multilineTextAlignment(.center)
            
            Text(String(localized: "BOOKING-CANCEL-DESCRIPTION"))
                .font(Font.BodyMediumMedium)
                .foregroundColor(Color.greyscale800)
                .multilineTextAlignment(.center)
            
            ButtonsView
        }
        .padding(EdgeInsets(top: 8.0, leading: 16.0, bottom: 8.0, trailing: 16.0))
    }
    
    var ButtonsView: some View {
        HStack(spacing: 12.0) {
            AppFilledButton(
                state: .constant(.active),
                title: String(localized: "BUTTON-CANCEL"),
                titleColor: Color.primary500,
                backgroundColor: Color.primary100,
                action: { onCancelPress?() }
            )
            
            AppFilledButton(
                state: .constant(.active),
                title: String(localized: "BUTTON-CANCEL-BOOKING"),
                titleColor: Color.white,
                backgroundColor: Color.primary500,
                action: { onOkPress?() }
            )
        }
    }
}

#Preview {
    CancelBookingView()
}
