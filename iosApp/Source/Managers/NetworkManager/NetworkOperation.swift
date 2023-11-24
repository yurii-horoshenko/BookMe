//
//  NetworkOperation.swift
//  Created by Yurii Goroshenko on 29.03.2023.
//

import Foundation

typealias OperationCompletionHandler<T> = (Result<T, HTTPStatus>) -> Void

final class NetworkOperation: Operation {
    enum OperationType {
        case new
        case isCancelled
    }
    
    private enum NetworkOperationLoggerConfigurator {
        static let cURL = false
        static let request = false
        static let response = true
        static let headers = false
        static let parameters = true
        static let body = true
    }

    // MARK: - Properties
    private let completion: OperationCompletionHandler<(Data, URLResponse)>
    private var startTime: CFAbsoluteTime = 0.0
    let creationTime: TimeInterval
    let urlRequest: URLRequest
    var urlResponse: URLResponse?
    var type: OperationType = .new
    weak var delegate: URLSessionDelegate?
    
    // MARK: - Lifecycle
    init(urlRequest: URLRequest,
         creationTime: TimeInterval,
         delegate: URLSessionDelegate,
         completion: @escaping OperationCompletionHandler<(Data, URLResponse)>) {
        self.urlRequest = urlRequest
        self.completion = completion
        self.delegate = delegate
        self.creationTime = creationTime
    }
    
    override func main() {
        startLog()
        
        let session = URLSession(configuration: URLSessionConfiguration.default, delegate: delegate, delegateQueue: .main)
        let task = session.dataTask(with: urlRequest, completionHandler: { [weak self] data, response, error in
            guard let self, let data, let response, let httpResponse = response as? HTTPURLResponse else { return }
            let code = HTTPStatus.StatusCode(rawValue: httpResponse.statusCode)
            let status = HTTPStatus(code: code, error: error)

            self.urlResponse = response
            self.endLog(data: data, with: status)
            
            // Operation was cancel
            if self.isCancelled || self.type == .isCancelled {
                self.completion(.failure(HTTPStatus(code: .cancelOperation)))
                return
            }
            
            guard status.code == .success else {
                // Operation consists json erros
                let decoder = JSONDecoder()
                decoder.keyDecodingStrategy = .convertFromSnakeCase
                let errors = try? decoder.decode(JSONErrors.self, from: data)
                self.completion(.failure(HTTPStatus(code: .jsonErrors, jsonErrors: errors)))
                return
            }
            
            // Operation success
            self.completion(.success((data, response)))
        })
        
        task.resume()
    }
    
    func compare(with operation: NetworkOperation) -> Bool {
        urlRequest == operation.urlRequest &&
        urlRequest.httpMethod == operation.urlRequest.httpMethod &&
        urlRequest.httpBody == operation.urlRequest.httpBody &&
        urlRequest.allHTTPHeaderFields == operation.urlRequest.allHTTPHeaderFields
    }
}

// MARK: - Logger
extension NetworkOperation {
    func startLog() {
        startTime = CFAbsoluteTimeGetCurrent()
        
        // REQUEST cURL
        if NetworkOperationLoggerConfigurator.cURL {
            debugPrint(urlRequest.curlString as AnyObject)
        }
        
        // REQUEST NAME
        if NetworkOperationLoggerConfigurator.request {
            let title = urlRequest.url?.absoluteString ?? ""
            debugPrint("🚀🚀🚀 \(String(describing: urlRequest.httpMethod)) \(title) 🚀🚀🚀")
        }
        
        // REQUEST HEADERS
        if NetworkOperationLoggerConfigurator.headers, let headers = urlRequest.allHTTPHeaderFields {
            debugPrint("🏷️🏷️🏷️ REQUEST HEADERS 🏷️🏷️🏷️")
            debugPrint(headers as AnyObject)
        }
        
        // REQUEST PARAMETERS
        if NetworkOperationLoggerConfigurator.parameters, let httpBody = urlRequest.httpBody {
            let params = try? JSONSerialization.jsonObject(with: httpBody, options: .allowFragments)
            debugPrint("✉️✉️✉️ REQUEST PARAMETERS ✉️✉️✉️")
            debugPrint(params as AnyObject)
        }
    }
    
    func endLog(data: Data?, with status: HTTPStatus) {
        let diff = CFAbsoluteTimeGetCurrent() - startTime
        let time = String(format: "%0.2f sec.", diff)
        let httpMethod = urlRequest.httpMethod ?? ""
        let apiName = urlRequest.url?.absoluteString ?? ""

        // RESPONSE NAME
        if NetworkOperationLoggerConfigurator.response {
            if status.code == .success {
                debugPrint("✅✅✅ \(httpMethod) \(apiName) ✅✅✅ SUCCESS \(status.code.rawValue) ⏱️\(time)⏱️")
            } else {
                debugPrint("❌❌❌ \(httpMethod) \(apiName) ❌❌❌ ERROR \(status.code.rawValue) ⏱️\(time)⏱️")
            }
        }
        
        // RESPONSE BODY
        if NetworkOperationLoggerConfigurator.body, let data {
            let body = try? JSONSerialization.jsonObject(with: data, options: .allowFragments)
            debugPrint("📤📤📤 RESPONSE BODY 📤📤📤")
            debugPrint(body as AnyObject)
        }
        
        // RESPONSE JSON ERRORS
        if let errors = status.jsonErrors {
            debugPrint("📝📝📝 \(errors) 📝📝")
        }
    }
}
