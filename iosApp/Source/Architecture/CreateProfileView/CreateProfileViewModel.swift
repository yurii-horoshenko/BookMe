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

final class CreateProfileViewModel: CreateProfileViewModelProtocol {
    // MARK: - Properties
    private let repository: ProfileRepositoryProtocol = ServiceLocator.shared.profileRepository
    @Published var fullname = FieldData(placeholder: String(localized: "PROFILE-FULLNAME"))
    @Published var nickname = FieldData(placeholder: String(localized: "PROFILE-NICKNAME"))
    @Published var dateBirthday = FieldData(placeholder: String(localized: "PROFILE-DATEBIRTHDAY"))
    @Published var phone = FieldData(placeholder: String(localized: "PROFILE-PHONE"))
    @Published var email = FieldData(placeholder: String(localized: "PROFILE-EMAIL"))
    @Published var gender = FieldData(placeholder: String(localized: "PROFILE-GENDER"))
    @Published var toGenderSelection = false
    @Published var toCode = false
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
