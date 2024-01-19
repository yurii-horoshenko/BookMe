//
//  LoginViewModel.swift
//  iosApp
//
//  Created by Yurii Goroshenko on 19.01.2024.
//

import shared
import SwiftUI

final class LoginViewModel: ObservableObject {
    // MARK: - Properties
    private let repository = shared.UserRepository()
    @Published var phone = FieldData(placeholder: "Phone Number")
    @Published var toCode = false
    
    // MARK: - Lifecycle
    deinit {
        printLog("deinit -> ", self)
    }

    // MARK: - Public
    func codeVerification() {
        toCode = true
    }
}
