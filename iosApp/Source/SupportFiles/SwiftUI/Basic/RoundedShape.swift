//
//  RoundedShape.swift
//
//  Created by Yurii Goroshenko on 4/6/23.
//

import SwiftUI

struct RoundedShape: Shape {
    // MARK: - Properties
    var tl: CGFloat = 0.0
    var tr: CGFloat = 0.0
    var bl: CGFloat = 0.0
    var br: CGFloat = 0.0
    var step: CGFloat = 2.0
    
    // MARK: - Lifecycle
    func path(in rect: CGRect) -> Path {
        Path { path in
            let w = rect.width
            let h = rect.height
            
            // Make sure we do not exceed the size of the rectangle
            let tr = min(max(tr, h / step), w / step)
            let tl = min(max(tl, h / step), w / step)
            let bl = min(max(bl, h / step), w / step)
            let br = min(max(br, h / step), w / step)
            
            let atr = CGPoint(x: w - tr, y: tr)
            let abr = CGPoint(x: w - br, y: h - br)
            let abl = CGPoint(x: bl, y: h - bl)
            let atl = CGPoint(x: tl, y: tl)
            
            path.move(to: CGPoint(x: w / step, y: 0))
            path.addLine(to: CGPoint(x: w - tr, y: 0))
            path.addArc(center: atr, radius: tr, startAngle: Angle(degrees: -90), endAngle: Angle(degrees: 0), clockwise: false)
            path.addLine(to: CGPoint(x: w, y: h - br))
            path.addArc(center: abr, radius: br, startAngle: Angle(degrees: 0), endAngle: Angle(degrees: 90), clockwise: false)
            path.addLine(to: CGPoint(x: bl, y: h))
            path.addArc(center: abl, radius: bl, startAngle: Angle(degrees: 90), endAngle: Angle(degrees: 180), clockwise: false)
            path.addLine(to: CGPoint(x: 0, y: tl))
            path.addArc(center: atl, radius: tl, startAngle: Angle(degrees: 180), endAngle: Angle(degrees: 270), clockwise: false)
            path.closeSubpath()
        }
    }
}

struct RoundedShapeView: View {
    // MARK: - Properties
    private let lineWidth = 1.0
    var color = Color.white
    var step: CGFloat = 2.0
    @State var isFilled = false
    
    // MARK: - Lifecycle
    var body: some View {
        if isFilled {
            RoundedShape(step: step)
                .fill(color)
        } else {
            RoundedShape(step: step)
                .stroke(color, lineWidth: lineWidth)
        }
    }
}
