//
//  ServiceDetailView.swift
//  BookMeNow-Develop
//
//  Created by Yurii Goroshenko on 13.09.2023.
//

import SwiftUI

struct ServiceDetailView: View {
    @ObservedObject var presenter = ServiceDetailPresenter()
    
    var body: some View {
        Text(/*@START_MENU_TOKEN@*/"Hello, World!"/*@END_MENU_TOKEN@*/)
    }
}

struct ServiceDetailView_Previews: PreviewProvider {
    static var previews: some View {
        ServiceDetailView()
    }
}
