//
//  DashboardView.swift
//  BookMeNow-Develop
//
//  Created by Yurii Goroshenko on 24.07.2023.
//

import SwiftUI

struct DashboardView: View {
    @ObservedObject var presenter = DashboardPresenter()
    
    // MARK: - BODY
    var body: some View {
        NavigationView {
            BaseView(leadingView: LeadingView.eraseToAnyView(), trailingView: TrailingView.eraseToAnyView(), content: { ContentView })
        }
        .navigationBarBackButtonHidden(true)
        .environment(\.colorScheme, .light)
    }
    
    var LeadingView: some View {
        HStack(spacing: 16.0) {
            Images.Logo
            
            Text("BookMeNow")
                .font(Font.H4Bold)
                .foregroundColor(Color.greyscale900)
        }
    }
    
    var TrailingView: some View {
        Button(
            action: { print("") },
            label: { Icons.Notification.foregroundColor(Color.greyscale900) }
        )
    }
    
    var ContentView: some View {
        VStack {
            AppInputField(
                fieldData: $presenter.searchData,
                leadingView: Icons.Search.eraseToAnyView(),
                trailingView: Icons.Search.eraseToAnyView()
            )
            .padding(.top, 8.0)
            
            Spacer()
        }
        .frame(maxWidth: .infinity, maxHeight: .infinity)
        .padding(defaultEdgeInsets)
        //        .background(Color.brandDarkColor)
    }
}

struct DashboardView_Previews: PreviewProvider {
    static var previews: some View {
        DashboardView()
    }
}
