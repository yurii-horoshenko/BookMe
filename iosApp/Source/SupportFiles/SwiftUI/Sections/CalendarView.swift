//
//  CalendarView.swift
//  iosApp
//
//  Created by Yurii Goroshenko on 23.11.2023.
//

import SwiftUI

struct CalendarView: View {
    // MARK: - Properties
    @Binding var date: Date
    
    // MARK: - Lifecycle
    var body: some View {
        VStack(alignment: .leading, spacing: 16.0) {
            Text("Select Date")
                .font(Font.H5Bold)
                .foregroundColor(Color.greyscale900)
            
            DatePicker("", selection: $date, displayedComponents: .date)
                .datePickerStyle(GraphicalDatePickerStyle())
                .frame(maxHeight: 300)
                .accentColor(Color.primary500)
                .padding(16.0)
                .presentationDetents([.height(360)])
                .background(Color.primary500.opacity(0.05))
                .cornerRadius(12.0)
        }
    }
}

#Preview {
    CalendarView(
        date: .constant(Date())
    )
}
