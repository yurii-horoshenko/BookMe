//
//  ProfilePreviewView.swift
//  iosApp
//
//  Created by Yurii Goroshenko on 04.12.2023.
//

import SwiftUI

struct ProfilePreviewView: View {
    // MARK: - Properties
    let displayName: String
    let email: String
    
    // MARK: - Lifecycle
    var body: some View {
        VStack(alignment: .center, spacing: 24.0) {
            Images.Welcome
                .frame(width: 120.0, height: 120.0)
            
            Text(displayName)
                .font(Font.H4Bold)
            
            Text(email)
                .font(Font.BodyMediumSemibold)
        }
    }
}

#Preview {
    ProfilePreviewView(
        displayName: "Daniel Austin",
        email: "daniel_austin@yourdomain.com"
    )
}
