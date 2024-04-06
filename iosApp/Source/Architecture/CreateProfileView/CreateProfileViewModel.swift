//
//  CreateProfileViewModel.swift
//  iosApp
//
//  Created by Yurii Goroshenko on 19.01.2024.
//

import shared
import SwiftUI

protocol CreateProfileViewModelProtocol: ObservableObject {
    var profile: Profile? { get set }
    var fullname: FieldData { get set }
    var nickname: FieldData { get set }
    var dateBirthday: FieldData { get set }
    var phone: FieldData { get set }
    var gender: FieldData { get set }
    var toGenderSelection: Bool { get set }
    var toCode: Bool { get set }
    
    func codeVerification()
    func genderSelection()
}

final class CreateProfileViewModel: CreateProfileViewModelProtocol {
    // MARK: - Properties
//    private let repository = shared.UserRepository()
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
