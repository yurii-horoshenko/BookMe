//
//  CreateProfileView.swift
//  BookMeNow-Develop
//
//  Created by Yurii Goroshenko on 03.08.2023.
//

import SwiftUI

struct CreateProfileView: View {
    @ObservedObject var presenter = CreateProfilePresenter()
    
    // MARK: - Body
    var body: some View {
        NavigationView {
            BaseView(navigationTitle: "Create Your Profile", content: { ContentView })
                .onAppear {
                    //                    isFocused = true
                }
        }
        .navigationBarBackButtonHidden(true)
        .environment(\.colorScheme, .light)
        .onChange(of: presenter.fullname) { newValue in
            print(newValue.value)
        }
    }
    
    var ContentView: some View {
        VStack(spacing: 24.0) {
            AppInputField(fieldData: $presenter.fullname)
            AppInputField(fieldData: $presenter.nickname)
            AppInputField(fieldData: $presenter.dateBirthday)
            AppInputField(fieldData: $presenter.phone)
            AppInputField(fieldData: $presenter.gender)
            Spacer()
        }
        .padding(defaultEdgeInsets)
    }
}

struct CreateProfileView_Previews: PreviewProvider {
    static var previews: some View {
        CreateProfileView()
    }
}
