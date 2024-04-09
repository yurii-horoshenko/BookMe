//
//  KMM+Extensions.swift
//  iosApp
//
//  Created by Yurii Goroshenko on 06.04.2024.
//

import shared

extension Response<AnyObject> {
func onSuccessResult(_ result: @escaping (AnyObject) -> Void) -> Response<AnyObject>? {
    guard let data = (self as? ResponseSuccess<AnyObject>)?.data else { return self }
    DispatchQueue.main.async {
        result(data)
    }
    return nil
}

func onError(result: (Int, String) -> Void) -> Response<AnyObject>? {
    self
}

func onFailure() -> Response<AnyObject>? {
    self
}
}
