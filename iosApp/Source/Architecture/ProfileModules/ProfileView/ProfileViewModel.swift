//
//  ProfileViewModel.swift
//  iosApp
//
//  Created by Yurii Goroshenko on 19.01.2024.
//

import shared
import SwiftUI

final class ProfileViewModel: ObservableObject {
    // MARK: - Properties
    private let repository = shared.UserRepository()
    @Published var toLogout = false
    
    // MARK: - Lifecycle
    deinit {
        printLog("deinit -> ", self)
    }
}
