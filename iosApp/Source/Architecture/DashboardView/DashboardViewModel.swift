//
//  DashboardViewModel.swift
//  iosApp
//
//  Created by Yurii Goroshenko on 19.01.2024.
//

import shared
import SwiftUI

protocol DashboardViewModelProtocol: ObservableObject {
    var searchData: FieldData { get set }
    var toServiceDetail: Bool { get set }
    var toSearchFilter: Bool { get set }
    var toCancelVisit: Bool { get set }
    var detectHeight: CGFloat { get set }
    var restaurants: [Restaurant] { get set }
    
    func displayPlaces(data: [String])
    func getPlaces()
}

final class DashboardViewModel: DashboardViewModelProtocol {
    // MARK: - Properties
    private let repository = shared.PlaceRepository()
    @Published var searchData = FieldData(placeholder: String(localized: "SEARCH"))
    @Published var toServiceDetail = false
    @Published var toSearchFilter = false
    @Published var toCancelVisit = false
    @Published var detectHeight: CGFloat = 0
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
        repository.getPlaces(
            type: PLACETYPE.barber,
            location: shared.Location(longitude: 30.5833821, latitude: 50.465645),
            radius: 17
        ) { _, _ in
            //            presenter.displayPlaces(listOf(it.data?.nextPageToken.orEmpty()))
            printLog("")
        }
    }
}
