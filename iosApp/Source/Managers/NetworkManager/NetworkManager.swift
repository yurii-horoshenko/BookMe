//
//  NetworkManager.swift
//  Created by Yurii Goroshenko on 29.03.2023.
//

import Foundation

protocol NetworkManagerProtocol {
    func request<T>(_ request: URLRequest?, modelType: T.Type, completionHandler: @escaping OperationCompletionHandler<T?>) where T: Decodable
    func cancelAllOperations()
}

final class NetworkManager: NSObject, NetworkManagerProtocol {
    static let shared = NetworkManager()
        
    private enum Environment {
        static let develop = "https://goroshenko.azurewebsites.net"
        static let stage = "https://goroshenko.azurewebsites.net"
        static let production = "https://goroshenko.azurewebsites.net"
    }
    
    // MARK: - Variables
    static var baseURL: String = Environment.develop
    private lazy var operationQueue = OperationQueue()
    lazy var operations: [NetworkOperation] = []
    
    // MARK: - Public functions
    func request<T>(_ request: URLRequest?, modelType: T.Type, completionHandler: @escaping OperationCompletionHandler<T?>) where T: Decodable {
        guard let urlRequest = request else { return }
        let timestamp = Date().timeIntervalSince1970
        
        let operation = NetworkOperation(urlRequest: urlRequest, creationTime: timestamp, delegate: self, completion: { [weak self, timestamp] result in
            guard let self else { return }
            
            switch result {
            case .success(let data):
                let decoder = JSONDecoder()
                decoder.keyDecodingStrategy = .convertFromSnakeCase
                
                if let json = try? decoder.decode(modelType, from: data.0) {
                    completionHandler(.success(json))
                } else {
                    completionHandler(.failure(HTTPStatus(code: ._none)))
                }
                
            case .failure(let error):
                completionHandler(.failure(error))
            }
            
            self.clearOperation(by: timestamp)
        })
        
        // Add to Queue and save to array for response callback
        if operationQueue.operations.contains(where: { ($0 as? NetworkOperation)?.compare(with: operation) ?? false }) {
            debugPrint("✏️✏️✏️ Operation still in progress ✏️✏️✏️")
        } else {
            operationQueue.addOperation(operation)
        }
        
        operations.append(operation)
    }
    
    func cancelAllOperations() {
        operations.forEach({ $0.cancel() })
        operations.forEach({ $0.type = .isCancelled })
    }
    
    func clearOperations() {
        operations = operations.filter({ $0.isFinished == false })
        operations.forEach { debugPrint("Will remove -> %@", $0.urlRequest) }
    }
    
    func clearOperation(by timestamp: TimeInterval) {
        operations = operations.filter({ $0.creationTime != timestamp })
        operations.forEach { debugPrint("Will remove -> %@", $0.urlRequest) }
    }
}

// MARK: - URLSessionDelegate
extension NetworkManager: URLSessionDelegate {
    func urlSession(_ session: URLSession,
                    didReceive challenge: URLAuthenticationChallenge,
                    completionHandler: @escaping (URLSession.AuthChallengeDisposition, URLCredential?) -> Void) {
        completionHandler(.performDefaultHandling, nil)
    }
}
