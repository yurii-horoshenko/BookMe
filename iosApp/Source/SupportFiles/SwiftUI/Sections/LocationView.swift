//
//  LocationView.swift
//  iosApp
//
//  Created by Yurii Goroshenko on 23.11.2023.
//

import MapKit
import SwiftUI

struct LocationView: View {
    // MARK: - Properties
    @State var region = MKCoordinateRegion(center: CLLocationCoordinate2D(latitude: 51.507222, longitude: -0.1275), span: MKCoordinateSpan(latitudeDelta: 0.5, longitudeDelta: 0.5))
    var useTitle = true
    var useMap = true
    
    // MARK: - Lifecycle
    var body: some View {
        VStack(alignment: .leading, spacing: 16.0) {
            HStack(spacing: 8.0) {
                Text("Our Address")
                    .font(Font.H6Bold)
                    .foregroundColor(Color.greyscale900)
                
                Spacer()
                
                Button {
                    print("")
                } label: {
                    HStack(alignment: .center) {
                        Text("See on Maps")
                            .font(Font.BodyLargeBold)
                            .foregroundColor(Color.primary500)
                    }
                    .padding(EdgeInsets(top: 8.0, leading: 16.0, bottom: 8.0, trailing: 16.0))
                }
            }
            .isHidden(!useTitle)
            
            HStack(spacing: 8.0) {
                Icons.MapBold
                    .foregroundColor(Color.primary500)
                
                Text("6993 Meadow Valley Terrace, New York")
                    .font(Font.BodyLargeMedium)
                    .foregroundColor(Color.greyscale700)
            }
            
            Map(coordinateRegion: $region)
                .frame(height: 300)
                .isHidden(!useMap)
        }
    }
}

#Preview {
    LocationView()
}
