package com.gorosoft.bookme.now.android.di

import com.gorosoft.bookme.now.data.network.KtorManager
import com.gorosoft.bookme.now.data.network.datasource.ProfileRemoteDataSource
import com.gorosoft.bookme.now.data.repositories.ProfileRepository
import com.gorosoft.bookme.now.domain.repository.ProfileRepositoryProtocol
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class UserRepositoryModule {

    @Provides
    fun provideUserRemoteDataSource(): ProfileRemoteDataSource {
        return ProfileRemoteDataSource(client = KtorManager.client)
    }

    @Provides
    fun provideUserRepository(remote: ProfileRemoteDataSource): ProfileRepositoryProtocol {
        return ProfileRepository(remote = remote)
    }
}
