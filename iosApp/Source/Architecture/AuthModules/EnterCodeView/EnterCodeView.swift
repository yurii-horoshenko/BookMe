//
//  EnterCodeView.swift
//  BookMeNow-Develop
//
//  Created by Yurii Goroshenko on 04.08.2023.
//

import shared
import SwiftUI

struct EnterCodeView: View {
    @ObservedObject var presenter = EnterCodePresenter()
    let phone: String
    
    // MARK: - BODY
    var body: some View {
        NavigationView {
            BaseView(navigationTitle: ENTER_CODE.pageTitle.text, content: { ContentView })
        }
        .navigationBarBackButtonHidden(true)
        .environment(\.colorScheme, .light)
        .onAppear {
            presenter.startTimer()
        }
    }
    
    // Title, input fields code, timer label
    var ContentView: some View {
        VStack(spacing: 60.0) {
            Text(ENTER_CODE.info.text + phone)
                .font(Font.BodyXLargeMedium)
                .foregroundColor(Color.greyscale900)
            
            VerificationCodeView(array: $presenter.code, currentState: presenter.code.first ?? FieldData())
                .padding(.horizontal, 24.0)
            
            TimerLabel
                .isHidden(!presenter.isTimerRunning)
        }
    }
    
    // Label with timer
    var TimerLabel: some View {
        HStack(spacing: 4.0) {
            Text(ENTER_CODE.timer.text)
                .font(Font.BodyXLargeMedium)
                .foregroundColor(Color.greyscale900)
            
            Text(presenter.timerString)
                .font(Font.BodyXLargeBold)
                .foregroundColor(Color.primary500)
                .onReceive(presenter.timer) { _ in
                    presenter.onReceveTimer()
                }
            
            Text(" s")
                .font(Font.BodyXLargeMedium)
                .foregroundColor(Color.greyscale900)
        }
    }
}

struct EnterCodeView_Previews: PreviewProvider {
    static var previews: some View {
        EnterCodeView(phone: "+380 99 408 10 85".phoneMask)
    }
}
