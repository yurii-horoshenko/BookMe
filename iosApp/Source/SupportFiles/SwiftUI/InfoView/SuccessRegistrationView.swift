//
//  SuccessRegistrationView.swift
//  iosApp
//
//  Created by Yurii Goroshenko on 21.01.2024.
//

import SwiftUI

struct SuccessRegistrationView: View {
    // MARK: - Lifecycle
    var body: some View {
        VStack(alignment: .center, spacing: 24.0) {
            InfoImages.Registration
                .padding(.horizontal, 44.0)
            
            Text("Congratulations!")
                .font(Font.H4Bold)
                .foregroundColor(Color.primary500)
            
            Text("Your account is ready to use. You will be redirected to the Home page in a few seconds..")
                .font(Font.BodyLargeRegular)
                .foregroundColor(Color.greyscale900)
                .multilineTextAlignment(.center)
            
        }
        .padding(.horizontal, 32.0)
    }
}

#Preview {
    SuccessRegistrationView()
}
