//
//  String+Extensions.swift
//  BookMeNow-Develop
//
//  Created by Yurii Goroshenko on 14.08.2023.
//

import SwiftUI

extension String {
    var phoneMask: String {
        let firstPart = self.prefix(8)
        let endPart = self.suffix(2)
        let middlePart = "*** ** "
        return firstPart + middlePart + endPart
    }
}
