//
//  TutorialDescriptionModuleView.swift
//  iosApp
//
//  Created by Yurii Goroshenko on 16.01.2024.
//

import SwiftUI

protocol TutorialDescriptionModuleViewProtocol {
    func onButtonClick()
    func moveToWelcomePage()
}

struct TutorialDescriptionModuleView: View {
    enum Step: Int {
        case first
        case second
        
        var title: String {
            switch self {
            case .first:
                return "Find Barbers, Salons, Doctors or Other Services Easily"
            case .second:
                return "Book Your Type of Services Quickly"
            }
        }
        
        var buttonTitle: String {
            switch self {
            case .first:
                return "Next"
            case .second:
                return "Get Started"
            }
        }
    }
    
    // MARK: - Properties
    @State var currectStep = Step.first
    
    // MARK: - Lifecycle
    var body: some View {
        VStack(alignment: .leading) {
            Spacer()
            
            switch currectStep {
            case .first:
                Images.TutorialPage1
            case .second:
                Images.TutorialPage2
            }
            
            Spacer()
            
            Text(currectStep.title)
                .attributed(.H4Bold, color: Color.greyscale900)
            
            Spacer()
            
            AppFilledButton(
                state: .constant(.active),
                title: currectStep.buttonTitle,
                titleColor: Color.white,
                backgroundColor: Color.primary500,
                action: { onButtonClick() }
            )
            .padding(.horizontal, 6.0)
        }
        .padding(24.0)
    }
}

// MARK: - TutorialDescriptionModuleViewProtocol
extension TutorialDescriptionModuleView: TutorialDescriptionModuleViewProtocol {
    func onButtonClick() {
        guard currectStep == .second else {
            currectStep = .second
            return
        }
        
        moveToWelcomePage()
    }
    
    func moveToWelcomePage() {
        let view = WelcomeView()
        setRootView(view)
    }
}

#Preview {
    TutorialDescriptionModuleView()
}
