//
//  SelectHoursView.swift
//  iosApp
//
//  Created by Yurii Goroshenko on 24.11.2023.
//

import SwiftUI

struct SelectHoursView: View {
    // MARK: - Properties
    @State var seltectedTime = "10:00"
    var time = ["09:00", "10:00", "11:30", "15:00", "16:00", "17:00", "18:00"]
    let shape = RoundedShapeView(color: Color.primary500, step: 2.0, isFilled: false)
    
    // MARK: - Lifecycle
    var body: some View {
        VStack(alignment: .leading, spacing: 16.0) {
            Text("Select Hours")
                .font(Font.H5Bold)
                .foregroundColor(Color.greyscale900)
            
            ScrollView(.horizontal, showsIndicators: false) {
                HStack(spacing: 12.0) {
                    ForEach(time, id: \.self) { item in
                        Button {
                            self.seltectedTime = item
                        } label: {
                            Text(item)
                                .font(Font.BodyLargeSemibold)
                                .padding(EdgeInsets(top: 8.0, leading: 16.0, bottom: 8.0, trailing: 16.0))
                                .foregroundColor(seltectedTime == item ? Color.white : Color.primary500)
                        }
                        .background(seltectedTime == item ? Color.primary500 : Color.clear)
                        .cornerRadius(20.0)
                        .background(shape)
                    }
                }
                .frame(height: 38.0)
                .padding(.bottom, 16.0)
            }
        }
    }
}

#Preview {
    SelectHoursView()
}
