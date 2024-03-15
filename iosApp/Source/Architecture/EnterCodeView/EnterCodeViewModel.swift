//
//  EnterCodeViewModel.swift
//  iosApp
//
//  Created by Yurii Goroshenko on 19.01.2024.
//

import shared
import SwiftUI

protocol EnterCodeViewModelProtocol: ObservableObject {
    var isTimerRunning: Bool { get set }
    var startTime: Date { get set }
    var timerString: String { get set }
    var code: [FieldData] { get set }
    var phone: String { get set }
    var view: EnterCodeViewProtocol? { get set }
    
    func startTimer()
    func onReceveTimer()
    func checkCode()
}

final class EnterCodeViewModel: EnterCodeViewModelProtocol {
    // MARK: - Properties
    private let repository = shared.UserRepository()
    @Published var isTimerRunning = false
    @Published var startTime = Date()
    @Published var timerString = "0.00"
    @Published var code = [FieldData(), FieldData(), FieldData(), FieldData()]
    var phone: String
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
