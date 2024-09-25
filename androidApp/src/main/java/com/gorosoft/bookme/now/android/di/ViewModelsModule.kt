package com.gorosoft.bookme.now.android.di

import com.gorosoft.bookme.now.android.ui.account_setup.create_your_profile.CreateYourProfileViewModel
import com.gorosoft.bookme.now.android.ui.account_setup.enter_otp.EnterOtpViewModel
import com.gorosoft.bookme.now.android.ui.main_screen.explore.ExploreViewModel
import com.gorosoft.bookme.now.android.ui.main_screen.profile.choose_language.ChooseLanguageViewModel
import com.gorosoft.bookme.now.android.ui.main_screen.profile.edit_profile.EditProfileViewModel
import com.gorosoft.bookme.now.android.ui.onboarding.TutorialCarouselViewModel
import com.gorosoft.bookme.now.android.ui.splash_screen.SplashScreenViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

fun viewModelModule() = module {
    viewModel {
        CreateYourProfileViewModel(
            savedStateHandle = get(),
            profileIsValidUseCase = get(),
        )
    }

    viewModel {
        SplashScreenViewModel(
            hadTutorialUseCase = get(),
            isLoggedInUseCase = get(),
            loginUseCase = get(),
        )
    }

    viewModel {
        TutorialCarouselViewModel(
            setHadTutorialUseCase = get(),
        )
    }

    viewModel { EnterOtpViewModel() }

    viewModel {
        ExploreViewModel(
            locationTracker = get(),
        )
    }
    viewModel {
        ChooseLanguageViewModel(getLanguagesUiUseCase = get())
    }

    viewModel { EditProfileViewModel(savedStateHandle = get()) }
}
