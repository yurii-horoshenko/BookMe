//
//  LocationManager.swift
//  Created by Yurii Goroshenko on 29.03.2023.
//

import CoreLocation

protocol LocationManagerDelegate: AnyObject {
    func findLocation(_ coordinate: CLLocation)
}

final class LocationManager: NSObject {
    // MARK: - Variables
    private lazy var manager: CLLocationManager = {
        let manager = CLLocationManager()
        manager.delegate = self
        manager.requestLocation()
        return manager
    }()
    var coordinate: CLLocationCoordinate2D?
    weak var delegate: LocationManagerDelegate?
    
    // MARK: - Lifacycle
    func startTrack () {
        // Start updating location
        manager.requestAlwaysAuthorization()
        manager.startUpdatingLocation()
    }
    
    func stopTrack() {
        // Make sure to stop updating location when your
        // app no longer needs location updates
        manager.stopUpdatingLocation()
    }
    
    func checkStatus() {
        // Handle each case of location permissions
        switch manager.authorizationStatus {
        case .authorizedAlways:
            print() // Handle case
        case .authorizedWhenInUse:
            print() // Handle case
        case .denied:
            print()
            
        case .notDetermined:
            manager.requestLocation()
            
        case .restricted:
            print() // Handle case
        default:
            print()
        }
    }
}

// MARK: - Private
extension LocationManager: CLLocationManagerDelegate {
    func locationManager(_ manager: CLLocationManager, didChangeAuthorization status: CLAuthorizationStatus) {
        // Handle changes if location permissions
    }
    
    func locationManager(_ manager: CLLocationManager, didUpdateLocations locations: [CLLocation] ) {
        guard let location = locations.first else { return }
        stopTrack()
        delegate?.findLocation(location)
    }
    
    func locationManager( _ manager: CLLocationManager, didFailWithError error: Error) {
        // Handle failure to get a user’s location
    }
}
