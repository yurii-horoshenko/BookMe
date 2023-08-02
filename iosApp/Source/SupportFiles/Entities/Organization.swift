//
//  Organization.swift
//  MyBarber-Develop
//
//  Created by Yurii Goroshenko on 12/6/22.
//

import CoreLocation
import Foundation

struct OrganizationsResponse: Decodable {
    var data: [Organization]
}

struct Organization: Decodable {
    var id: String = ""
    var name: String = ""
    var imageUrl: String = ""
    var description: String = ""
    var location: Location
    var address: Address
    var images: [String]? = []
//    var rate: Double? = 0.0
    
    init() {
        self.location = Location(latitude: 0.0, longitude: 0.0)
        self.address = Address(country: "", city: "", street: "", building: "0", phone: "")
    }
    
    init(name: String, description: String, imageUrl: String) {
        self.name = name
        self.description = description
        self.imageUrl = imageUrl
        self.location = Location(latitude: 0.0, longitude: 0.0)
        self.address = Address(country: "", city: "", street: "", building: "0", phone: "")
    }
    
    func getCoordinate() -> CLLocationCoordinate2D {
        CLLocationCoordinate2D(latitude: location.latitude, longitude: location.longitude)
    }
}

// MARK: - OrganizationListCellProtocol, BookingCellProtocol
extension Organization {
    var addressText: String {
        ""
    }
    
    var rate: Double {
        0
    }
    var dateTime: String {
        "Friday 12:30"
    }
}
