//
//  ProfileView.swift
//  BookMeNow-Develop
//
//  Created by Yurii Goroshenko on 24.07.2023.
//

import shared
import SwiftUI

struct ProfileView: View {
    // MARK: - Properties
    @StateObject var viewModel: ProfileViewModel
    @State var detentHeight: CGFloat = 0
    
    // MARK: - Lifecycle
    var body: some View {
        NavigationView {
            NavigationStack {
                BaseView(
                    leadingView: LeadingView.eraseToAnyView(),
                    content: { ContentView }
                )
                //                .navigationDestination(isPresented: $presenter.toServiceDetail) {
                //                    ServiceDetailView()
                //                }
            }
        }
        .navigationBarBackButtonHidden(true)
        .environment(\.colorScheme, .light)
        .onAppear {
            //            interactor?.getPlaces()
        }
    }
    
    var ContentView: some View {
        VStack(alignment: .center, spacing: 24.0) {
            Spacer()
            ProfilePreviewView(
                displayName: "Daniel Austin",
                email: "daniel_austin@yourdomain.com"
            )
            Divider()
                .background(Color.greyscale200)
                .frame(height: 1.0)
            ProfileItemRow(title: "Edit Profile", leftIcon: "ic-profile")
            ProfileItemRow(title: "Notification", leftIcon: "ic-notification")
            Spacer()
            ProfileItemRow(title: "Logout", leftIcon: "ic-logout", rightIcon: "")
                .foregroundColor(Color.error)
                .onTapGesture {
                    viewModel.toLogout.toggle()
                }
                .sheet(isPresented: $viewModel.toLogout) {
                    LogoutView()
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
    
    var LeadingView: some View {
        HStack(spacing: 16.0) {
            Images.Logo
            
            Text("Profile")
                .font(Font.H4Bold)
                .foregroundColor(Color.greyscale900)
        }
    }
}

#Preview {
    ProfilePageBuilder.constructProfileView()
}
