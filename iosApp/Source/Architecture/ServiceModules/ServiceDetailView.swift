//
//  ServiceDetailView.swift
//  BookMeNow-Develop
//
//  Created by Yurii Goroshenko on 13.09.2023.
//

import SwiftUI
import MapKit

struct ServiceDetailView: View {
    @ObservedObject var presenter = ServiceDetailPresenter()
    
    var body: some View {
        NavigationView {
            NavigationStack {
                ScrollView {
                    VStack(alignment: .leading) {
                        Image("img-detail-mask")
                            .edgesIgnoringSafeArea(.top)
                        
                        BaseView(iconColor: Color.primary500, content: {
                            ContentView
                            //                        .navigationDestination(isPresented: $presenter.toServiceDetail) {
                            //                            ServiceDetailView()
                            //                        }
                        })
                    }
                }
                .edgesIgnoringSafeArea(.top)
            }
        }
        .navigationBarBackButtonHidden(true)
        .environment(\.colorScheme, .light)
    }
    
    var ContentView: some View {
        VStack(alignment: .leading, spacing: 24.0) {
            TitleView
            LocationView
            ReviewView
            
            Divider()
                .background(Color.greyscale200)
                .frame(height: 1.0)
            
            DetailView
            WorkingHoursView
            ContactsView
            AddressView
            
            Divider()
                .background(Color.greyscale200)
                .frame(height: 1.0)
            
            BottomButton
            Spacer()
        }
        .padding(.horizontal, 32.0)
    }
    
    var TitleView: some View {
        HStack {
            Text("Barbarella Inova")
                .font(Font.H3Bold)
                .foregroundColor(Color.greyscale900)
            
            Spacer()
            
            Text("Open")
                .font(Font.BodyLargeSemibold)
                .foregroundColor(Color.white)
                .padding(EdgeInsets(top: 8.0, leading: 16.0, bottom: 8.0, trailing: 16.0))
                .background(Color.primary500)
                .cornerRadius(19.0)
        }
    }
    
    var LocationView: some View {
        HStack(spacing: 8.0) {
            Icons.MapBold
                .foregroundColor(Color.primary500)
            
            Text("6993 Meadow Valley Terrace, New York")
                .font(Font.BodyLargeMedium)
                .foregroundColor(Color.greyscale700)
        }
    }
    
    var ReviewView: some View {
        HStack(spacing: 8.0) {
            Icons.StarBold
                .foregroundColor(Color.primary500)
            
            Text("4.8 (3,279 reviews)")
                .font(Font.BodyLargeMedium)
                .foregroundColor(Color.greyscale700)
        }
    }
    
    var DetailView: some View {
        Text("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip. Read more...")
            .font(Font.BodyMediumRegular)
            .foregroundColor(Color.greyscale800)
    }
    
    var WorkingHoursView: some View {
        VStack(alignment: .leading, spacing: 16.0) {
            Text("Working Hours")
                .font(Font.H6Bold)
                .foregroundColor(Color.greyscale900)
            
            HStack(spacing: 16.0) {
                VStack(alignment: .leading, spacing: 16.0) {
                    Text("Monday - Friday")
                        .font(Font.BodyLargeMedium)
                        .foregroundColor(Color.greyscale700)
                    Text("Saturday - Sunday")
                        .font(Font.BodyLargeMedium)
                        .foregroundColor(Color.greyscale700)
                }
                
                VStack(alignment: .leading, spacing: 16.0) {
                    Text(":")
                        .font(Font.BodyLargeMedium)
                        .foregroundColor(Color.greyscale900)
                    Text(":")
                        .font(Font.BodyLargeMedium)
                        .foregroundColor(Color.greyscale900)
                }
                
                VStack(alignment: .leading, spacing: 16.0) {
                    Text("08:00 AM - 21:00 PM")
                        .font(Font.BodyLargeSemibold)
                        .foregroundColor(Color.greyscale900)
                    Text("10:00 AM - 20:00 PM")
                        .font(Font.BodyLargeSemibold)
                        .foregroundColor(Color.greyscale900)
                }
            }
        }
    }
    
    var ContactsView: some View {
        VStack(alignment: .leading, spacing: 16.0) {
            Text("Contact us")
                .font(Font.H6Bold)
                .foregroundColor(Color.greyscale900)
            
            Text("(406) 555-0120")
                .font(Font.H6Bold)
                .foregroundColor(Color.primary500)
        }
    }
    
    var AddressView: some View {
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
            
            HStack(spacing: 8.0) {
                Icons.MapBold
                    .foregroundColor(Color.primary500)
                
                Text("6993 Meadow Valley Terrace, New York")
                    .font(Font.BodyLargeMedium)
                    .foregroundColor(Color.greyscale700)
            }
            
            Map(coordinateRegion: .constant(MKCoordinateRegion(center: CLLocationCoordinate2D(latitude: 51.507222, longitude: -0.1275), span: MKCoordinateSpan(latitudeDelta: 0.5, longitudeDelta: 0.5))), interactionModes: [])
                .frame(height: 300)
        }
    }
    
    // Button Book Now
    var BottomButton: some View {
        AppButton(
            state: .constant(.active),
            title: "Book Now",
            titleColor: Color.white,
            backgroundColor: Color.primary500,
            action: {  }
        )
//        .navigationDestination(isPresented: $presenter.toCodeVerification) {
//            EnterCodeView(phone: presenter.phone.value.phoneMask)
//        }
    }
    
}

struct ServiceDetailView_Previews: PreviewProvider {
    static var previews: some View {
        ServiceDetailView()
    }
}
