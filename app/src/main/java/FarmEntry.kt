//import androidx.room.ColumnInfo
//import androidx.room.Entity
//import androidx.room.PrimaryKey
//
//@Entity(tableName = "farms")
//data class Farm(
//    @PrimaryKey(autoGenerate = true)
//    val id: Int = 0,  // Changed to Int and added default value
//
//    @ColumnInfo(name = "farm_name")
//    val farmName: String?,
//
//    @ColumnInfo(name = "unique_id")
//    val uniqueId: Int?,
//
//    @ColumnInfo(name = "block")
//    val block: Int?,
//
//    @ColumnInfo(name = "bushes")
//    val bushes: Int?
//)
package com.dickbriabu.scheduler.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "farm_entries")
data class FarmEntry(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val farmName: String,
    val blockCount: Int,
    val bushesCount: Int
)
