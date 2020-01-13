package com.saumya.retroliveroom.Activity

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.saumya.retroliveroom.Model.DeveloperModel

class MainActivityViewModel : ViewModel() {

/*create an instance of Repository Class*/

    lateinit var mainActivityRepository: MainActivityRepository

    init {
        mainActivityRepository = MainActivityRepository()
    }

    fun getAllDeveloperList(): LiveData<List<DeveloperModel>>? {

        return mainActivityRepository.getDevelopers()
    }


    fun getDevelopersFromAPIAndStoreInDB() {

        mainActivityRepository.CallApiAndStoreInDB()

    }
}