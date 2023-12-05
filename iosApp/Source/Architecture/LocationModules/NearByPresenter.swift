//
//  NearByPresenter.swift
//  iosApp
//
//  Created by Yurii Goroshenko on 04.12.2023.
//

import SwiftUI

final class NearByPresenter: ObservableObject {
    // MARK: - Properties
    @Published var searchData = FieldData(placeholder: "Search")
    
    // MARK: - Lifecycle
    deinit {
        printLog("deinit -> ", self)
    }
}
