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
                return String(localized: "TUTORIAL-INFO-1")
            case .second:
                return String(localized: "TUTORIAL-INFO-2")
            }
        }
        
        var buttonTitle: String {
            switch self {
            case .first:
                return String(localized: "BUTTON-NEXT")
            case .second:
                return String(localized: "BUTTON-STARTED")
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
                HStack(spacing: 0.0) {
                    ForEach(ImageAsset.all) { asset in
                        Image(asset.name)
                            .resizable()
                            .scaledToFit()
                            .frame(width: UIScreen.screenWidth - 48.0)
                            .frame(height: 230.0)
                    }
                }
            }
            .scrollPosition(id: $scrollID)
            .scrollDisabled(true)
            .scrollTargetLayout()
            
            Spacer()
            
            BottomContentView
        }
    }
    
    var BottomContentView: some View {
        VStack(spacing: 60.0) {
            Text(currectStep.title)
                .attributed(.H3Bold, color: Color.greyscale900)
            
            PagingView(
                countPages: ImageAsset.all.count,
                currectIndex: $scrollID
            )
            
            NavigationButton<Steps>(
                title: currectStep.buttonTitle,
                navigationType: .dashboard
            )
            
            AppFilledButton(
                state: .constant(.active),
                autoWidth: true,
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
