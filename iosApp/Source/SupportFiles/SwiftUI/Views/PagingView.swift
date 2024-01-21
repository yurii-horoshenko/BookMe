//
//  PagingView.swift
//  iosApp
//
//  Created by Yurii Goroshenko on 21.01.2024.
//

import SwiftUI

struct PagingView: View {
    // MARK: - Properties
    let countPages: Int
    @Binding var currectIndex: Int?
    
    // MARK: - Lifecycle
    var body: some View {
        HStack {
            ForEach(0..<countPages) { index in
                Rectangle()
                    .fill(index == currectIndex ? Color.primary500 : Color.greyscale300)
                    .frame(width: index == currectIndex ? 24.0 : 8.0, alignment: .center)
                    .cornerRadius(4)
            }
        }
        .frame(height: 8.0)
    }
}

#Preview {
    PagingView(
        countPages: 5,
        currectIndex: .constant(0)
    )
}
