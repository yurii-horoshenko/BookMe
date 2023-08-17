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
        NavigationStack {
            BaseView(navigationTitle: CREATE_PROFILE.pageTitle.text, content: { ContentView })
        }
        .navigationBarBackButtonHidden(true)
        .environment(\.colorScheme, .light)
    }
    
    // Profile input fields, button
    var ContentView: some View {
        VStack(spacing: 24.0) {
            AppInputField(fieldData: $presenter.fullname)
                .padding(.top, 24.0)
            
            BirthDayView
            
            AppPhoneNumber(fieldData: $presenter.phone)
            
            AppInputField(fieldData: $presenter.gender, trailingView: Icons.ArrowDown.eraseToAnyView()) {
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
    
    var BirthDayView: some View {
        AppInputField(fieldData: $presenter.dateBirthday, trailingView: Icons.Calendar.eraseToAnyView()) {
            presenter.openCalendar()
        }
        .sheet(isPresented: $presenter.toCalendar) {
            DatePicker("", selection: $presenter.birthday, displayedComponents: .date)
                .datePickerStyle(GraphicalDatePickerStyle())
                .frame(maxHeight: 300)
                .accentColor(Color.primary500)
                .padding(.horizontal, 16.0)
                .presentationDetents([.height(360)])
        }
        .onChange(of: presenter.birthday) { newValue in
            presenter.dateBirthday.value = newValue.toString
        }
    }
    
    // Button Continue
    var BottomButton: some View {
        AppButton(
            state: .constant(.active),
            title: GENERAL.continue_.text,
            titleColor: Color.white,
            backgroundColor: Color.primary500,
            action: { presenter.codeVerification() }
        )
        .navigationDestination(isPresented: $presenter.toCodeVerification) {
            EnterCodeView(phone: presenter.phone.value.phoneMask)
        }
    }
}

struct CreateProfileView_Previews: PreviewProvider {
    static var previews: some View {
        CreateProfileView()
    }
}
