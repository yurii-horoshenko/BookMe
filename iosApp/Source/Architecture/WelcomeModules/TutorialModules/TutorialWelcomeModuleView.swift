//
//  TutorialWelcomeModuleView.swift
//  iosApp
//
//  Created by Yurii Goroshenko on 16.01.2024.
//

import SwiftUI

struct TutorialWelcomeModuleView: View {
    // MARK: - Properties
    @State var toLogin = false
    
    // MARK: - Lifecycle
    var body: some View {
        NavigationStack {
            ContentView
                .ignoresSafeArea(.all)
                .background(Color.black)
                .navigationDestination(isPresented: $toLogin) {
                    TutorialDescriptionModuleView()
                }
        }
        .onAppear {
            DispatchQueue.main.asyncAfter(deadline: .now() + 2.0) {
                self.toLogin = true
            }
        }
    }
    
    var ContentView: some View {
        ZStack {
            Backgrounds.Tutorial
                .opacity(0.85)
            
            VStack {
                Spacer()
                
                VStack(alignment: .leading, spacing: 12.0) {
                    Text(String(localized: "TUTORIAL-TITLE"))
                        .attributed(.H1Bold, color: Color.white)
                    
                    Text(String(localized: "APP-NAME"))
                        .attributed(.H1Bold, color: Color.primary500)
                    
                    Text(String(localized: "TUTORIAL-DESCRIPTION"))
                        .attributed(.BodyXLargeMedium, color: Color.white)
                }
                .padding(.bottom, 64.0)
                .padding(.horizontal, 32.0)
            }
        }
    }
}

#Preview {
    TutorialWelcomeModuleView()
}
