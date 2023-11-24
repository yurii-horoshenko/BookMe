//
//  WorkingHoursView.swift
//  iosApp
//
//  Created by Yurii Goroshenko on 23.11.2023.
//

import SwiftUI

struct WorkingHoursView: View {
    private var lineOffset = 8.0
    
    var body: some View {
        VStack(alignment: .leading, spacing: 16.0) {
            Text("Working Hours")
                .font(Font.H6Bold)
                .foregroundColor(Color.greyscale900)
            
            HStack(spacing: 16.0) {
                VStack(alignment: .leading, spacing: lineOffset) {
                    Text("Monday - Friday")
                        .font(Font.BodyLargeMedium)
                        .foregroundColor(Color.greyscale700)
                    Text("Saturday - Sunday")
                        .font(Font.BodyLargeMedium)
                        .foregroundColor(Color.greyscale700)
                }
                
                VStack(alignment: .leading, spacing: lineOffset) {
                    Text(":")
                        .font(Font.BodyLargeMedium)
                        .foregroundColor(Color.greyscale900)
                    Text(":")
                        .font(Font.BodyLargeMedium)
                        .foregroundColor(Color.greyscale900)
                }
                
                VStack(alignment: .leading, spacing: lineOffset) {
                    Text("08:00 AM - 21:00 PM")
                        .font(Font.BodyLargeSemibold)
                        .foregroundColor(Color.greyscale900)
                    Text("10:00 AM - 20:00 PM")
                        .font(Font.BodyLargeSemibold)
                        .foregroundColor(Color.greyscale900)
                }
            }
        }
    }
}

#Preview {
    WorkingHoursView()
}
