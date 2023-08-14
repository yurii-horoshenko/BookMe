//
//  VerificationCodeView.swift
//  BookMeNow-Develop
//
//  Created by Yurii Goroshenko on 14.08.2023.
//

import Combine
import SwiftUI

struct VerificationCodeView: View {
    // MARK: - PROPERTIES
    private let unselectedShape = RoundedShapeView(color: Color.greyscale50, step: 3.0, isFilled: true)
    private let unselectedBorder = RoundedShapeView(color: Color.greyscale200, step: 3.0, isFilled: false)
    private let selectedShape = RoundedShapeView(color: Color.primary500, step: 3.0, isFilled: true)
    private let selectedBorder = RoundedShapeView(color: Color.primary500, step: 3.0, isFilled: false)
    
    @Binding var array: [FieldData]
    @State var currentState: FieldData
    @State var currentValue: String = ""
    @FocusState private var activeFieldIndex: Int?
    
    // MARK: - Body
    var body: some View {
        HStack(spacing: 16.0) {
            ForEach(0..<array.count, id: \.self) { index in
                ZStack {
                    TextField("", text: $currentState.value)
                        .keyboardType(.numberPad)
                        .focused($activeFieldIndex, equals: -1)
                        .frame(width: 0.0, height: 0.0)
                    
                    CodeItemView(by: index)
                }
            }
        }
        .frame(height: 60.0)
        .onAppear {
            activeFieldIndex = 0
        }
        .onChange(of: array) { _ in
            guard let index = activeFieldIndex, index >= 0 else { return }
           
            let newIndex = index + 1
            guard newIndex < array.count else { return }
            activeFieldIndex = -1
            currentState = array[newIndex]
            DispatchQueue.main.asyncAfter(deadline: .now() + 0.25) {
                activeFieldIndex = newIndex
            }
        }
        .onChange(of: currentValue) { newValue in
            guard let index = activeFieldIndex, index >= 0 else { return }
            let newValue = String(newValue.suffix(1))
            array[index].value = newValue
            currentValue = newValue
        }
    }
    
    func CodeItemView(by index: Int) -> some View {
        VStack(alignment: .center) {
            if currentState == array[index] {
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
            } else {
                Text(array[index].value)
                    .frame(width: 60.0, height: 60.0)
                    .background(unselectedShape)
                    .background(unselectedBorder)
                    .onTapGesture {
                        activeFieldIndex = -1
                        currentState = array[index]
                        
                        DispatchQueue.main.asyncAfter(deadline: .now() + 0.25) {
                            activeFieldIndex = index
                        }
                    }
            }
        }
        .font(Font.H4Bold)
        .foregroundColor(Color.greyscale900)
    }
}

struct VerificationCodeView_Previews: PreviewProvider {
    @State static var code = Array(repeating: FieldData(), count: 4)
    
    static var previews: some View {
        VerificationCodeView(array: $code, currentState: code.first ?? FieldData())
            .padding(16.0)
    }
}
