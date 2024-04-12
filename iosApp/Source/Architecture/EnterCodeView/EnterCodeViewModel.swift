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
    
    func sendCode(resend: Bool)
    func onReceveTimer()
    func checkCode(sender: EnterCodeViewProtocol)
}

final class EnterCodeViewModel: EnterCodeViewModelProtocol {
    // MARK: - Properties
    private let repository: ProfileRepositoryProtocol = ServiceLocator.shared.profileRepository
    @Published var isTimerRunning = false
    @Published var startTime = Date()
    @Published var timerString = "0.00"
    @Published var code = [FieldData(), FieldData(), FieldData(), FieldData()]
    var phone: String
    
    // MARK: - Lifecycle
    deinit {
        printLog("deinit -> ", self)
    }
    
    init(phone: String) {
        self.phone = phone
    }
    
    // MARK: - Public
    func sendCode(resend: Bool = false) {
        repository.code(phone: phone, resend: resend) { result, error in
            DispatchQueue.main.async { [weak self] in
                result?
                    .onSuccess(result: { object in
                        guard let success = object as? Bool else { return }
                        
                        if success {
                            self?.startTimer()
                        } else {
                            // Error
                        }
                    })?
                    .onError(result: { _ in
                        // Error
                    })
            }
        }
    }
    
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
    
    func checkCode(sender: EnterCodeViewProtocol) {
        let resultCode = code.compactMap({ $0.value }).joined()
        guard resultCode.count == 4 else { return }
        
        let request = CodeRequest(phone: phone, code: resultCode)
        repository.code(code: request, completionHandler: { result, error in
            DispatchQueue.main.async {
                result?
                    .onSuccess(result: { object in
                        guard let result = object as? ProfileTokenModel else { return }
                        
                        LocalManager.shared.kmmDefaults.isLoggedIn = true
                        let view = AuthPageBuilder.constructDashboardView()
                        sender.moveToDashboard(view: view)
                    })?
                    .onError(result: { _ in
                        // Error
                    })
            }
        })
    }
}
