package com.brins.translation.translation.model

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.support.annotation.NonNull


@Entity(tableName = "collection")
class dataSet {

    @ColumnInfo(name = "ID")
    @PrimaryKey(autoGenerate = true)
    @NonNull
    var mId: Int = 0

    @ColumnInfo(name = "sourcelan")
    var sourcelan : String? = null
    @ColumnInfo(name = "targetlan")
    var targetlan : String? = null
    @ColumnInfo(name = "origintext")
    var text : String? = null
    @ColumnInfo(name = "target")
    var target : String? = null
    @ColumnInfo(name = "time")
    var createtime : Long = 0

}