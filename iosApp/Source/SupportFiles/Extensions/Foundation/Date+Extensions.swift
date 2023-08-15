//
//  Date+Extensions.swift
//  ARContainer
//
//  Created by Yurii Goroshenko on 10/6/22.
//

import Foundation

extension Date {
    var toString: String {
        let dateFormatter = TimeInterval.dateFormatter
        dateFormatter.dateFormat = "dd/MM/yyyy"
        return dateFormatter.string(from: self)
    }
}

extension TimeInterval {
    static var dateFormatter: DateFormatter = {
        let formatter = DateFormatter()
        formatter.dateFormat = "MMM d, yyyy"
        formatter.timeZone = TimeZone(abbreviation: "en_US_POSIX")
        return formatter
    }()

    func toDateString() -> String {
        Self.dateFormatter.string(from: Date(timeIntervalSince1970: self))
    }
}
