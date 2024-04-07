//
//  LoginViewModel.swift
//  iosApp
//
//  Created by Yurii Goroshenko on 19.01.2024.
//

import shared

protocol LoginViewModelProtocol: ObservableObject {
    var phone: FieldData { get set }
    var toCode: Bool { get set }
    
    func codeVerification()
}

final class LoginViewModel: LoginViewModelProtocol {
    // MARK: - Properties
//    private let repository = shared.UserRepositoryImpl(remote: UserRemoteDataSource(client: KtorManager.shared.client))
    @Published var phone = FieldData(placeholder: "Phone Number")
    @Published var toCode = false
    
    // MARK: - Lifecycle
    deinit {
        printLog("deinit -> ", self)
    }

    // MARK: - Public
    func codeVerification() {
        toCode = true
    }
}
