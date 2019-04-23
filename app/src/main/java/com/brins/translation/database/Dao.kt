package com.brins.translation.database

import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import com.brins.translation.model.dataSet

@android.arch.persistence.room.Dao
interface Dao {
    @Insert
    fun addCollection(collection : dataSet)

    @Query("select * from collection order by ID DESC")
    fun getCollection() : List<dataSet>

    @Query("select * from collection where sourcelan like :lan")
    fun getCollectionViaSource(lan : String): List<dataSet>

    @Query("delete from collection where time=:createtime")
    fun deleteViaTime(createtime : Long)

}