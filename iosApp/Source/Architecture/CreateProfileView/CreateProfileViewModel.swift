//
//  CreateProfileViewModel.swift
//  iosApp
//
//  Created by Yurii Goroshenko on 19.01.2024.
//

import shared
import SwiftUI

protocol CreateProfileViewModelProtocol: ObservableObject {
    var currentProfile: shared.ProfileModel { get set }
    var isCreate: Bool { get set }
    var fullname: FieldData { get set }
    var nickname: FieldData { get set }
    var dateBirthday: FieldData { get set }
    var email: FieldData { get set }
    var phone: FieldData { get set }
    var gender: FieldData { get set }
    var toGenderSelection: Bool { get set }
    var toCode: Bool { get set }
    
    func codeVerification()
    func genderSelection()
}

@Observable
final class CreateProfileViewModel: CreateProfileViewModelProtocol {
    // MARK: - Properties
    private let repository: ProfileRepositoryProtocol = ProfileRepository()
    var fullname = FieldData(placeholder: String(localized: "PROFILE-FULLNAME"))
    var nickname = FieldData(placeholder: String(localized: "PROFILE-NICKNAME"))
    var dateBirthday = FieldData(placeholder: String(localized: "PROFILE-DATEBIRTHDAY"))
    var phone = FieldData(placeholder: String(localized: "PROFILE-PHONE"))
    var email = FieldData(placeholder: String(localized: "PROFILE-EMAIL"))
    var gender = FieldData(placeholder: String(localized: "PROFILE-GENDER"))
    var toGenderSelection = false
    var toCode = false
    var currentProfile: shared.ProfileModel
    var isCreate: Bool
    
    // MARK: - Lifecycle
    deinit {
        printLog("deinit -> ", self)
    }
    
    init(profile: shared.ProfileModel, isCreate: Bool) {
        self.currentProfile = profile
        self.isCreate = isCreate
        fullname.value = currentProfile.fullName
        email.value = currentProfile.email
    }
    
    // MARK: - Public
    func codeVerification() {
        toCode = true
    }
    
    func genderSelection() {
        toGenderSelection = true
    }
}
