//
//  LogoutView.swift
//  iosApp
//
//  Created by Yurii Goroshenko on 05.12.2023.
//

import SwiftUI

struct LogoutView: View {
    @Binding var toLogoutConfirm: Bool
    var view: ProfileViewProtocol?
    
    // MARK: - Lifecycle
    var body: some View {
        VStack(alignment: .center, spacing: 24.0) {
            Text("Logout")
                .font(Font.H4Bold)
                .foregroundColor(Color.error)
            
            Divider()
                .background(Color.greyscale200)
                .frame(height: 1.0)
                .padding(.horizontal, 16.0)
            
            Text("Are you sure you want to log out?")
                .font(Font.H5Bold)
                .foregroundColor(Color.greyscale900)
            
            HStack {
                AppFilledButton(
                    state: .constant(.active),
                    title: "Cancel",
                    titleColor: Color.primary500,
                    backgroundColor: Color.primary100,
                    action: { toLogoutConfirm = false }
                )
                
                AppFilledButton(
                    state: .constant(.active),
                    title: "Yes, Logout",
                    titleColor: Color.white,
                    backgroundColor: Color.primary500,
                    action: {
                        toLogoutConfirm = false
                        view?.logout()
                    }
                )
            }
            .padding(.horizontal, 16.0)
        }
    }
}

#Preview {
    LogoutView(
        toLogoutConfirm: .constant(false)
    )
}
