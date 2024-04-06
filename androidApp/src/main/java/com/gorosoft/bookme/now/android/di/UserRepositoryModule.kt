package com.gorosoft.bookme.now.android.di

import com.gorosoft.bookme.now.data.network.KtorManager
import com.gorosoft.bookme.now.data.network.datasource.UserRemoteDataSource
import com.gorosoft.bookme.now.data.repositories.UserRepositoryImpl
import com.gorosoft.bookme.now.domain.repository.UserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class UserRepositoryModule {

    @Provides
    fun provideUserRemoteDataSource(): UserRemoteDataSource {
        return UserRemoteDataSource(client = KtorManager.client)
    }

    @Provides
    fun provideUserRepository(remote: UserRemoteDataSource): UserRepository {
        return UserRepositoryImpl(remote = remote)
    }
}
