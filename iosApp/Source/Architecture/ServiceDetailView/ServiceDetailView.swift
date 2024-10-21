//
//  ServiceDetailView.swift
//  BookMeNow-Develop
//
//  Created by Yurii Goroshenko on 13.09.2023.
//

import SwiftUI

struct ServiceDetailView<ViewModel>: View where ViewModel: ServiceDetailViewModelProtocol {
    // MARK: - Properties
    @State var viewModel: ViewModel
    
    // MARK: - Lifecycle
    var body: some View {
        ScrollView {
            VStack(alignment: .leading) {
                Image("img-detail-mask")
                ContentView
                    .showNavigationBar()
            }
        }
        .edgesIgnoringSafeArea(.top)
        .navigationDestination(isPresented: $viewModel.toBooking) {
            DashboardPageBuilder.constructBookingView()
        }
        .navigationBarBackButtonHidden(true)
        .toolbarBackground(.hidden, for: .navigationBar)
    }
    
    var ContentView: some View {
        VStack(alignment: .leading, spacing: 24.0) {
            TitleView
            
            LocationView(
                useTitle: false,
                useMap: false
            )
            
            ReviewView()
            
            Divider()
                .background(Color.greyscale200)
                .frame(height: 1.0)
            
            DetailView
            
            WorkingHoursView()
            
            ContactsView(
                contacts: ["(406) 555-0120", "(406) 555-0121"]
            )
            
            LocationView()
                .frame(height: 300.0)
            
            Divider()
                .background(Color.greyscale200)
                .frame(height: 1.0)
            
            BottomButton
            
            Spacer()
        }
        .padding(.horizontal, 32.0)
    }
    
    var TitleView: some View {
        HStack {
            Text("Barbarella Inova")
                .font(Font.H3Bold)
                .foregroundColor(Color.greyscale900)
            
            Spacer()
            
            Text("Open")
                .font(Font.BodyLargeSemibold)
                .foregroundColor(Color.white)
                .padding(EdgeInsets(top: 8.0, leading: 16.0, bottom: 8.0, trailing: 16.0))
                .background(Color.primary500)
                .cornerRadius(19.0)
        }
    }
    
    var DetailView: some View {
        Text(
            """
            Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod
            tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,
            quis nostrud exercitation ull amco laboris nisi ut aliquip. Read more...
            """
        )
        .font(Font.BodyMediumRegular)
        .foregroundColor(Color.greyscale800)
    }
    
    // Button Book Now
    var BottomButton: some View {
        AppFilledButton(
            state: .constant(.active),
            title: "Book Now",
            titleColor: Color.white,
            backgroundColor: Color.primary500,
            action: { viewModel.toBooking = true }
        )
    }
    
}

#Preview {
    DashboardPageBuilder.constructServiceView()
}
