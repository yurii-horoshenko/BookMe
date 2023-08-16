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
            BaseView(leadingView: LeadingView.eraseToAnyView(), trailingView: TrailingView.eraseToAnyView(), content: { ContentView })
        }
        .navigationBarBackButtonHidden(true)
        .environment(\.colorScheme, .light)
    }
    
    var LeadingView: some View {
        HStack(spacing: 16.0) {
            Image(systemName: "person.crop.circle")
                .renderingMode(.template)
                .aspectRatio(contentMode: .fit)
                .foregroundColor(Color.brandButtonsColor)
            
            Text("BookMeNow")
                .font(Font.H4Bold)
                .foregroundColor(Color.greyscale900)
        }
    }
    
    var TrailingView: some View {
        Button {
            //
        } label: {
            Image("ic-notification")
                .resizable()
                .renderingMode(.template)
                .foregroundColor(Color.greyscale900)
                .frame(width: 28.0, height: 28.0)
        }
    }
    
    var ContentView: some View {
        VStack {
            
        }
        .frame(maxWidth: .infinity, maxHeight: .infinity)
        //        .background(Color.brandDarkColor)
    }
}

struct DashboardView_Previews: PreviewProvider {
    static var previews: some View {
        DashboardView()
    }
}
