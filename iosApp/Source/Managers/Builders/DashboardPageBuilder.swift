//
//  DashboardPageBuilder.swift
//  iosApp
//
//  Created by Yurii Goroshenko on 19.01.2024.
//

import SwiftUI

enum DashboardPageBuilder {
    static func constructDashboardView() -> some View {
        let viewModel = DashboardViewModel()
        let view = DashboardView(viewModel: viewModel)
        return view
    }
    
    static func constructBookingView() -> some View {
        let viewModel = BookingViewModel()
        let view = BookingView(viewModel: viewModel)
        return view
    }
    
    static func constructNearByView() -> some View {
        let viewModel = NearByViewModel()
        let view = NearByView(viewModel: viewModel)
        return view
    }
    
    static func constructServiceView() -> some View {
        let viewModel = ServiceDetailViewModel()
        let view = ServiceDetailView(viewModel: viewModel)
        return view
    }
}
