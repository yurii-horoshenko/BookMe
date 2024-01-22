//
//  SelectRateView.swift
//  iosApp
//
//  Created by Yurii Goroshenko on 21.01.2024.
//

import SwiftUI

struct SelectRateView: View {
    // MARK: - Properties
    @State var seltectedItem = ""
    var array = [String(localized: "ALL"), "5", "4", "3", "2", "1"]
    let shape = RoundedShapeView(color: Color.primary500, step: 2.0, isFilled: false)
    
    // MARK: - Lifecycle
    var body: some View {
        VStack(alignment: .leading, spacing: 24.0) {
            Text(String(localized: "SECTION-RATING"))
                .font(Font.H5Bold)
                .foregroundColor(Color.greyscale900)
            
            ScrollView(.horizontal, showsIndicators: false) {
                HStack(spacing: 12.0) {
                    ForEach(array, id: \.self) { item in
                        Button {
                            self.seltectedItem = item
                        } label: {
                            HStack {
                                Icons.StarBold
                                
                                Text(item)
                                    .font(Font.BodyLargeSemibold)
                            }
                            .foregroundColor(seltectedItem == item ? Color.white : Color.primary500)
                            .frame(height: 16)
                            .padding(buttonEdgeInsets)
                        }
                        .background(seltectedItem == item ? Color.primary500 : Color.clear)
                        .cornerRadius(20.0)
                        .background(shape)
                    }
                }
                .frame(height: 38.0)
            }
        }
        .onAppear {
            seltectedItem = array.first ?? ""
        }
    }
}

#Preview {
    SelectRateView()
}
