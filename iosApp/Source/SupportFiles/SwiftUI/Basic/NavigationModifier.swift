//
//  NavigationModifier.swift
//  iosApp
//
//  Created by Yurii Goroshenko on 07.10.2024.
//

import SwiftUI
import UIKit

private struct NavigationModifier: ViewModifier {
    // MARK: - Properties
    @Environment(\.presentationMode)
    var presentationMode: Binding<PresentationMode>

    private var title: String?
    private var leadingView: AnyView?
    private var trailingView: AnyView?
    private let iconColor: Color
    private var hideBackButton = true
    
    var backButton: some View {
        Button(
            action: { presentationMode.wrappedValue.dismiss() },
            label: { Icons.Back.foregroundColor(iconColor) }
        )
    }
    
    // MARK: - Init
    init(
        title: String? = nil,
        leadingView: AnyView? = nil,
        trailingView: AnyView? = nil,
        iconColor: Color = Color.greyscale900,
        hideBackButton: Bool = false
    ) {
        self.title = title
        self.leadingView = leadingView
        self.trailingView = trailingView
        self.iconColor = iconColor
        self.hideBackButton = hideBackButton
        
        let appearance = UINavigationBarAppearance()
        appearance.configureWithTransparentBackground()
        appearance.backgroundColor = .clear
        appearance.shadowColor = .clear
//        appearance.titleTextAttributes = [.foregroundColor: iconColor]
        
        UINavigationBar.appearance().standardAppearance = appearance
        UINavigationBar.appearance().scrollEdgeAppearance = appearance
    }
    
    func body(content: Content) -> some View {
        if let title {
            content
                .navigationTitle(title)
                .navigationBarTitleDisplayMode(.large)
                .navigationBarBackButtonHidden()
                .navigationBarItems(leading: leadingView ?? AnyView(backButton))
                .navigationBarItems(trailing: trailingView)
        } else {
            content
                .navigationBarBackButtonHidden()
                .navigationBarItems(leading: leadingView ?? AnyView(backButton))
                .navigationBarItems(trailing: trailingView)
        }
    }
}

extension View {
    func showNavigationBar(
        title: String? = nil,
        leadingView: AnyView? = nil,
        trailingView: AnyView? = nil
    ) -> some View {
        self.modifier(NavigationModifier(title: title, leadingView: leadingView, trailingView: trailingView))
    }
}

#Preview {
    NavigationStack {
        VStack {
            Text("Hello, World!")
        }
        .showNavigationBar(title: "Test")
    }
}
