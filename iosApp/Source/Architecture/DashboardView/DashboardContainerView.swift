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
            DashboardPageBuilder.constructDashboardView()
                .tabItem {
                    HStack {
                        TabIcons.Home
                        Text(String(localized: "TAB-HOME"))
                    }
                }
                .toolbarBackground(.white, for: .tabBar)
            
            DashboardPageBuilder.constructNearByView()
                .tabItem {
                    HStack {
                        TabIcons.MapBold
                        Text(String(localized: "TAB-EXPLORE"))
                    }
                }
                .toolbarBackground(.white, for: .tabBar)
            
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
