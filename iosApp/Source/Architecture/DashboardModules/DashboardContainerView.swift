//
//  DashboardContainerView.swift
//  BookMeNow-Develop
//
//  Created by Yurii Goroshenko on 12.09.2023.
//

import shared
import SwiftUI

struct DashboardContainerView: View {
    
    var body: some View {
        TabView {
            DashboardPageBuilder.constructDashboardView()
                .tabItem {
                    HStack {
                        TabIcons.Home
                        Text("Home")
                    }
                }
                .toolbarBackground(.white, for: .tabBar)
            
            DashboardPageBuilder.constructBookingView()
                .tabItem {
                    HStack {
                        TabIcons.MapBold
                        Text("Explore")
                    }
                }
                .toolbarBackground(.white, for: .tabBar)
            
            ProfilePageBuilder.constructProfileView()
                .tabItem {
                    HStack {
                        TabIcons.Profile
                        Text("Profile")
                    }
                }
                .toolbarBackground(.white, for: .tabBar)
        }
        .tint(Color.primary500)
    }
}

#Preview {
    DashboardContainerView()
}
