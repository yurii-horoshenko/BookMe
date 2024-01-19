//
//  CreateProfileViewModel.swift
//  iosApp
//
//  Created by Yurii Goroshenko on 19.01.2024.
//

import shared
import SwiftUI

final class CreateProfileViewModel: ObservableObject {
    // MARK: - Properties
    private let repository = shared.UserRepository()
    @Published var fullname = FieldData(placeholder: "Full Name")
    @Published var nickname = FieldData(placeholder: "Nickname")
    @Published var dateBirthday = FieldData(placeholder: "Date of Birth")
    @Published var phone = FieldData(placeholder: "Phone Number")
    @Published var gender = FieldData(placeholder: "Gender")
    @Published var toGenderSelection = false
    @Published var toCode = false
    
    // MARK: - Lifecycle
    deinit {
        printLog("deinit -> ", self)
    }

    // MARK: - Public
    func codeVerification() {
        toCode = true
    }
        
    func genderSelection() {
        toGenderSelection = true
    }
}
