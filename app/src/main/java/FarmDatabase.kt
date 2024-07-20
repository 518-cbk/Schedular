package com.dickbriabu.scheduler.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [FarmEntry::class], version = 1, exportSchema = false)
abstract class FarmDatabase : RoomDatabase() {

    abstract fun farmEntryDao(): FarmEntryDao

    companion object {
        @Volatile
        private var INSTANCE: FarmDatabase? = null

        fun getDatabase(context: Context): FarmDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    FarmDatabase::class.java,
                    "farm_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
