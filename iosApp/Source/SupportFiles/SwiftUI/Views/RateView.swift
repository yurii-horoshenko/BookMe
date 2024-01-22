//
//  RateView.swift
//  iosApp
//
//  Created by Yurii Goroshenko on 21.01.2024.
//

import SwiftUI

struct RateView: View {
    // MARK: - Properties
    @Binding var currectIndex: Int
    let action: (_ selectIndex: Int) -> Void
    let itemCount = 6
    
    // MARK: - Lifecycle
    var body: some View {
        HStack(alignment: .center, spacing: 0.0) {
            ForEach(0..<itemCount, id: \.self) { index in
                Button {
                    currectIndex = index
                    action(currectIndex)
                } label: {
                    if currectIndex > index {
                        Icons.StarBold
                            .foregroundColor(Color.primary500)
                        
                    } else {
                        Icons.Star
                            .foregroundColor(Color.primary500)
                    }
                }
                .frame(maxWidth: 32.0, maxHeight: 32.0)
            }
        }
    }
}

#Preview {
    RateView(currectIndex: .constant(4), action: { selectIndex in })
}
