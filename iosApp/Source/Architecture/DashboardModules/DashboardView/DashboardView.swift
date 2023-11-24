//
//  DashboardView.swift
//  BookMeNow-Develop
//
//  Created by Yurii Goroshenko on 24.07.2023.
//

import SwiftUI

struct DashboardView: View {
    // MARK: - Properties
    @ObservedObject var presenter = DashboardPresenter()
    let restaurants = [
        Restaurant(name: "Joe's Original"),
        Restaurant(name: "The Real Joe's Original"),
        Restaurant(name: "Original Joe's")
    ]
    
    // MARK: - Lifecycle
    var body: some View {
        NavigationView {
            NavigationStack {
                BaseView(
                    leadingView: LeadingView.eraseToAnyView(),
                    trailingView: TrailingView.eraseToAnyView(),
                    content: { ContentView }
                )
            }
        }
        .navigationBarBackButtonHidden(true)
        .environment(\.colorScheme, .light)
    }
    
    var ContentView: some View {
        ScrollView {
            VStack(alignment: .leading, spacing: 24.0) {
                AppInputField(
                    fieldData: $presenter.searchData,
                    leadingView: Icons.Search.eraseToAnyView(),
                    trailingView: Icons.Filter.foregroundColor(Color.primary500).eraseToAnyView()
                )
                .padding(.top, 8.0)
                
                Text("Your Next Visit")
                    .font(Font.H4Bold)

                NextVisitView()
                    .shadow(radius: 16.0)
                
                Text("Nearby Your Location")
                    .font(Font.H4Bold)
                    .foregroundColor(Color.greyscale900)
                
                ForEach(restaurants) { _ in
                    TableVisitRow()
                        .onTapGesture {
                            presenter.toServiceDetail = true
                        }
                }
                .shadow(color: Color.greyscale400, radius: 1.0)
                
                Spacer()
            }
            .padding(.horizontal, 16.0)
        }
        .navigationDestination(isPresented: $presenter.toServiceDetail) {
            ServiceDetailView()
        }
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
}

#Preview {
    DashboardView()
}
