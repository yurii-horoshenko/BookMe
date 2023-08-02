//
//  PhonePresenter.swift
//  BookMeNow-Develop
//
//  Created by Yurii Goroshenko on 23.07.2023.
//

import SwiftUI

final class PhonePresenter: ObservableObject {
    // MARK: - Lifecycle
    deinit {
        printLog("deinit -> ", self)
    }
}
