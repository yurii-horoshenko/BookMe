//
//  WelcomePresenter.swift
//  BookMeNow-Develop
//
//  Created by Yurii Goroshenko on 20.07.2023.
//

import SwiftUI

final class WelcomePresenter: ObservableObject {

    // MARK: - Lifecycle
    deinit {
        printLog("deinit -> ", self)
    }
}
