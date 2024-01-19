//
//  NearByView.swift
//  iosApp
//
//  Created by Yurii Goroshenko on 24.11.2023.
//

import SwiftUI

struct NearByView: View {
    // MARK: - Properties
    @StateObject var viewModel: NearByViewModel
    
    // MARK: - Lifecycle
    var body: some View {
        ZStack {
            
            LocationView(useTitle: false, useLocation: false)
                .edgesIgnoringSafeArea(.top)
            
            VStack {
                AppInputField(
                    fieldData: $viewModel.searchData,
                    leadingView: Icons.Search.eraseToAnyView(),
                    trailingView: Icons.Filter.foregroundColor(Color.primary500).eraseToAnyView()
                )
                .padding(.top, 8.0)
                .padding(.horizontal, 16.0)
                .shadow(color: Color.greyscale900.opacity(0.1), radius: 8, x: 0, y: 0)
                
                Spacer()
            }

        }
    }
}

#Preview {
    DashboardPageBuilder.constructBookingView()
}
