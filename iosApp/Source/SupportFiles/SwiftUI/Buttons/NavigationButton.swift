//
//  NavigationButton.swift
//  iosApp
//
//  Created by Yurii Goroshenko on 07.03.2024.
//

import SwiftUI

struct NavigationValueButton<Link: Hashable>: View {
    var autoWidth = false
    var title: String
    var titleColor = Color.greyscale900
    var backgroundColor = Color.black
    var navigationType: Link?
    
    var body: some View {
        NavigationLink(title, value: navigationType)
            .padding()
            .frame(maxHeight: 60.0)
            .frame(maxWidth: autoWidth ? .none : .infinity)
            .font(Font.BodyLargeSemibold)
            .foregroundColor(Color.white)
            .background(backgroundColor)
            .cornerRadius(30.0)
            .shadow(color: backgroundColor.opacity(0.75), radius: 6.0)
    }
}

struct NavigationDestinationButton: View {
    var autoWidth = false
    var title: String
    var titleColor = Color.greyscale900
    var backgroundColor = Color.black
    var nextView: AnyView
    
    var body: some View {
        NavigationLink(destination: nextView) {
            Text(title)
        }
        .padding()
        .frame(maxHeight: 60.0)
        .frame(maxWidth: autoWidth ? .none : .infinity)
        .font(Font.BodyLargeSemibold)
        .foregroundColor(Color.white)
        .background(backgroundColor)
        .cornerRadius(30.0)
        .shadow(color: backgroundColor.opacity(0.75), radius: 6.0)
    }
}

#Preview {
    VStack {
        NavigationValueButton<Steps>(
            title: "Next",
            navigationType: Steps.dashboard
        )
        
        NavigationDestinationButton(
            title: "Next",
            nextView: AnyView(Steps.dashboard.PageView)
        )
    }
}
