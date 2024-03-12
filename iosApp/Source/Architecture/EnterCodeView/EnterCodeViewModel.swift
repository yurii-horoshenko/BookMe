//
//  EnterCodeViewModel.swift
//  iosApp
//
//  Created by Yurii Goroshenko on 19.01.2024.
//

import shared
import SwiftUI

final class EnterCodeViewModel: ObservableObject {
    // MARK: - Properties
    private let repository = shared.UserRepository()
    @Published var isTimerRunning = false
    @Published var startTime = Date()
    @Published var timerString = "0.00"
    @Published var code = [FieldData(), FieldData(), FieldData(), FieldData()]
    let timer = Timer.publish(every: 0.01, on: .main, in: .common).autoconnect()
    let phone: String
    var view: EnterCodeViewProtocol?
    
    // MARK: - Lifecycle
    deinit {
        printLog("deinit -> ", self)
    }
    
    init(phone: String) {
        self.phone = phone
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
    
    func checkCode() {
        UserDefaultsManager.isLoggined = true
        view?.moveToDashboardPage()
    }
}
