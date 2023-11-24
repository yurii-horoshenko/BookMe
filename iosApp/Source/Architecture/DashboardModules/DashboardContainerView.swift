//
//  DashboardContainerView.swift
//  BookMeNow-Develop
//
//  Created by Yurii Goroshenko on 12.09.2023.
//

import SwiftUI

struct DashboardContainerView: View {
    var body: some View {
        TabView {
            DashboardView()
                .tabItem {
                    HStack {
                        TabIcons.Home
                        Text("Home")
                    }
                }
                .toolbarBackground(.white, for: .tabBar)
            
            ProfileView()
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
