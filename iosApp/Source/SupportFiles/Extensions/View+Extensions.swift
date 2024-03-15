//
//  View+Extensions.swift
//  BookMeNow-Develop
//
//  Created by Yurii Goroshenko on 19.07.2023.
//

import SwiftUI

// MARK: - View
extension View {
    func setRootView(_ view: some View) {
        let window = UIApplication.shared.connectedScenes.flatMap({ ($0 as? UIWindowScene)?.windows ?? [] }).first { $0.isKeyWindow }
        window?.rootViewController = UIHostingController(rootView: view)
    }
    
    var defaultEdgeInsets: EdgeInsets {
        EdgeInsets(top: 8.0, leading: 32.0, bottom: 8.0, trailing: 32.0)
    }
    
    var buttonEdgeInsets: EdgeInsets {
        EdgeInsets(top: 11.0, leading: 16.0, bottom: 11.0, trailing: 16.0)
    }
    
    func isHidden(_ isHidden: Bool) -> Self? {
        isHidden ? nil : self
    }
    
    func placeholder<Content: View>(when shouldShow: Bool, alignment: Alignment = .leading, @ViewBuilder placeholder: () -> Content) -> some View {
        ZStack(alignment: alignment) {
            placeholder().opacity(shouldShow ? 1 : 0)
            self
        }
    }
}

// MARK: - UIScreen
extension UIScreen {
   static let screenWidth = UIScreen.main.bounds.size.width
   static let screenHeight = UIScreen.main.bounds.size.height
   static let screenSize = UIScreen.main.bounds.size
}
