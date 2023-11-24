//
//  ReviewView.swift
//  iosApp
//
//  Created by Yurii Goroshenko on 23.11.2023.
//

import SwiftUI

struct ReviewView: View {
    // MARK: - Properties
    var reviewCount = 3_279
    var rating = "4.8"
    
    // MARK: - Lifecycle
    var body: some View {
        HStack(spacing: 8.0) {
            Icons.StarBold
                .foregroundColor(Color.primary500)
            
            Text("\(rating) (\(reviewCount) reviews)")
                .font(Font.BodyLargeMedium)
                .foregroundColor(Color.greyscale700)
        }
    }
}

#Preview {
    ReviewView()
}
