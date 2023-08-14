//
//  CreateProfileView.swift
//  BookMeNow-Develop
//
//  Created by Yurii Goroshenko on 03.08.2023.
//

import SwiftUI

struct CreateProfileView: View {
    @ObservedObject var presenter = CreateProfilePresenter()
    @State private var pushToOTPFlow = false
    @State private var showingOptions = false
    
    // MARK: - Body
    var body: some View {
        NavigationView {
            BaseView(navigationTitle: "Create Your Profile", content: { ContentView })
        }
        .navigationBarBackButtonHidden(true)
        .environment(\.colorScheme, .light)
    }
    
    var ContentView: some View {
        VStack(spacing: 24.0) {
            AppInputField(fieldData: $presenter.fullname)
                .padding(.top, 48.0)
            
            AppInputField(fieldData: $presenter.nickname)
            
            AppInputField(fieldData: $presenter.dateBirthday, trailingView: CalendarImage.eraseToAnyView()) {
                
            }
            
            AppPhoneNumber(fieldData: $presenter.phone)
            
            AppInputField(fieldData: $presenter.gender, trailingView: ArrorDownImage.eraseToAnyView()) {
                showingOptions = true
            }
            .confirmationDialog("Select your gender", isPresented: $showingOptions, titleVisibility: .visible) {
                Button("Male") {
                    presenter.gender.value = "Male"
                    presenter.gender.state = .active
                }
                
                Button("Female") {
                    presenter.gender.value = "Female"
                    presenter.gender.state = .active

                }
                
                Button("Other") {
                    presenter.gender.value = "Other"
                    presenter.gender.state = .active
                }
            }
            
            Spacer()
            
            BottomButton
        }
        .padding(defaultEdgeInsets)
    }
    
    var ArrorDownImage: some View {
        Image("ic-arrow-down")
            .resizable()
            .renderingMode(.template)
            .foregroundColor(presenter.gender.state == .active ? Color.greyscale900 : Color.greyscale500)
            .frame(width: 20, height: 20)
    }
    
    var CalendarImage: some View {
        Image("ic-calendar")
            .resizable()
            .renderingMode(.template)
            .foregroundColor(presenter.dateBirthday.state == .active ? Color.greyscale900 : Color.greyscale500)
            .frame(width: 20, height: 20)
    }
    
    var BottomButton: some View {
        NavigationLink(destination: EnterCodeView(phone: presenter.phone.value.phoneMask), isActive: $pushToOTPFlow) {
            AppButton(
                state: .constant(.active),
                title: "Continue",
                titleColor: Color.white,
                backgroundColor: Color.primary500,
                action: { self.pushToOTPFlow = true }
            )
        }
    }
}

struct CreateProfileView_Previews: PreviewProvider {
    static var previews: some View {
        CreateProfileView()
    }
}
