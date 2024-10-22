//
//  ServiceDetailViewModel.swift
//  iosApp
//
//  Created by Yurii Goroshenko on 19.01.2024.
//

import shared

protocol ServiceDetailViewModelProtocol: ObservableObject {
    var toBooking: Bool { get set }
}

@Observable
final class ServiceDetailViewModel: ServiceDetailViewModelProtocol {
    // MARK: - Properties
//    private let repository = shared.UserRepository()
    var toBooking = false
    
    // MARK: - Lifecycle
    deinit {
        printLog("deinit -> ", self)
    }
    
}
