//
//  Icons.swift
//  BookMeNow-Develop
//
//  Created by Yurii Goroshenko on 17.08.2023.
//

import shared
import SwiftUI

enum Icons {
    static var Search: some View {
        Image("ic-search")
            .resizable()
            .renderingMode(.template)
            .frame(width: 20, height: 20)
    }
    
    static var Filter: some View {
        Image("ic-filter")
            .resizable()
            .renderingMode(.template)
            .frame(width: 20, height: 20)
    }
   
    static var Notification: some View {
        Image("ic-notification")
            .resizable()
            .renderingMode(.template)
            .frame(width: 20, height: 20)
    }
    
    // Image Arrow down
    static var ArrowDown: some View {
        Image(ICON.arrowDown.value)
            .resizable()
            .renderingMode(.template)
            .frame(width: 20, height: 20)
    }
    
    // Image Calendar
    static var Calendar: some View {
        Image(ICON.calendar.value)
            .resizable()
            .renderingMode(.template)
            .frame(width: 20, height: 20)
    }
    
    static var Back: some View {
        Image("ic-back")
            .resizable()
            .renderingMode(.template)
            .frame(width: 20, height: 20)
    }
    
    static var Phone: some View {
        Image("ic-call")
            .resizable()
            .renderingMode(.template)
            .frame(width: 20, height: 20)
    }
    
    static var Map: some View {
        Image("ic-location")
            .resizable()
            .renderingMode(.template)
            .frame(width: 20, height: 20)
    }
    
    static var MapBold: some View {
        Image("ic-location-bold")
            .resizable()
            .renderingMode(.template)
            .frame(width: 20, height: 20)
    }
    
    static var StarBold: some View {
        Image("ic-star-bold")
            .resizable()
            .renderingMode(.template)
            .frame(width: 20, height: 20)
    }
    
    static var Delete: some View {
        Image("ic-delete")
            .resizable()
            .renderingMode(.template)
            .frame(width: 20, height: 20)
    }
}

enum TabIcons {
    static var Home: some View {
        Image("ic-home")
            .resizable()
            .renderingMode(.template)
            .frame(width: 20, height: 20)
    }
    
    static var Profile: some View {
        Image("ic-profile")
            .resizable()
            .renderingMode(.template)
            .frame(width: 20, height: 20)
    }
}

enum Images {
    static var Welcome: some View {
        Image(IMAGE.welcome.value)
            .resizable()
            .scaledToFit()
    }
    
    static var Logo: some View {
        Image(IMAGE.welcome.value)
            .resizable()
            .frame(width: 20, height: 20)
    }
    
    static var TableMask: some View {
        Image("img-mask")
            .resizable()
            .frame(width: 80, height: 80)
    }
}
