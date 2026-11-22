package com.saydlawy.falaky

import android.content.Context
import androidx.room.Room
import com.saydlawy.falaky.core.database.FalakyDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Provides
    @Singleton
    fun database(@ApplicationContext context: Context): FalakyDatabase =
        // No destructive fallback: every schema change needs a real migration.
        Room.databaseBuilder(context, FalakyDatabase::class.java, FalakyDatabase.NAME).build()
}
