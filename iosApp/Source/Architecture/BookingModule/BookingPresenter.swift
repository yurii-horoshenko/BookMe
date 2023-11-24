//
//  BookingPresenter.swift
//  iosApp
//
//  Created by Yurii Goroshenko on 23.11.2023.
//

import SwiftUI

final class BookingPresenter: ObservableObject {
    // MARK: - Properties
    @Published var date = Date.now
    
    // MARK: - Lifecycle
    deinit {
        printLog("deinit -> ", self)
    }
}
