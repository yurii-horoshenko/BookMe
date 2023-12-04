//
//  NearByPresenter.swift
//  iosApp
//
//  Created by Yurii Goroshenko on 04.12.2023.
//

import MapKit
import SwiftUI

final class NearByPresenter: ObservableObject {
    // MARK: - Properties
    @State var region = MKCoordinateRegion(
        center: CLLocationCoordinate2D(latitude: 51.507222, longitude: -0.1275),
        span: MKCoordinateSpan(latitudeDelta: 0.5, longitudeDelta: 0.5)
    )
    @Published var searchData = FieldData(placeholder: "Search")
    
    // MARK: - Lifecycle
    deinit {
        printLog("deinit -> ", self)
    }
}
