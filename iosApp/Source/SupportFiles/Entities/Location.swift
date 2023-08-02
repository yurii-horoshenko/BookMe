//
//  Location.swift
//  BookMeNow-Develop
//
//  Created by Yurii Goroshenko on 20.03.2023.
//

import Foundation

struct Address: Decodable {
    let country: String
    let city: String
    let street: String
    let building: String
    let phone: String
}

struct Location: Decodable {
    let latitude: Double
    let longitude: Double
}
