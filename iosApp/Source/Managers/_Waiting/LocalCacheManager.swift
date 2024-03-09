//
//  LocalCacheManager.swift
//  Created by Yurii Goroshenko on 29.03.2023.
//

import Foundation

final class LocalCacheManager {
    // static let shared = LocalCacheManager()
    
    // MARK: - LocalCache
    //    let modelCache = NSCache<NSString, CachedARModel>()
    //    let productsCache = NSCache<NSString, CachedProductsResponse>()
}

// final class CachedProductsResponse: NSObject {
//    var data: [Product] = []
// }
//
// MARK: - Cache
// extension LocalCache {
//    func getProducts(by id: String) -> ProductsResponse? {
//        guard let object = productsCache.object(forKey: id as NSString) else { return nil }
//        return ProductsResponse(data: object.data)
//    }
//
//    func saveProducts(_ id: String, value: [Product]) {
//        let object = CachedProductsResponse()
//        object.data = value
//        productsCache.setObject(object, forKey: id as NSString)
//    }
// }
