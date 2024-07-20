//package com.dickbriabu.scheduler
//
//import FarmDatabase
//import android.app.Application
//import androidx.room.Room
//
//// MyApplication.kt
//class MyApplication : Application() {
//
//    val database: FarmDatabase by lazy { FarmDatabase.getInstance(applicationContext) }
//
//    override fun onCreate() {
//        super.onCreate()
//        // Database initialization is now handled lazily, so we don't need to do anything here
//    }
//
//    // This function is no longer necessary, but you can keep it if other parts of your code use it
//    fun getFarmDatabase(): FarmDatabase {
//        return database
//    }
//}