package fbo.costa.thespiritsbook.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import fbo.costa.thespiritsbook.repository.MainRepository
import fbo.costa.thespiritsbook.repository.RetrofitDataSource
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
abstract class RepositoryModule {

    @Singleton
    @Binds
    abstract fun provideMainRepository(
        apiDataSource: RetrofitDataSource
    ): MainRepository
}
