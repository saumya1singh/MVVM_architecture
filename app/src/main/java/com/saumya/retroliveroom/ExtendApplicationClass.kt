package com.saumya.retroliveroom

import android.app.Application
import androidx.room.Room
import com.saumya.retroliveroom.DataBase.DeveloperDatabase

class ExtendApplicationClass : Application() {


/*we can directly use the database since it is now static.
* Companion object is about making stuff global
* */


    companion object {
        var database: DeveloperDatabase? = null
    }

    override fun onCreate() {
        super.onCreate()
        database = Room.databaseBuilder(applicationContext, DeveloperDatabase::class.java, "developer_db")
            .fallbackToDestructiveMigration().build()

    }

}