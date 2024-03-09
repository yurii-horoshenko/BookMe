//
//  NextVisitView.swift
//  BookMeNow-Develop
//
//  Created by Yurii Goroshenko on 17.08.2023.
//

import SwiftUI

struct NextVisitView: View {
    // MARK: - Properties
    var onCallPress: (() -> Void)?
    var onCancelPress: (() -> Void)?
    var onMapPress: (() -> Void)?
    
    // MARK: - Lifecycle
    var body: some View {
        VStack(alignment: .leading) {
            HStack {
                VStack(alignment: .leading, spacing: 6.0) {
                    VStack(alignment: .leading, spacing: 4.0) {
                        Text("Belle Curls")
                            .font(Font.H5Bold)
                        
                        Text("0993 Novick Parkway")
                            .font(Font.BodyLargeSemibold)
                    }
                }
                .foregroundColor(Color.white)
                
                Spacer()
                
                DataView
            }
            .frame(maxWidth: .infinity)
            .padding(EdgeInsets(top: 16.0, leading: 24.0, bottom: 16.0, trailing: 24.0))
            
            ButtonsView
                .padding(.horizontal, 16.0)
        }
        .background(Color.primary500)
        .cornerRadius(32.0)
    }
    
    var DataView: some View {
        VStack {
            Text("Monday")
                .font(Font.BodyLargeSemibold)
                .foregroundColor(Color.red)
            
            Text("30")
                .font(Font.H4Bold)
            
            Text("5:30 PM")
                .font(Font.BodyMediumMedium)
        }
        .frame(width: 77.0, height: 77.0)
        .background(Color.white)
        .cornerRadius(16.0)
    }
    
    var ButtonsView: some View {
        HStack(spacing: 8.0) {
            CallButton
            CancelButton
            MapButton
        }
        .frame(height: 38.0)
        .padding(.bottom, 16.0)
    }
    
    var CallButton: some View {
        Button {
            onCallPress?()
        } label: {
            HStack(alignment: .center) {
                Icons.Phone
                
                Text(String(localized: "BUTTON-CALL"))
                    .font(Font.BodyLargeSemibold)
            }
            .frame(height: 16)
            .foregroundColor(Color.white)
            .padding(EdgeInsets(top: 8.0, leading: 16.0, bottom: 8.0, trailing: 16.0))
        }
        .background(Color.info)
        .cornerRadius(19.0)
    }
    
    var CancelButton: some View {
        Button {
            onCancelPress?()
        } label: {
            HStack(alignment: .center) {
                Icons.Delete
                
                Text(String(localized: "BUTTON-CANCEL"))
                    .font(Font.BodyLargeSemibold)
            }
            .frame(height: 16)
            .foregroundColor(Color.white)
            .padding(buttonEdgeInsets)
        }
        .background(Color.error)
        .cornerRadius(19.0)
    }
    
    var MapButton: some View {
        Button {
            onMapPress?()
        } label: {
            HStack(alignment: .center) {
                Icons.Map
                
                Text(String(localized: "BUTTON-MAP"))
                    .font(Font.BodyLargeSemibold)
            }
            .frame(height: 16)
            .foregroundColor(Color.primary500)
            .padding(buttonEdgeInsets)
        }
        .background(Color.white)
        .cornerRadius(19.0)
    }
}

#Preview {
    NextVisitView()
        .padding(16.0)
}
