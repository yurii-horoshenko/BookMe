//
//  DashboardViewModel.swift
//  iosApp
//
//  Created by Yurii Goroshenko on 19.01.2024.
//

import shared
import SwiftUI

final class DashboardViewModel: ObservableObject {
    // MARK: - Properties
    private let repository = shared.UserRepository()
    @Published var searchData = FieldData(placeholder: "Search")
    @Published var toServiceDetail = false
    var restaurants = [
        Restaurant(name: "Joe's Original"),
        Restaurant(name: "The Real Joe's Original"),
        Restaurant(name: "Original Joe's")
    ]
    
    // MARK: - Lifecycle
    deinit {
        printLog("deinit -> ", self)
    }
    
    // MARK: - Lifecycle
    func displayPlaces(data: [String]) {
        restaurants = []
    }
    
    func getPlaces() {
        
    }
}
