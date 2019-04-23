package com.brins.translation.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.brins.translation.model.dataSet

@Database(entities = arrayOf(dataSet::class),version = 1,exportSchema = false)
abstract class CollectionDatabase : RoomDatabase(){
    abstract fun dao() : Dao
}