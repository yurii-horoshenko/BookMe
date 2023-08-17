//
//  BaseView.swift
//  BookMeNow-Develop
//
//  Created by Yurii Goroshenko on 23.07.2023.
//

import SwiftUI

struct BaseView<Content>: View where Content: View {
    // MARK: - PROPERTIES
    @Environment(\.presentationMode)
    var presentationMode: Binding<PresentationMode>
    private let content: Content
    private var navigationTitle: String = ""
    private var leadingView: AnyView?
    private var trailingView: AnyView?
    private var hideBackButton = true
    
    // MARK: - INIT
    init(
        navigationTitle: String = "",
        hideBackButton: Bool = false,
        leadingView: AnyView? = nil,
        trailingView: AnyView? = nil,
        @ViewBuilder content: () -> Content
    ) {
        self.navigationTitle = navigationTitle
        self.hideBackButton = hideBackButton
        self.leadingView = leadingView
        self.trailingView = trailingView
        self.content = content()
        
        //        let appearance = UINavigationController.appearance(with: UIColor.black)
        //        UINavigationBar.appearance().standardAppearance = appearance
        //        UINavigationBar.appearance().scrollEdgeAppearance = appearance
    }
    
    // MARK: - BODY
    var body: some View {
        if hideBackButton {
            VStack { content }
                .frame(maxWidth: .infinity)
                .navigationBarItems(trailing: trailingView)
                .navigationTitle(navigationTitle)
        } else {
            VStack { content }
                .frame(maxWidth: .infinity)
                .navigationBarItems(leading: leadingView ?? backButton)
                .navigationBarItems(trailing: trailingView)
                .navigationTitle(navigationTitle)
        }
    }
    
    var backButton: AnyView {
        Button(
            action: { self.presentationMode.wrappedValue.dismiss() },
            label: { Icons.Back.foregroundColor(Color.greyscale900) }
        )
        .eraseToAnyView()
    }
}
