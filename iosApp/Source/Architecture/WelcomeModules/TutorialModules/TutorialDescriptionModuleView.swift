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
    enum Step: Hashable {
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
    @State private var scrollID: Int? = 0
    @State private var currectStep = Step.first
    
    // MARK: - Lifecycle
    var body: some View {
        ContentView
            .navigationBarBackButtonHidden(true)
            .padding(24.0)
            .onAppear {
                scrollID = ImageAsset.all.first?.id ?? 0
            }
    }
    
    var ContentView: some View {
        VStack(alignment: .center) {
            Spacer()
            
            ScrollView(.horizontal, showsIndicators: false) {
                HStack(spacing: 48.0) {
                    ForEach(ImageAsset.all) { asset in
                        Image(asset.name)
                            .resizable()
                            .scaledToFit()
                            .frame(width: UIScreen.screenWidth - 64.0)
                    }
                }
            }
            .scrollPosition(id: $scrollID)
            .scrollDisabled(true)
            .scrollTargetLayout()

            Spacer()
            
            Text(currectStep.title)
                .attributed(.H3Bold, color: Color.greyscale900)
            
            Spacer()
            
            PagingView(
                countPages: ImageAsset.all.count,
                currectIndex: $scrollID
            )
            .padding(.bottom, 60.0)
            
            AppFilledButton(
                state: .constant(.active),
                title: currectStep.buttonTitle,
                titleColor: Color.white,
                backgroundColor: Color.primary500,
                action: { onButtonClick() }
            )
        }
    }
    
}

// MARK: - TutorialDescriptionModuleViewProtocol
extension TutorialDescriptionModuleView: TutorialDescriptionModuleViewProtocol {
    func onButtonClick() {
        guard currectStep == .second else {
            withAnimation {
                currectStep = .second
                scrollID = ImageAsset.all.last?.id
            }
            return
        }
        
        UserDefaultsManager.wasTutorial = true
        moveToWelcomePage()
    }
    
    func moveToWelcomePage() {
        let view = AuthPageBuilder.constructWelcomeView()
        setRootView(view)
    }
}

#Preview {
    TutorialDescriptionModuleView()
}
