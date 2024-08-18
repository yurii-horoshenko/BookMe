//
//  DashboardViewModel.swift
//  iosApp
//
//  Created by Yurii Goroshenko on 19.01.2024.
//

import shared
import SwiftUI

// TEMP
struct Restaurant: Identifiable {
    let id = UUID()
    let name: String
}

protocol DashboardViewModelProtocol: ObservableObject {
    var searchData: FieldData { get set }
    var toServiceDetail: Bool { get set }
    var toSearchFilter: Bool { get set }
    var toCancelVisit: Bool { get set }
    var detectHeight: CGFloat { get set }
    var restaurants: [Restaurant] { get set }
    
    func displayPlaces(data: [String])
    func getPlaces()
    func loadData()
}

@Observable
final class DashboardViewModel: DashboardViewModelProtocol {
    // MARK: - Properties
//    private let repository = shared.BookingRepository()
    var searchData = FieldData(placeholder: String(localized: "SEARCH"))
    var toServiceDetail = false
    var toSearchFilter = false
    var toCancelVisit = false
    var detectHeight: CGFloat = 0
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
//        repository.getPlaces(
//            type: PLACETYPE.barber,
//            location: shared.Location(longitude: 30.5833821, latitude: 50.465645),
//            radius: 17
//        ) { _, _ in
//            //            presenter.displayPlaces(listOf(it.data?.nextPageToken.orEmpty()))
//            printLog("")
//        }
    }
    
    func loadData() {
//        repository.getBooking(count: 10) { _, _ in
//            print("")
//        }
    }
}
