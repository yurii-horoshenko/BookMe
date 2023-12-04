//
//  VisitItemRow.swift
//  BookMeNow-Develop
//
//  Created by Yurii Goroshenko on 31.08.2023.
//

import SwiftUI

struct VisitItemRow: View {
    
    // MARK: - Lifecycle
    var body: some View {
        VStack(alignment: .leading) {
            HStack(spacing: 0.0) {
                Images.TableMask
                    .padding(16.0)
                
                VStack(alignment: .leading, spacing: 6.0) {
                    Text("Belle Curls")
                        .font(Font.H6Bold)
                    
                    Text("0993 Novick Parkway")
                        .font(Font.BodyMediumMedium)
                        .foregroundColor(Color.greyscale600)
                    
                    HStack(spacing: 4.0) {
                        Icons.Map
                            .foregroundColor(Color.primary500)
                        
                        Text("1.2 km")
                            .font(Font.BodyMediumMedium)
                            .foregroundColor(Color.greyscale800)
                        
                        Spacer()
                    }
                }
                .foregroundColor(Color.greyscale900)
            }
        }
        .background(Color.white)
        .cornerRadius(32.0)
    }
}

#Preview {
    VisitItemRow()
        .shadow(color: Color.greyscale300, radius: 1.0)
        .padding(.horizontal, 16.0)
}
