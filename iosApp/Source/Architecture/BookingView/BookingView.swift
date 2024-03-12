//
//  BookingView.swift
//  iosApp
//
//  Created by Yurii Goroshenko on 23.11.2023.
//

import SwiftUI

struct BookingView: View {
    // MARK: - Properties
    @StateObject var viewModel: BookingViewModel
    
    // MARK: - Lifecycle
    var body: some View {
        
        ScrollView {
            BaseView(navigationTitle: "Book Appointment") { ContentView }
        }
        .navigationBarBackButtonHidden(true)
        .environment(\.colorScheme, .light)
        
    }
    
    var ContentView: some View {
        VStack(alignment: .leading, spacing: 16.0) {
            CalendarView(date: $viewModel.date)
            SelectHoursView()
            Spacer()
            Divider()
                .background(Color.greyscale200)
                .frame(height: 1.0)
                .padding(.bottom, 16.0)
            BottomButton
        }
        .padding(16.0)
    }
    
    // Button Book Now
    var BottomButton: some View {
        AppFilledButton(
            state: .constant(.active),
            title: "Continue",
            titleColor: Color.white,
            backgroundColor: Color.primary500,
            action: {
                
            }
        )
    }
}

#Preview {
    DashboardPageBuilder.constructBookingView()
}
