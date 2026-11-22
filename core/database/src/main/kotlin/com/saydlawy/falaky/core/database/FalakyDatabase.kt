package com.saydlawy.falaky.core.database

import androidx.room.Dao
import androidx.room.Database
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Query
import androidx.room.RoomDatabase
import androidx.room.Upsert

/** Tiny key/value table so schema version 1 exists from day one. Real tables arrive in stage 3. */
@Entity(tableName = "app_meta")
data class AppMetaEntity(
    @PrimaryKey val key: String,
    val value: String,
)

@Dao
interface AppMetaDao {
    @Upsert
    suspend fun put(meta: AppMetaEntity)

    @Query("SELECT value FROM app_meta WHERE `key` = :key")
    suspend fun get(key: String): String?
}

@Database(entities = [AppMetaEntity::class], version = 1, exportSchema = true)
abstract class FalakyDatabase : RoomDatabase() {
    abstract fun appMetaDao(): AppMetaDao

    companion object {
        const val NAME = "falaky.db"
    }
}
