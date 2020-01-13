package com.saumya.retroliveroom.DataBase

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.saumya.retroliveroom.Model.DeveloperModel


@Dao
interface DeveloperDao {


    @Query("SELECT * FROM Developers")
    fun getAllDevelopers(): LiveData<List<DeveloperModel>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertDevelopers(developerList: List<DeveloperModel>)


/*Wrapping the data in livedata because we will store the data in DB, using viewmodel will observe ad react to any change in DB*/


    @Query("DELETE FROM Developers")
    fun deleteDevelopers()

}