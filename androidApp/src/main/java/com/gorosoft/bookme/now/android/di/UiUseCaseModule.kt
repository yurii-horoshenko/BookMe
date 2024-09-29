package com.gorosoft.bookme.now.android.di

import com.gorosoft.bookme.now.android.ui.usecase.GetLanguagesUiUseCase
import com.gorosoft.bookme.now.android.ui.usecase.LoginWithGoogleUiUseCase
import com.gorosoft.bookme.now.android.ui.usecase.LogoutUiUseCase
import com.gorosoft.bookme.now.android.ui.usecase.ProfileUiIsValidUseCase
import org.koin.dsl.module

fun uiUseCaseModule() = module {
    factory<ProfileUiIsValidUseCase> { ProfileUiIsValidUseCase() }
    factory<GetLanguagesUiUseCase> { GetLanguagesUiUseCase() }
    factory {
        LoginWithGoogleUiUseCase(
            loginWithTokenUseCase = get(),
        )
    }
    factory {
        LogoutUiUseCase(context = get())
    }
}
