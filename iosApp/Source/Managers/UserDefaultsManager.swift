//
//  UserDefaultsManager.swift
//  Created by Yurii Goroshenko on 29.03.2023.
//

import Foundation

enum UserDefaultsManager {
    private enum Key: String {
        case isLoggined = "application.ud.isLoggined"
        case wasTutorial = "application.ud.wasTutorial"
    }
    
    // MARK: - Properties
    static var isLoggined: Bool {
        get { UserDefaults.standard.object(forKey: Key.isLoggined.rawValue) as? Bool ?? false }
        set { UserDefaults.standard.setValue(newValue, forKey: Key.isLoggined.rawValue) }
    }
    
    static var wasTutorial: Bool {
        get { UserDefaults.standard.object(forKey: Key.wasTutorial.rawValue) as? Bool ?? false }
        set { UserDefaults.standard.setValue(newValue, forKey: Key.wasTutorial.rawValue) }
    }
}
