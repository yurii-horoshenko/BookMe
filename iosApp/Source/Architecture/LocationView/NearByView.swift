//
//  NearByView.swift
//  iosApp
//
//  Created by Yurii Goroshenko on 24.11.2023.
//

import SwiftUI

struct NearByView<ViewModel>: View where ViewModel: NearByViewModelProtocol {
    // MARK: - Properties
    @State var viewModel: ViewModel
    
    // MARK: - Lifecycle
    var body: some View {
        ZStack {
            LocationView(useTitle: false, useLocation: false)
                .edgesIgnoringSafeArea(.top)
            
            VStack {
                SearchInputView
                    .padding(.horizontal, 16.0)
                    .shadow(color: Color.greyscale900.opacity(0.1), radius: 8, x: 0, y: 0)
                
                Spacer()
            }
            
        }
    }
    
    var SearchInputView: some View {
        AppInputField(
            fieldData: $viewModel.searchData,
            leadingView: AnyView(Icons.Search),
            trailingView: AnyView(SearchFilterView)
        )
        .sheet(isPresented: $viewModel.toSearchFilter) {
            FilterView()
                .padding(.top, 32.0)
                .readHeight()
                .onPreferenceChange(HeightPreferenceKey.self) { height in
                    if let height {
                        viewModel.detectHeight = height
                    }
                }
                .presentationDetents([.height(viewModel.detectHeight)])
                .presentationDragIndicator(.visible)
        }
        .padding(.top, 8.0)
    }
    
    var SearchFilterView: some View {
        Button(
            action: { viewModel.toSearchFilter = true },
            label: { Icons.Filter.foregroundColor(Color.primary500) }
        )
    }
}

#Preview {
    DashboardPageBuilder.constructBookingView()
}
