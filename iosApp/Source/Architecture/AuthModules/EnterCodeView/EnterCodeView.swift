//
//  EnterCodeView.swift
//  BookMeNow-Develop
//
//  Created by Yurii Goroshenko on 04.08.2023.
//

import SwiftUI

struct CodeData {
    var code = [FieldData(), FieldData(), FieldData(), FieldData()]
    var fullCode = ""
}

struct EnterCodeView: View {
    private let timer = Timer.publish(every: 0.01, on: .main, in: .common).autoconnect()
    @State var isTimerRunning = false
    @State private var startTime = Date()
    @State private var timerString = "0.00"
    @State var code = [FieldData(), FieldData(), FieldData(), FieldData()]
    let phone: String
    
    // MARK: - BODY
    var body: some View {
        NavigationView {
            BaseView(navigationTitle: "Enter code", content: { ContentView })
        }
        .navigationBarBackButtonHidden(true)
        .environment(\.colorScheme, .light)
        .onAppear {
            startTimer()
        }
    }
    
    var ContentView: some View {
        VStack(spacing: 60.0) {
            Text(String(format: "Code has been send to %@", phone))
                .font(Font.BodyXLargeMedium)
                .foregroundColor(Color.greyscale900)
            
            VerificationCodeView(array: $code, currentState: code.first ?? FieldData())
                .padding(.horizontal, 24.0)
            
            HStack(spacing: 4.0) {
                Text("Resend code in ")
                    .font(Font.BodyXLargeMedium)
                    .foregroundColor(Color.greyscale900)
                
                Text(timerString)
                    .font(Font.BodyXLargeBold)
                    .foregroundColor(Color.primary500)
                    .onReceive(timer) { _ in
                        if isTimerRunning {
                            let value = Date().timeIntervalSince(startTime) / -1
                            if value <= 0 {
                                isTimerRunning.toggle()
                                return
                            }
                            timerString = String(format: "%2.0f", value)
                        }
                    }
                
                Text(" s")
                    .font(Font.BodyXLargeMedium)
                    .foregroundColor(Color.greyscale900)
            }
            .isHidden(!isTimerRunning)
        }
    }
    
    func startTimer() {
        startTime = Date().addingTimeInterval(60)
        isTimerRunning.toggle()
        timerString = "60"
    }
}

struct EnterCodeView_Previews: PreviewProvider {
    static var previews: some View {
        EnterCodeView(phone: "")
    }
}
