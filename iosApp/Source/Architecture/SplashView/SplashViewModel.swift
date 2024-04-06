//
//  SplashViewModel.swift
//  iosApp
//
//  Created by Yurii Goroshenko on 06.04.2024.
//

import shared

protocol SplashViewModelProtocol: ObservableObject {
    var toLogin: Bool { get set }
    var toSignIn: Bool { get set }
    
    func detectPage()
}

final class SplashViewModel: SplashViewModelProtocol {
    // MARK: - Properties
    private let repository: UserRepositoryProtocol = shared.UserRepository(remote: UserRemoteDataSource(client: KtorManager.shared.client, token: ""))
    @Published var toLogin = false
    @Published var toSignIn = false
    
    // MARK: - Lifecycle
    deinit {
        printLog("deinit -> ", self)
    }
    
    // MARK: - Public
    func detectPage() {
        repository.login { result, error in
//            result?.onSuccess(result: { <#ProfileModel#> in
//                
//            }).onError(action: { <#ResultWrapperError#> in
//                <#code#>
//            })

//            switch result {
//            case .success(let profile):
//                printLog("How")
//                
//            case .failer(let error):
//                printLog("How")
//            }
            
            
            
            
//            switch result {
//            case is ResponseSuccess<ProfileModel>:
//                let object = (result as? ResponseSuccess<ProfileModel>)?.value
//                printLog("How")
//                
//            case is ResponseError:
//                printLog("How")
//                
//            default:
//                break
//            }
        }
    }
}

typealias SuccessClosure<T> = (T) -> Void

//extension ResultWrapper<T> {
//    @objc func onSuccess(result: (T) -> Void) -> Self {
//        guard let object = (self as? ResultWrapperSuccess<AnyObject>)?.value else { return  self}
////        result(object)
//    }
    
//    func onError(result: (ResultWrapperError) -> Void) -> ResultWrapper<ProfileModel> {
//        guard self is ResultWrapperError else { return self }
//        guard let object = (self as? ResultWrapperError) else { return  self}
//        result(object)
//    }
//}


//extension ResultWrapper<ProfileModel> {
//    func onSuccess(result: (ProfileModel) -> Void) -> ResultWrapper<ProfileModel> {
//        guard self is ResultWrapperSuccess<ProfileModel> else { return self }
//        guard let object = (self as? ResultWrapperSuccess<ProfileModel>)?.value else { return  self}
//        result(object)
//    }
//    
//    func onError(result: (ResultWrapperError) -> Void) -> ResultWrapper<ProfileModel> {
//        guard self is ResultWrapperError else { return self }
//        guard let object = (self as? ResultWrapperError) else { return  self}
//        result(object)
//    }
//}
//}
