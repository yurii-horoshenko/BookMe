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
    
    func sendCode(resend: Bool)
    func onReceveTimer()
    func checkCode()
}

final class EnterCodeViewModel: EnterCodeViewModelProtocol {
    // MARK: - Properties
    private let repository: ProfileRepositoryProtocol = ProfileRepository()
    @Published var isTimerRunning = false
    @Published var startTime = Date()
    @Published var timerString = "0.00"
    @Published var code = [FieldData(), FieldData(), FieldData(), FieldData()]
    var phone: String
    var newProfile: Bool
    var view: EnterCodeViewProtocol?
    
    // MARK: - Lifecycle
    deinit {
        printLog("deinit -> ", self)
    }
    
    init(phone: String, newProfile: Bool) {
        self.phone = phone
        self.newProfile = newProfile
    }
    
    // MARK: - Public
    func sendCode(resend: Bool = false) {
        let formattedPhone = phone.filter { !$0.isWhitespace }
        repository.code(phone: formattedPhone, resend: resend) { result, _ in
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
    
    func checkCode() {
        let resultCode = code.compactMap({ $0.value }).joined()
        guard resultCode.count == 4 else { return }
       
        let formattedPhone = phone.filter { !$0.isWhitespace }
        let request = CodeRequest(phone: formattedPhone, code: resultCode)
        
        repository.code(code: request, completionHandler: { result, _ in
            DispatchQueue.main.async { [weak self] in
                result?
                    .onSuccess(result: { object in
                        guard let result = object as? ProfileTokenModel else { return }
                        LocalManager.shared.kmmDefaults.isLoggedIn = true
                        let nextView = AuthPageBuilder.constructDashboardView()
                        self?.view?.moveToDashboard(view: nextView)
                    })?
                    .onError(result: { _ in
                        // Error
                    })
            }
        })
    }
}
