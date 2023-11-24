//
//  DashboardPresenter.swift
//  BookMeNow-Develop
//
//  Created by Yurii Goroshenko on 16.08.2023.
//

import SwiftUI

final class DashboardPresenter: ObservableObject {
    // MARK: - Properties
    @Published var searchData = FieldData(placeholder: "Search")
    @Published var toServiceDetail = false
    
}
