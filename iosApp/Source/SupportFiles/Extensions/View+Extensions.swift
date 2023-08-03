//
//  View+Extensions.swift
//  BookMeNow-Develop
//
//  Created by Yurii Goroshenko on 19.07.2023.
//

import SwiftUI

// MARK: - State
enum StateView {
    case idle
    case loading
    case error
    case finished
}

protocol StateViewProtocol {
    var state: StateView { get }
}

// MARK: - View
extension View {
    var screenWidth: CGFloat {
        UIScreen.main.bounds.width
    }
    
    func setRootView(_ view: some View) {
        let window = UIApplication
            .shared
            .connectedScenes
            .flatMap({ ($0 as? UIWindowScene)?.windows ?? [] })
            .first { $0.isKeyWindow }
        
        window?.rootViewController = UIHostingController(rootView: view)
    }
    
    var defaultEdgeInsets: EdgeInsets {
        EdgeInsets(top: 8.0, leading: 24.0, bottom: 8.0, trailing: 24.0)
    }
}

extension View {
    func eraseToAnyView() -> AnyView {
        AnyView(self)
    }
}
