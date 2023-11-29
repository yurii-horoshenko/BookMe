//
//  DashboardContainerView.swift
//  BookMeNow-Develop
//
//  Created by Yurii Goroshenko on 12.09.2023.
//

import SwiftUI
import shared

struct DashboardContainerView: View {
    let presenter = DashboardPresenter()
    
    var body: some View {
        TabView {
            DashboardView(interactor: shared.DashboardInteractor(presenter: presenter), presenter: presenter)
                .tabItem {
                    HStack {
                        TabIcons.Home
                        Text("Home")
                    }
                }
                .toolbarBackground(.white, for: .tabBar)
            
            NearByView()
                .tabItem {
                    HStack {
                        TabIcons.MapBold
                        Text("Explore")
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
