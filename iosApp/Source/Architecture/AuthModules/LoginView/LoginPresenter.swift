//
//  LoginPresenter.swift
//  BookMeNow-Develop
//
//  Created by Yurii Goroshenko on 15.08.2023.
//

import SwiftUI

final class LoginPresenter: ObservableObject {
    // MARK: - Properties
    @Published var phoneValue = ""
    @Published var phone = FieldData(placeholder: "Phone Number")
    @Published var toCodeVerification = false
    
    // MARK: - Lifecycle
    deinit {
        printLog("deinit -> ", self)
    }
    
    // MARK: - Public
    func codeVerification() {
        toCodeVerification = true
    }
}
