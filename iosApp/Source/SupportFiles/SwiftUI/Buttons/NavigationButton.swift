//
//  NavigationButton.swift
//  iosApp
//
//  Created by Yurii Goroshenko on 07.03.2024.
//

import SwiftUI

enum Steps: Hashable {
    case empty
    case enterCode(String)
    case dashboard
    
    var PageView: some View {
        switch self {
        case .empty:
            return AnyView(EmptyView())
            
        case .enterCode(let phone):
            return AnyView(AuthPageBuilder.constructEnterCodeView(phoneMask: ""))
            
        case .dashboard:
            return AnyView(AuthPageBuilder.constructEnterCodeView(phoneMask: ""))

        }
    }
}

struct NavigationButton<Link: Hashable>: View {
    var autoWidth = false
    var title: String
    var titleColor = Color.greyscale900
    var backgroundColor = Color.black
    var navigationType: Link?
    
    var body: some View {
        NavigationLink(title, value: navigationType)
            .frame(maxHeight: 60.0)
            .frame(maxWidth: autoWidth ? .none : .infinity)
            .font(Font.BodyLargeSemibold)
            .foregroundColor(Color.white)
            .background(Color.primary500)
            .cornerRadius(30.0)
            .shadow(color: Color.black.opacity(0.75), radius: 6.0)
    }
}

#Preview {
    NavigationButton<Steps>(
        title: "Next",
        navigationType: .empty
    )
}
