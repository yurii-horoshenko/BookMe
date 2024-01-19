//
//  SplashView.swift
//  BookMeNow
//
//  Created by Yurii Goroshenko on 19.07.2023.
//

import SwiftUI

protocol SplashViewProtocol {
    func moveToTutorialPage()
    func moveToWelcomePage()
    func moveToDashboardPage()
}

struct SplashView: View {
    // MARK: - Properties
    @StateObject var viewModel: SplashViewModel
    
    // MARK: - Lifecycle
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
            viewModel.detectNavigation()
        }
    }
    
}

// MARK: - SplashViewProtocol
extension SplashView: SplashViewProtocol {
    func moveToTutorialPage() {
        let view = TutorialWelcomeModuleView()
        setRootView(view)
    }
    
    func moveToWelcomePage() {
        let view = ModelViewBuilder.constructWelcomeView()
        setRootView(view)
    }
    
    func moveToDashboardPage() {
        let view = DashboardContainerView()
        setRootView(view)
    }
}

#Preview {
    ModelViewBuilder.constructSplashView()
}
