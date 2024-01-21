//
//  FilterView.swift
//  iosApp
//
//  Created by Yurii Goroshenko on 21.01.2024.
//

import SwiftUI

struct FilterView: View {
    // MARK: - Lifecycle
    var body: some View {
        VStack(alignment: .center, spacing: 24.0) {
            Text("Filter")
                .font(Font.H4Bold)
                .foregroundColor(Color.greyscale900)
            
            Divider()
                .background(Color.greyscale200)
                .frame(height: 1.0)
                .padding(.horizontal, 16.0)

            SelectRateView()
            
            SelectDistanceView()
            
            HStack {
                AppFilledButton(
                    state: .constant(.active),
                    title: "Reset",
                    titleColor: Color.primary500,
                    backgroundColor: Color.primary100,
                    action: {  }
                )
                
                AppFilledButton(
                    state: .constant(.active),
                    title: "Apply Filter",
                    titleColor: Color.white,
                    backgroundColor: Color.primary500,
                    action: { }
                )
            }
        }
        .padding(.horizontal, 16.0)
    }
}

#Preview {
    FilterView()
}
