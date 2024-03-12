//
//  DashboardContainerView.swift
//  BookMeNow-Develop
//
//  Created by Yurii Goroshenko on 12.09.2023.
//

import SwiftUI

struct DashboardContainerView: View {
    
    // MARK: - Lifecycle
    var body: some View {
        TabView {
            // Dashboard Page
            DashboardPageBuilder.constructDashboardView()
                .tabItem {
                    HStack {
                        TabIcons.Home
                        Text(String(localized: "TAB-HOME"))
                    }
                }
                .toolbarBackground(.white, for: .tabBar)
            
            // Map Page
            DashboardPageBuilder.constructNearByView()
                .tabItem {
                    HStack {
                        TabIcons.MapBold
                        Text(String(localized: "TAB-EXPLORE"))
                    }
                }
                .toolbarBackground(.white, for: .tabBar)
            
            // Profile Page
            ProfilePageBuilder.constructProfileView()
                .tabItem {
                    HStack {
                        TabIcons.Profile
                        Text(String(localized: "TAB-PROFILE"))
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
