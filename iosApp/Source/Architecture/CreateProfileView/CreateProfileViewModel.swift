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
    @Published var fullname = FieldData(placeholder: String(localized: "PROFILE-FULLNAME"))
    @Published var nickname = FieldData(placeholder: String(localized: "PROFILE-NICKNAME"))
    @Published var dateBirthday = FieldData(placeholder: String(localized: "PROFILE-DATEBIRTHDAY"))
    @Published var phone = FieldData(placeholder: String(localized: "PROFILE-PHONE"))
    @Published var gender = FieldData(placeholder: String(localized: "PROFILE-GENDER"))
    @Published var toGenderSelection = false
    @Published var toCode = false
    var profile: Profile?
    
    // MARK: - Lifecycle
    deinit {
        printLog("deinit -> ", self)
    }
    
    init(profile: Profile? = nil) {
        self.profile = profile
    }
    
    // MARK: - Public
    func codeVerification() {
        toCode = true
    }
    
    func genderSelection() {
        toGenderSelection = true
    }
}
