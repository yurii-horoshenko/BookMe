//
//  SelectDistanceView.swift
//  iosApp
//
//  Created by Yurii Goroshenko on 21.01.2024.
//

import SwiftUI

struct SelectDistanceView: View {
    // MARK: - Properties
    @State var seltectedItem = "< 1 km"
    var array = ["< 1 km", "1 - 5 km", "5 - 10 km", "> 10 km"]
    let shape = RoundedShapeView(color: Color.primary500, step: 2.0, isFilled: false)
    
    // MARK: - Lifecycle
    var body: some View {
        VStack(alignment: .leading, spacing: 16.0) {
            Text("Distance")
                .font(Font.H5Bold)
                .foregroundColor(Color.greyscale900)
            
            ScrollView(.horizontal, showsIndicators: false) {
                HStack(spacing: 12.0) {
                    ForEach(array, id: \.self) { item in
                        Button {
                            self.seltectedItem = item
                        } label: {
                            HStack {                                
                                Text(item)
                                    .font(Font.BodyLargeSemibold)
                                    .foregroundColor(seltectedItem == item ? Color.white : Color.primary500)
                            }
                            .padding(EdgeInsets(top: 8.0, leading: 16.0, bottom: 8.0, trailing: 16.0))
                        }
                        .background(seltectedItem == item ? Color.primary500 : Color.clear)
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
    SelectDistanceView()
}
