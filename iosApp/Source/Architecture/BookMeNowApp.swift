//
//  BookMeNowApp.swift
//  BookMeNow
//
//  Created by Yurii Goroshenko on 19.07.2023.
//

import shared
import SwiftUI

@main
struct BookMeNowApp: App {
    var body: some Scene {
        WindowGroup {
            constructMainView()
        }
    }
    
    func constructMainView() -> some View {
        let presenter = SplashPresenter()
        let interactor = SplashInteractor()
        let view = SplashView(interactor: interactor)
        interactor.presenter = presenter
        presenter.view = view
        
        return view
    }
}
