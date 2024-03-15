package com.gorosoft.bookme.now.android.di.view_model_scope

import com.gorosoft.bookme.now.domain.use_case.CreateProfileIsValidUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object UseCasesModule {

    @Provides
    fun createProfileIsValidUseCase(): CreateProfileIsValidUseCase = CreateProfileIsValidUseCase()
}
