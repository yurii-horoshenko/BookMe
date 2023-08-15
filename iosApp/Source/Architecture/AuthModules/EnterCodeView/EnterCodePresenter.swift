//
//  EnterCodePresenter.swift
//  BookMeNow-Develop
//
//  Created by Yurii Goroshenko on 15.08.2023.
//

import SwiftUI

final class EnterCodePresenter: ObservableObject {
    let timer = Timer.publish(every: 0.01, on: .main, in: .common).autoconnect()
    @Published var isTimerRunning = false
    @Published var startTime = Date()
    @Published var timerString = "0.00"
    @Published var code = [FieldData(), FieldData(), FieldData(), FieldData()]
    
    // MARK: - Lifecycle
    deinit {
        printLog("deinit -> ", self)
    }
    
    // MARK: - Public
    func startTimer() {
        startTime = Date().addingTimeInterval(60)
        isTimerRunning.toggle()
        timerString = "60"
    }
    
    func onReceveTimer() {
        if isTimerRunning {
            let value = Date().timeIntervalSince(startTime) / -1
            if value <= 0 {
                isTimerRunning.toggle()
                return
            }
            timerString = String(format: "%2.0f", value)
        }
    }
}
