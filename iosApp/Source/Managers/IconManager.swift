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
}
