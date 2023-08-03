//
//  PhoneView.swift
//  BookMeNow-Develop
//
//  Created by Yurii Goroshenko on 23.07.2023.
//

import shared
import SwiftUI

struct PhoneView: View {
    @ObservedObject var presenter = PhonePresenter()
    @FocusState var isFocused: Bool
    @State var pushToPhoneFlow = false
    @State var phone = ""
    @State var isEditing = false
    
    // MARK: - BODY
    var body: some View {
        NavigationView {
//            PHONE.shared.PAGE_TITLE
            BaseView(navigationTitle: "", content: { ContentView })
                .onAppear {
                    isFocused = true
                }
        }
        .navigationBarBackButtonHidden(true)
        .environment(\.colorScheme, .light)
    }
    
    var ContentView: some View {
        VStack {
            Spacer(minLength: 40.0)
            
            AppPhoneNumber(
                phone: phone,
                placeholder: "", // PHONE.shared.PHONE_PLACEHOLDER,
                foregroundColor: Color.brandDarkColor
            )
            
            Spacer()
            
//            Text(PHONE.shared.PAGE_DESCRIPTION)
//                .font(Font.brandFont(ofSize: 16, type: .regular))
//                .foregroundColor(Color.gray)
//                .multilineTextAlignment(.leading)
//            
//            Spacer()
//            
//            AppButton(
//                state: .constant(.active),
//                title: PHONE.shared.BUTTON_NEXT_TITLE,
//                titleColor: Color.white,
//                backgroundColor: Color.brandButtonsColor,
//                action: {}
//            )
        }
        .padding(EdgeInsets(top: 0.0, leading: 24.0, bottom: 16.0, trailing: 24.0))
    }
}

struct PhoneView_Previews: PreviewProvider {
    static var previews: some View {
        PhoneView()
    }
}
