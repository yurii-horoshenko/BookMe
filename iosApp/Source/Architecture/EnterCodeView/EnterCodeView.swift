//
//  EnterCodeView.swift
//  BookMeNow-Develop
//
//  Created by Yurii Goroshenko on 04.08.2023.
//

import SwiftUI

protocol EnterCodeViewProtocol {
    func moveToDashboard(view: some View)
}

struct EnterCodeView<ViewModel>: View where ViewModel: EnterCodeViewModelProtocol {
    // MARK: - Properties
    @State var viewModel: ViewModel
    private let timer = Timer.publish(every: 0.01, on: .main, in: .common).autoconnect()
    
    // MARK: - Lifecycle
    var body: some View {
        NavigationView {
            ContentView
                .showNavigationBar(title: String(localized: "ENTERCODE-TITLE"))
        }
        .environment(\.colorScheme, .light)
        .onAppear {
            viewModel.sendCode(resend: false)
        }
    }
    
    // Title, input fields code, timer label
    var ContentView: some View {
        VStack(spacing: 60.0) {
            Text(String(localized: "ENTERCODE-DESCRIPTION") + viewModel.phone.phoneMask)
                .font(Font.BodyXLargeMedium)
                .foregroundColor(Color.greyscale900)
            
            VerificationCodeView(
                array: $viewModel.code,
                currentState: viewModel.code.first ?? FieldData()
            )
            .onChange(of: viewModel.code) {
                viewModel.checkCode()
            }
            
            TimerLabel
                .isHidden(!viewModel.isTimerRunning)
        }
        .padding(defaultEdgeInsets)
    }
    
    // Label with timer
    var TimerLabel: some View {
        HStack(spacing: 4.0) {
            Text(String(localized: "ENTERCODE-TIMER"))
                .font(Font.BodyXLargeMedium)
                .foregroundColor(Color.greyscale900)
            
            Text(viewModel.timerString)
                .font(Font.BodyXLargeBold)
                .foregroundColor(Color.primary500)
                .onReceive(timer) { _ in
                    viewModel.onReceveTimer()
                }
            
            Text(" s")
                .font(Font.BodyXLargeMedium)
                .foregroundColor(Color.greyscale900)
        }
    }
}

// MARK: - EnterCodeViewProtocol
extension EnterCodeView: EnterCodeViewProtocol {
    func moveToDashboard(view: some View) {
        setRootView(view)
    }
}

#Preview {
    AuthPageBuilder.constructEnterCodeView(
        phone: "+380991112233", newProfile: true
    )
}
