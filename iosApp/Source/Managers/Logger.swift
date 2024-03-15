//
//  ApplicationManager.swift
//  Created by Yurii Goroshenko on 29.03.2023.
//

import Foundation

// MARK: - Log Configurator
enum LoggerConfigurator {
    static let cURL = false
    //
    static let requestLink = false
    static let requestHeaders = false
    static let requestParameters = false
    //
    static let responseLink = false
    static let responseBody = false
    //
    static let printLog = true
    static let printErrorLog = true
    static let printNetworkLog = true
}

// MARK: - Debugs
func printLog(_ items: Any..., separator: String = " ", terminator: String = "\n") {
    if LoggerConfigurator.printLog {
        let output = items.map { "🏷️ \($0) " }.joined(separator: separator)
        Swift.debugPrint(output, terminator: terminator)
    }
}

func printErrorLog(_ items: Any..., separator: String = " ", terminator: String = "\n") {
    if LoggerConfigurator.printErrorLog {
        let output = items.map { "🔴🔴🔴 \($0) 🔴🔴🔴" }.joined(separator: separator)
        Swift.debugPrint(output, terminator: terminator)
    }
}

func printNetworkLog(_ items: Any..., separator: String = " ", terminator: String = "\n") {
    if LoggerConfigurator.printNetworkLog {
        let output = items.map { "🚀🚀🚀 \($0) 🚀🚀🚀" }.joined(separator: separator)
        Swift.debugPrint(output, terminator: terminator)
    }
}
