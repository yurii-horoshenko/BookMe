//
//  DashboardPresenter.swift
//  BookMeNow-Develop
//
//  Created by Yurii Goroshenko on 16.08.2023.
//

import shared
import SwiftUI

final class DashboardPresenter: shared.DashboardPresenterContract, ObservableObject {    
    // MARK: - Properties
    @Published var searchData = FieldData(placeholder: "Search")
    @State var toServiceDetail = false
    var restaurants = [
        Restaurant(name: "Joe's Original"),
        Restaurant(name: "The Real Joe's Original"),
        Restaurant(name: "Original Joe's")
    ]
    
    // MARK: - Lifecycle
    func displayPlaces(data: [String]) {
        restaurants = []
    }
}
