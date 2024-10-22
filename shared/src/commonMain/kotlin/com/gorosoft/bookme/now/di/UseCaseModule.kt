package com.gorosoft.bookme.now.di

import com.gorosoft.bookme.now.domain.usecase.HadTutorialUseCase
import com.gorosoft.bookme.now.domain.usecase.IsLoggedInUseCase
import com.gorosoft.bookme.now.domain.usecase.LoginUseCase
import com.gorosoft.bookme.now.domain.usecase.LoginWithTokenUseCase
import com.gorosoft.bookme.now.domain.usecase.SetHadTutorialUseCase
import org.koin.dsl.module

fun useCaseModule() = module {
    factory { HadTutorialUseCase(defaults = get()) }
    factory { IsLoggedInUseCase(holder = get()) }
    factory {
        LoginUseCase(
            profileRepository = get(),
        )
    }
    factory { SetHadTutorialUseCase(defaults = get()) }
    factory { LoginWithTokenUseCase(profileRepository = get()) }
}
