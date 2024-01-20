//
//  EnterCodeView.swift
//  BookMeNow-Develop
//
//  Created by Yurii Goroshenko on 04.08.2023.
//

import shared
import SwiftUI

protocol EnterCodeViewProtocol {
    func moveToDashboardPage()
}

struct EnterCodeView: View {
    // MARK: - Properties
    @StateObject var viewModel: EnterCodeViewModel
    
    // MARK: - Lifecycle
    var body: some View {
        NavigationView {
            BaseView(navigationTitle: ENTER_CODE.pageTitle.text, content: { ContentView })
        }
        .navigationBarBackButtonHidden(true)
        .environment(\.colorScheme, .light)
        .onAppear {
            viewModel.startTimer()
        }
    }
    
    // Title, input fields code, timer label
    var ContentView: some View {
        VStack(spacing: 60.0) {
            Text(ENTER_CODE.info.text + viewModel.phone)
                .font(Font.BodyXLargeMedium)
                .foregroundColor(Color.greyscale900)
            
            VerificationCodeView(array: $viewModel.code, currentState: viewModel.code.first ?? FieldData())
                .padding(.horizontal, 24.0)
                .onChange(of: viewModel.code) { newValue in
                    let code = newValue.compactMap({ $0.value }).joined()
                    guard code.count == 4 else { return }
                    viewModel.checkCode()
                }
            
            TimerLabel
                .isHidden(!viewModel.isTimerRunning)
        }
    }
    
    // Label with timer
    var TimerLabel: some View {
        HStack(spacing: 4.0) {
            Text(ENTER_CODE.timer.text)
                .font(Font.BodyXLargeMedium)
                .foregroundColor(Color.greyscale900)
            
            Text(viewModel.timerString)
                .font(Font.BodyXLargeBold)
                .foregroundColor(Color.primary500)
                .onReceive(viewModel.timer) { _ in
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
    func moveToDashboardPage() {
        let view = DashboardContainerView()
        setRootView(view)
    }
}

#Preview {
    AuthPageBuilder.constructEnterCodeView(
        phoneMask: "+380 99 111 22 33".phoneMask
    )
}
