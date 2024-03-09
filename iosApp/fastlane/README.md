fastlane documentation
----

# Installation

Make sure you have the latest version of the Xcode command line tools installed:

```sh
xcode-select --install
```

For _fastlane_ installation instructions, see [Installing _fastlane_](https://docs.fastlane.tools/#installing-fastlane)

# Available Actions

## iOS

### ios install_cocoapods

```sh
[bundle exec] fastlane ios install_cocoapods
```



### ios clear

```sh
[bundle exec] fastlane ios clear
```



### ios updates

```sh
[bundle exec] fastlane ios updates
```



### ios export

```sh
[bundle exec] fastlane ios export
```



### ios xcodegen

```sh
[bundle exec] fastlane ios xcodegen
```



### ios lint

```sh
[bundle exec] fastlane ios lint
```



### ios run_all

```sh
[bundle exec] fastlane ios run_all
```



### ios configure

```sh
[bundle exec] fastlane ios configure
```



### ios certificates

```sh
[bundle exec] fastlane ios certificates
```

Get certificates

### ios generate_new_certificates

```sh
[bundle exec] fastlane ios generate_new_certificates
```

Generate new certificates

### ios register_new_device

```sh
[bundle exec] fastlane ios register_new_device
```

Register new testing device. Parameters `name` and `udid` are required

### ios download_profiles

```sh
[bundle exec] fastlane ios download_profiles
```

Download code signing certificates and profiles. Parameter `type` is required

### ios remove_cer

```sh
[bundle exec] fastlane ios remove_cer
```



### ios unit_test

```sh
[bundle exec] fastlane ios unit_test
```

Run unit tests and zip resulting test report and app file artifacts

### ios build_alpha

```sh
[bundle exec] fastlane ios build_alpha
```



### ios build_beta

```sh
[bundle exec] fastlane ios build_beta
```



### ios build_testflight

```sh
[bundle exec] fastlane ios build_testflight
```



### ios setup

```sh
[bundle exec] fastlane ios setup
```

BookMeNow Common setup

### ios setup_debug

```sh
[bundle exec] fastlane ios setup_debug
```



### ios adhoc_bookme

```sh
[bundle exec] fastlane ios adhoc_bookme
```

BookMeNow DEVELOP build

### ios adhoc_bookme_preprod

```sh
[bundle exec] fastlane ios adhoc_bookme_preprod
```

BookMeNow PREPRODUCTION build

### ios appstore_bookme

```sh
[bundle exec] fastlane ios appstore_bookme
```

BookMeNow PRODUCTION build

### ios unit_test_bookme

```sh
[bundle exec] fastlane ios unit_test_bookme
```

BookMeNow unit test run

### ios test

```sh
[bundle exec] fastlane ios test
```

Runs all the tests

----

This README.md is auto-generated and will be re-generated every time [_fastlane_](https://fastlane.tools) is run.

More information about _fastlane_ can be found on [fastlane.tools](https://fastlane.tools).

The documentation of _fastlane_ can be found on [docs.fastlane.tools](https://docs.fastlane.tools).
