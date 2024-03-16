//
//  NetworkOperationData.swift
//  BookMeNow-Develop
//
//  Created by Yurii Goroshenko on 29.03.2023.
//

import UIKit

extension NetworkOperation {
    private enum Constants {
        static let urlType = "application/json"
        static let httpHeader = "Content-Type"
    }
    
    // Hearders
    static var defaultHeaders: [String: String] {
        let appVersion = Bundle.main.infoDictionary?["CFBundleShortVersionString"] as? String ?? ""
        + "(\(Bundle.main.infoDictionary?["CFBundleVersion"] as? String ?? ""))"
        
        let headers = [
            "Platform": "iOS",
            "Accept-Language": "en",
            "Version-App": appVersion,
            "Version-Device-SDK": UIDevice.current.systemVersion,
            "Device-UID": UIDevice.current.identifierForVendor?.uuidString ?? "-1",
            "Content-Type": "application/json"
        ]
        
        return headers
    }
    
    // Request Model
    static func requestModel(endpoint: String,
                             httpMethod: String,
                             httpBody: Data? = nil,
                             headers: [String: String] = NetworkOperation.defaultHeaders) -> URLRequest? {
        
        guard let url = URL(string: endpoint) else {
            debugPrint("❌❌❌ %@ ❌❌❌ ERROR Incorrect URL", endpoint)
            return nil
        }
        
        var urlRequest = URLRequest(url: url)
        urlRequest.httpMethod = httpMethod
        urlRequest.httpBody = httpBody
        urlRequest.addValue(Constants.urlType, forHTTPHeaderField: Constants.httpHeader)
        
        for (key, value) in headers {
            urlRequest.setValue(value, forHTTPHeaderField: key)
        }
        
        return urlRequest
    }
}

// MARK: - HTTPStatus
struct HTTPStatus: Error {
    let code: StatusCode
    var error: Error?
    var jsonErrors: JSONErrors?
    
    enum StatusCode: Int {
        case jsonErrors = 100
        case cancelOperation = 199
        case success = 200
        case badRequest = 400
        case unAuthorized = 401
        case notFound = 404
        case invalidToken = 498
        case internalServerError = 500
        case serviceUnavailable = 503
        case _none = 666
        
        var description: String {
            switch self {
            case ._none:
                return "Unknown error"
            default:
                return ""
            }
        }
        
        init(rawValue: Int) {
            switch rawValue {
            case 200..<300:
                self = .success
            case 400:
                self = .badRequest
            case 401:
                self = .unAuthorized
            case 404:
                self = .notFound
            case 498:
                self = .invalidToken
            case 500:
                self = .internalServerError
            case 503:
                self = .serviceUnavailable
            default:
                self = ._none
            }
        }
    }
}

// Parsed JSON Errors
struct JSONErrors: Decodable {
    var errors: [JSONError] = []
}

struct JSONError: Decodable {
    let message: String?
    let code: Int?
}

// MARK: - Common Error description
extension Error {
    var description: String {
        let message = (self as? HTTPStatus)?.localizedDescription ?? self.localizedDescription
        return message.isEmpty ? "Something went wrong" : message
    }
}

// MARK: - cUrl
extension URLRequest {
    // Returns a cURL command representation of this URL request.
    var curlString: String {
        guard let url else { return "" }
        var baseCommand = #"curl "\#(url.absoluteString)""#
        
        if httpMethod == "HEAD" {
            baseCommand += " --head"
        }
        
        var command = [baseCommand]
        
        if let method = httpMethod, method != "GET" && method != "HEAD" {
            command.append("-X \(method)")
        }
        
        if let headers = allHTTPHeaderFields {
            for (key, value) in headers where key != "Cookie" {
                command.append("-H '\(key): \(value)'")
            }
        }
        
        if let data = httpBody, let body = String(data: data, encoding: .utf8) {
            command.append("-d '\(body)'")
        }
        
        return command.joined(separator: " \\\n\t")
    }
}
