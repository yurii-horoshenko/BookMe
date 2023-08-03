//
//  DashboardView.swift
//  BookMeNow-Develop
//
//  Created by Yurii Goroshenko on 24.07.2023.
//

import SwiftUI

struct DashboardView: View {
    @State private var pushToPhoneFlow = false
    
    // MARK: - BODY
    var body: some View {
        NavigationView {
            BaseView(
                leadingView: LeadingView.eraseToAnyView(),
                trailingView: TrailingView.eraseToAnyView(),
                content: { ContentView }
            )
            .toolbar {
                ToolbarItem(placement: .principal) {
                    Image("logo")
                }
            }
            .background(Color.white)
        }
        
    }
    
    var LeadingView: some View {
        Button {
            //
        } label: {
            Image(systemName: "bell.fill")
                .renderingMode(.template)
                .aspectRatio(contentMode: .fit)
                .foregroundColor(Color.brandButtonsColor)
        }
    }
    
    var TrailingView: some View {
        Button {
            //
        } label: {
            Image(systemName: "person.crop.circle")
                .renderingMode(.template)
                .aspectRatio(contentMode: .fit)
                .foregroundColor(Color.brandButtonsColor)
        }
    }
    
    var ContentView: some View {
        VStack {
            NextVisitView
        }
        .frame(maxWidth: .infinity, maxHeight: .infinity)
        //        .background(Color.brandDarkColor)
    }
    
    var NextVisitView: some View {
        VStack {
            NextVisitView.eraseToAnyView()
        }
        .background(Color.white)
    }
    
}

struct DashboardView_Previews: PreviewProvider {
    static var previews: some View {
        DashboardView()
    }
}
