//
//  CreateProfilePresenter.swift
//  BookMeNow-Develop
//
//  Created by Yurii Goroshenko on 03.08.2023.
//

import SwiftUI

final class CreateProfilePresenter: ObservableObject {
    // MARK: - Properties
    @Published var fullname = FieldData(placeholder: "Full Name")
    @Published var nickname = FieldData(placeholder: "Nickname")
    @Published var dateBirthday = FieldData(placeholder: "Date of Birth")
    @Published var phone = FieldData(placeholder: "Phone Number")
    @Published var gender = FieldData(placeholder: "Gender")
    @Published var toCodeVerification = false
    @Published var toGenderSelection = false
    
    // MARK: - Lifecycle
    deinit {
        printLog("deinit -> ", self)
    }
    
    // MARK: - Public
    func codeVerification() {
        toCodeVerification = true
    }
    
    func genderSelection() {
        toGenderSelection = true
    }
}
