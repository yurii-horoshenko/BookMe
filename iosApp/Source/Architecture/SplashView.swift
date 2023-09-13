//
//  SplashView.swift
//  BookMeNow
//
//  Created by Yurii Goroshenko on 19.07.2023.
//

import SwiftUI

struct SplashView: View {
    
    // MARK: - Body
    var body: some View {
        VStack {
            Spacer()
            
            Text("BookMeNow")
                .attributed(.H1Bold, color: Color.primary500)
                .padding(24.0)
            
            Spacer()
        }
        .ignoresSafeArea(.all)
        .background(Color.background)
        .onAppear {
            DispatchQueue.main.asyncAfter(deadline: .now() + 2.0) {
//                self.setRootView(WelcomeView())
                self.setRootView(DashboardContainerView())
            }
        }
    }
}

struct SplashView_Previews: PreviewProvider {
    static var previews: some View {
        SplashView()
    }
}
