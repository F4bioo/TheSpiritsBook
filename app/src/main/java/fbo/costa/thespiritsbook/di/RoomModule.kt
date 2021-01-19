package fbo.costa.thespiritsbook.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import fbo.costa.thespiritsbook.data.room.AppDatabase
import fbo.costa.thespiritsbook.data.room.QueAnsDao
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object RoomModule {

    @Singleton
    @Provides
    fun provideAppDatabase(
        @ApplicationContext context: Context
    ): AppDatabase {
        return Room.databaseBuilder(
            context, AppDatabase::class.java,
            AppDatabase.DATABASE_NAME
        ).fallbackToDestructiveMigration().build()
    }

    @Singleton
    @Provides
    fun provideQueAnsDao(
        appDatabase: AppDatabase
    ): QueAnsDao {
        return appDatabase.queAnsDao()
    }
}
