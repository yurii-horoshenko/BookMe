# BookMeNow

## Design

To view and work with the design mockups, use the following Figma link:
    [Design on Figma]
    (https://www.figma.com/file/tQct25XxTRIIkbyPTU2lnW/BookMe-v1?type=design&node-id=727%3A25421&mode=design&t=eBtOgRJ4RPWPOBlG-1)

## API Documentation

The API documentation is available through Swagger at the following link:

    [API Documentation]
    (https://bookmeservice.azurewebsites.net/swagger/index.html)

## Kotlin Multiplatform Mobile (KMM) Setup

For automated code formatting and enforcing a consistent style, we use Spotless. Use the following commands to manage code style:

    1.    Run formatting:
        •    To automatically format your code, run:
        `./gradlew spotlessApply`

    2.    Run style check:
        •    To check the code style without formatting, run:
        `./gradlew spotlessCheck`


## iOS Setup

Pre-install gem tools

Before starting work on the iOS project, ensure you have the following tools installed:

    •    Fastlane: Automates the building and deployment process.
         [Fastlane setup for iOS](https://docs.fastlane.tools/getting-started/ios/setup)
    
    •    SwiftLint: A static code analyzer for maintaining Swift code style.
         [SwiftLint GitHub](https://github.com/realm/SwiftLint)
    
    •    XcodeGen: Automatically generates .xcodeproj files from a project specification.
         [XcodeGen GitHub](https://github.com/yonaskolb/XcodeGen)

## Fastlane Plugins

Ensure you install the following Fastlane plugins:

    •    [Changelog Plugin](https://github.com/pajapro/fastlane-plugin-changelog)
    •    [Firebase App Distribution Plugin](https://github.com/firebase/fastlane-plugin-firebase_app_distribution)

## Run iOS Commands

    1.    Update all plugins:
        •    Before proceeding, update all Fastlane plugins:
        `fastlane update_plugins`

    2.    Generate project files:
        •    To correctly create .xcodeproj and .xcworkspace files, run:
        `fastlane xcodegen`
        
    3.    Check code and autocorrect style issues:
        •    To check the code and automatically fix minor style issues, run:
        `fastlane lint`
    
    4.    Generating .ipa file:
        •    To build the .ipa file, you can use a simple Fastlane command:
        `fastlane build_ipa`
