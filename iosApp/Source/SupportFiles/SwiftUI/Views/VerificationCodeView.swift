//
//  VerificationCodeView.swift
//  BookMeNow-Develop
//
//  Created by Yurii Goroshenko on 14.08.2023.
//

import Combine
import SwiftUI

struct VerificationCodeView: View {
    // MARK: - Properties
    private let unselectedShape = RoundedShapeView(color: Color.greyscale50, step: 3.0, isFilled: true)
    private let unselectedBorder = RoundedShapeView(color: Color.greyscale200, step: 3.0, isFilled: false)
    private let selectedShape = RoundedShapeView(color: Color.primary500, step: 3.0, isFilled: true)
    private let selectedBorder = RoundedShapeView(color: Color.primary500, step: 3.0, isFilled: false)
    
    @Binding var array: [FieldData]
    @State var currentState: FieldData
    @State var currentValue: String = ""
    @FocusState private var activeFieldIndex: Int?
    
    // MARK: - Lifecycle
    var body: some View {
        HStack(spacing: 16.0) {
            ForEach(0..<array.count, id: \.self) { index in
                TextField("", text: $array[index].value)
                    .padding(.horizontal, 16.0)
                    .keyboardType(.numberPad)
                    .multilineTextAlignment(.center)
                    .textContentType(.oneTimeCode)
                    .focused($activeFieldIndex, equals: index)
                    .accentColor(Color.primary500)
                    .frame(width: 60.0, height: 60.0)
                    .background(selectedShape.opacity(0.08))
                    .background(selectedBorder)
                    .font(Font.H4Bold)
                    .foregroundColor(Color.greyscale900)
            }
        }
        .frame(height: 60.0)
        .onAppear {
            activeFieldIndex = 0
        }
        .onChange(of: array) {
            guard let index = activeFieldIndex, index >= 0 else { return }
            let maxCount = array[index].value.count
            let value = array[index].value
            let newIndex = index + 1
            
            guard newIndex < array.count else { return }
            currentState = array[newIndex]
            activeFieldIndex = newIndex
            
            if maxCount > 1 {
                array[index].value = String(value.prefix(1))
                array[newIndex].value = String(value.suffix(1))
            }
        }
        .onChange(of: currentValue) {
            guard let index = activeFieldIndex, index >= 0 else { return }
            let newValue = String(currentValue.suffix(1))
            array[index].value = newValue
            currentValue = newValue
        }
    }
}

#Preview {
    VerificationCodeView(
        array: .constant(Array(repeating: FieldData(), count: 4)),
        currentState: FieldData()
    )
}
