package com.gorosoft.bookme.now.android.di

import com.gorosoft.bookme.now.data.database.RealmManager
import com.gorosoft.bookme.now.data.database.datasource.ProfileCacheDataSource
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
class ProfileRepositoryModule {

    @Provides
    fun provideProfileRemoteDataSource(): ProfileRemoteDataSource {
        return ProfileRemoteDataSource(client = KtorManager.client)
    }

    @Provides
    fun provideProfileCacheDataSource(): ProfileCacheDataSource {
        return ProfileCacheDataSource(realm = RealmManager.realm)
    }

    @Provides
    fun provideProfileRepository(
        remote: ProfileRemoteDataSource,
        cacheDataSource: ProfileCacheDataSource
    ): ProfileRepositoryProtocol {
        return ProfileRepository(remote = remote, cache = cacheDataSource)
    }
}
