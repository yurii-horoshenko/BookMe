//
//  CreateProfileView.swift
//  BookMeNow-Develop
//
//  Created by Yurii Goroshenko on 03.08.2023.
//

import shared
import SwiftUI

struct CreateProfileView: View {
    @ObservedObject var presenter = CreateProfilePresenter()
    
    // MARK: - Body
    var body: some View {
        NavigationView {
            BaseView(navigationTitle: CREATE_PROFILE.pageTitle.text, content: { ContentView })
        }
        .navigationBarBackButtonHidden(true)
        .environment(\.colorScheme, .light)
    }
    
    // Profile input fields, button
    var ContentView: some View {
        ScrollView {
            VStack(spacing: 24.0) {
                AppInputField(fieldData: $presenter.fullname)
                    .padding(.top, 48.0)
                
                AppInputField(fieldData: $presenter.nickname)
                
                AppInputField(fieldData: $presenter.dateBirthday, trailingView: CalendarImage.eraseToAnyView()) {
                    
                }
                
                AppPhoneNumber(fieldData: $presenter.phone)
                
                AppInputField(fieldData: $presenter.gender, trailingView: ArrowDownImage.eraseToAnyView()) {
                    presenter.genderSelection()
                }
                .confirmationDialog(CREATE_PROFILE.genderTitle.text, isPresented: $presenter.toGenderSelection, titleVisibility: .visible) {
                    Button(GENDER.male.text) {
                        presenter.gender.value = GENDER.male.text
                        presenter.gender.state = .active
                    }
                    
                    Button(GENDER.female.text) {
                        presenter.gender.value = GENDER.female.text
                        presenter.gender.state = .active
                        
                    }
                    
                    Button(GENDER.other.text) {
                        presenter.gender.value = GENDER.other.text
                        presenter.gender.state = .active
                    }
                }
                
                Spacer()
                
                BottomButton
            }
            .padding(defaultEdgeInsets)
        }
    }
    
    // Image Arrow down
    var ArrowDownImage: some View {
        Image(ICON.arrowDown.value)
            .resizable()
            .renderingMode(.template)
            .foregroundColor(presenter.gender.state == .active ? Color.greyscale900 : Color.greyscale500)
            .frame(width: 20, height: 20)
    }
    
    // Image Calendar
    var CalendarImage: some View {
        Image(ICON.calendar.value)
            .resizable()
            .renderingMode(.template)
            .foregroundColor(presenter.dateBirthday.state == .active ? Color.greyscale900 : Color.greyscale500)
            .frame(width: 20, height: 20)
    }
    
    // Button Continue
    var BottomButton: some View {
        NavigationLink(destination: EnterCodeView(phone: presenter.phone.value.phoneMask), isActive: $presenter.toCodeVerification) {
            AppButton(
                state: .constant(.active),
                title: GENERAL.continue_.text,
                titleColor: Color.white,
                backgroundColor: Color.primary500,
                action: {
                    presenter.codeVerification()
                }
            )
        }
    }
}

struct CreateProfileView_Previews: PreviewProvider {
    static var previews: some View {
        CreateProfileView()
    }
}
