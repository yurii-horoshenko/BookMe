//
//  ContactsView.swift
//  iosApp
//
//  Created by Yurii Goroshenko on 23.11.2023.
//

import SwiftUI

struct ContactsView: View {
    // MARK: - Properties
    var contacts = ["(406) 555-0120"]
    
    // MARK: - Lifecycle
    var body: some View {
        VStack(alignment: .leading, spacing: 16.0) {
            Text("Contact us")
                .font(Font.H6Bold)
                .foregroundColor(Color.greyscale900)
            
            VStack(alignment: .leading, spacing: 8.0) {
                ForEach(contacts, id: \.self) { contact in
                    Text(contact)
                        .font(Font.H6Bold)
                        .foregroundColor(Color.primary500)
                }
            }
        }
    }
}

#Preview {
    ContactsView()
        .padding(16.0)
        .edgesIgnoringSafeArea(.top)
}
