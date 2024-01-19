//
//  BookingViewModel.swift
//  iosApp
//
//  Created by Yurii Goroshenko on 19.01.2024.
//

import shared
import SwiftUI

final class BookingViewModel: ObservableObject {
    // MARK: - Properties
    private let repository = shared.UserRepository()
    @Published var date = Date.now
    
    // MARK: - Lifecycle
    deinit {
        printLog("deinit -> ", self)
    }
}
