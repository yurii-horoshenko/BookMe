package com.gorosoft.bookme.now.android.di

import com.gorosoft.bookme.now.android.ui.usecase.LoginWithGoogleUiUseCase
import com.gorosoft.bookme.now.android.ui.usecase.LogoutUiUseCase
import com.gorosoft.bookme.now.android.ui.usecase.ProfileUiIsValidUseCase
import org.koin.dsl.module

fun uiUseCaseModule() = module {
    factory { ProfileUiIsValidUseCase() }
    factory {
        LoginWithGoogleUiUseCase(
            loginWithTokenUseCase = get(),
        )
    }
    factory {
        LogoutUiUseCase(context = get())
    }
}
