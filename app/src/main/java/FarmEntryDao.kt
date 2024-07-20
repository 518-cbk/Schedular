//import androidx.room.Dao
//import androidx.room.Delete
//import androidx.room.Insert
//import androidx.room.Query
//import androidx.room.Update
//
//@Dao
//interface FarmDao {
//
//    @Query("SELECT * FROM farms")
//    fun getAllFarms(): List<Farm>
//
//    @Insert
//    suspend fun insertFarm(farm: Farm)
//
//    @Delete
//    suspend fun deleteFarm(farm: Farm)
//
//    @Update
//    suspend fun updateFarm(farm: Farm)
//}
package com.dickbriabu.scheduler.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface FarmEntryDao {
    @Insert
    suspend fun insert(farmEntry: FarmEntry)

    @Query("SELECT * FROM farm_entries")
    suspend fun getAllEntries(): List<FarmEntry>
}