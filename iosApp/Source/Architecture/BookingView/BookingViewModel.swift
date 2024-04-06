//
//  BookingViewModel.swift
//  iosApp
//
//  Created by Yurii Goroshenko on 19.01.2024.
//

import shared
import SwiftUI

protocol BookingViewModelProtocol: ObservableObject {
    var date: Date { get set }
    
    func loadData()
}

final class BookingViewModel: BookingViewModelProtocol {
    // MARK: - Properties
//    private let repository = shared.BookingRepository()
    @Published var date = Date.now
    
    // MARK: - Lifecycle
    deinit {
        printLog("deinit -> ", self)
    }
    
    func loadData() {
//        repository.getBooking(count: 10) { _, _ in
//            print("")
//        }
    }    
}
