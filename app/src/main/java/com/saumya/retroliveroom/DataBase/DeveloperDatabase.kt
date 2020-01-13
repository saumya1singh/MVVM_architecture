package com.saumya.retroliveroom.DataBase

import androidx.room.Database
import androidx.room.RoomDatabase
import com.saumya.retroliveroom.Model.DeveloperModel


@Database(entities = [(DeveloperModel::class)], version= 1)
abstract class DeveloperDatabase: RoomDatabase() {


abstract fun developerDao():DeveloperDao

}