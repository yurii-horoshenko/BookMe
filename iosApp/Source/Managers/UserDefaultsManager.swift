//
//  UserDefaultsManager.swift
//  Created by Yurii Goroshenko on 29.03.2023.
//

import Foundation

enum UserDefaultsManager {
    private enum Key: String {
        case isLoggined = "application.ud.isLoggined"
    }
    
    // MARK: - Properties
    static var isLoggined: Bool {
        get { UserDefaults.standard.object(forKey: Key.isLoggined.rawValue) as? Bool ?? true }
        set { UserDefaults.standard.setValue(newValue, forKey: Key.isLoggined.rawValue) }
    }
}
