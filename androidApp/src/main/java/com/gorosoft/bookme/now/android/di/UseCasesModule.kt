package com.gorosoft.bookme.now.android.di

import com.gorosoft.bookme.now.domain.repository.ProfileRepositoryProtocol
import com.gorosoft.bookme.now.domain.usecase.HadTutorialUseCase
import com.gorosoft.bookme.now.domain.usecase.IsLoggedInUseCase
import com.gorosoft.bookme.now.domain.usecase.LoginUseCase
import com.gorosoft.bookme.now.domain.usecase.SetHadTutorialUseCase
import com.gorosoft.bookme.now.managers.KMMUserDefaults
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object UseCasesModule {

    @Provides
    fun provideHadTutorialUseCase(defaults: KMMUserDefaults): HadTutorialUseCase {
        return HadTutorialUseCase(defaults = defaults)
    }

    @Provides
    fun provideSetHadTutorialUseCase(defaults: KMMUserDefaults): SetHadTutorialUseCase {
        return SetHadTutorialUseCase(defaults = defaults)
    }

    @Provides
    fun provideLoginUseCase(repository: ProfileRepositoryProtocol): LoginUseCase {
        return LoginUseCase(profileRepository = repository)
    }

    @Provides
    fun provideIsLoggedInUseCase(defaults: KMMUserDefaults): IsLoggedInUseCase {
        return IsLoggedInUseCase(defaults = defaults)
    }
}
