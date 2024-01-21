//
//  ProfileView.swift
//  BookMeNow-Develop
//
//  Created by Yurii Goroshenko on 24.07.2023.
//

import shared
import SwiftUI

protocol ProfileViewProtocol {
    func logout()
}

struct ProfileView: View {
    // MARK: - Properties
    @StateObject var viewModel: ProfileViewModel
    @State var detentHeight: CGFloat = 0
    
    // MARK: - Lifecycle
    var body: some View {
        NavigationView {
            BaseView(leadingView: LeadingView.eraseToAnyView(), content: { ContentView })
        }
        .navigationBarBackButtonHidden(true)
        .environment(\.colorScheme, .light)
    }
    
    var ContentView: some View {
        VStack(alignment: .center, spacing: 24.0) {
            Spacer()
           
            ProfilePreviewView(
                displayName: "Daniel Austin",
                email: "daniel_austin@yourdomain.com"
            )
            
            ProfileOptionsView
            
            Spacer()
           
            ProfileItemRow(title: "Logout", leftIcon: "ic-logout", rightIcon: "")
                .foregroundColor(Color.error)
                .onTapGesture {
                    viewModel.toLogoutConfirm.toggle()
                }
                .sheet(isPresented: $viewModel.toLogoutConfirm) {
                    LogoutView(
                        toLogoutConfirm: $viewModel.toLogoutConfirm,
                        view: self
                    )
                    .padding(.vertical, 32.0)
                    .readHeight()
                    .onPreferenceChange(HeightPreferenceKey.self) { height in
                        if let height {
                            detentHeight = height
                        }
                    }
                    .presentationDetents([.height(detentHeight)])
                    .presentationDragIndicator(.visible)
                }
        }
        .foregroundColor(Color.greyscale900)
        .padding(.horizontal, 16.0)
    }
    
    var ProfileOptionsView: some View {
        VStack(spacing: 24.0) {
            Divider()
                .background(Color.greyscale200)
                .frame(height: 1.0)
            
            ProfileItemRow(
                title: "Edit Profile",
                leftIcon: "ic-profile"
            )
            
            ProfileItemRow(
                title: "Notification",
                leftIcon: "ic-notification"
                
            )
        }
    }
    
    var LeadingView: some View {
        HStack(spacing: 16.0) {
            Images.Logo
            
            Text("Profile")
                .font(Font.H4Bold)
                .foregroundColor(Color.greyscale900)
        }
    }
}

// MARK: - ProfileViewProtocol
extension ProfileView: ProfileViewProtocol {
    func logout() {
        let view = AuthPageBuilder.constructWelcomeView()
        setRootView(view)
    }
}

#Preview {
    ProfilePageBuilder.constructProfileView()
}
