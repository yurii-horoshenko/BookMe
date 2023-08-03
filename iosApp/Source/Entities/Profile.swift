//
//  Profile.swift
//  MyBarber-Develop
//
//  Created by Yurii Goroshenko on 1/16/23.
//

import Foundation

final class Profile: Decodable {
    var userId: String = ""
    var displayName: String = ""
    var firstName: String = ""
    var lastName: String = ""
    var phone: String = ""
}
