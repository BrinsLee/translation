package com.brins.translation.translation.database

import android.arch.persistence.room.Room
import android.content.Context
import com.brins.translation.translation.model.dataSet

class CollectionDatabaseHelper (context: Context) {

    val appDatabase = Room.databaseBuilder(context, CollectionDatabase::class.java,"collection")
            .allowMainThreadQueries().build()

    companion object {
        @Volatile
        var INSTANCE: CollectionDatabaseHelper? = null

        fun getInstance(context: Context): CollectionDatabaseHelper {
            if (INSTANCE == null) {
                synchronized(CollectionDatabaseHelper::class) {
                    if (INSTANCE == null) {
                        INSTANCE = CollectionDatabaseHelper(context.applicationContext)
                    }
                }
            }
            return INSTANCE!!
        }
    }
    fun insert(collection:dataSet){

        appDatabase.dao().addCollection(collection)
    }

    fun getCollection () :ArrayList<dataSet>{
        return appDatabase.dao().getCollection() as ArrayList<dataSet>
    }

    fun getCollectionViaSource(source : String):ArrayList<dataSet>{
        return appDatabase.dao().getCollectionViaSource(source) as ArrayList<dataSet>
    }

    fun delete(dataset : dataSet){
        val time = dataset.createtime
        appDatabase.dao()
    }
}