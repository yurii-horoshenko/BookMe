//
//  NearByViewModel.swift
//  iosApp
//
//  Created by Yurii Goroshenko on 19.01.2024.
//

import shared
import SwiftUI

protocol NearByViewModelProtocol: ObservableObject {
    var searchData: FieldData { get set }
    var detectHeight: CGFloat { get set }
    var toSearchFilter: Bool { get set }
}

final class NearByViewModel: NearByViewModelProtocol {
    // MARK: - Properties
//    private let repository = shared.UserRepository()
    @Published var searchData = FieldData(placeholder: "Search")
    @Published var detectHeight: CGFloat = 0
    @Published var toSearchFilter = false
    
    // MARK: - Lifecycle
    deinit {
        printLog("deinit -> ", self)
    }
    
}
