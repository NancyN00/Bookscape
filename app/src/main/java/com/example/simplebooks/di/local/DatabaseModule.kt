package com.example.simplebooks.di.local

import android.content.Context
import androidx.room.Room
import com.example.simplebooks.data.FavoriteBooksDatabase
import com.example.simplebooks.data.local.FavoriteBookDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**Provide the database and dao **/

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext context: Context
    ): FavoriteBooksDatabase {
        return Room.databaseBuilder(
            context.applicationContext,
            FavoriteBooksDatabase::class.java,
            "favorite_books_db"
        ).build()
    }

    @Provides
  //  @Singleton
    fun provideFavoriteBookDao(database: FavoriteBooksDatabase): FavoriteBookDao {
        return database.favoriteBookDao()
    }

}