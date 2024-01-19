//
//  NearByViewModel.swift
//  iosApp
//
//  Created by Yurii Goroshenko on 19.01.2024.
//

import shared
import SwiftUI

final class NearByViewModel: ObservableObject {
    // MARK: - Properties
    private let repository = shared.UserRepository()
    @Published var searchData = FieldData(placeholder: "Search")
    
    // MARK: - Lifecycle
    deinit {
        printLog("deinit -> ", self)
    }
    
}
