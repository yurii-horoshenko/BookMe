//
//  CreateProfilePresenter.swift
//  BookMeNow-Develop
//
//  Created by Yurii Goroshenko on 03.08.2023.
//

import SwiftUI

final class CreateProfilePresenter: ObservableObject {
    @Published var fullname = FieldData(placeholder: "Full Name")
    @Published var nickname = FieldData(placeholder: "Nickname")
    @Published var dateBirthday = FieldData(placeholder: "Date of Birth")
    @Published var phone = FieldData(placeholder: "Phone Number")
    @Published var gender = FieldData(placeholder: "Gender")
    
    // MARK: - Lifecycle
    deinit {
        printLog("deinit -> ", self)
    }
}
