//
//  FilterView.swift
//  iosApp
//
//  Created by Yurii Goroshenko on 21.01.2024.
//

import SwiftUI

struct FilterView: View {
    // MARK: - Properties
    var onResetPress: (() -> Void)?
    var onApplyPress: (() -> Void)?
    
    // MARK: - Lifecycle
    var body: some View {
        VStack(alignment: .center, spacing: 24.0) {
            Text(String(localized: "FILTER"))
                .font(Font.H4Bold)
                .foregroundColor(Color.greyscale900)
            
            Divider()
                .background(Color.greyscale200)
                .frame(height: 1.0)
            
            SelectRateView()
            
            SelectDistanceView()
            
            Divider()
                .background(Color.greyscale200)
                .frame(height: 1.0)
            
            HStack(spacing: 12.0) {
                AppFilledButton(
                    state: .constant(.active),
                    title: String(localized: "BUTTON-RESET"),
                    titleColor: Color.primary500,
                    backgroundColor: Color.primary100,
                    action: { onResetPress?() }
                )
                
                AppFilledButton(
                    state: .constant(.active),
                    title: String(localized: "BUTTON-APPLY-FILTER"),
                    titleColor: Color.white,
                    backgroundColor: Color.primary500,
                    action: { onApplyPress?() }
                )
            }
        }
        .padding(defaultEdgeInsets)
    }
}

#Preview {
    FilterView()
}
