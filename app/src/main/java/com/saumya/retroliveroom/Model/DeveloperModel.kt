package com.saumya.retroliveroom.Model

import androidx.room.Entity
import androidx.room.PrimaryKey

/*Response Class to get the response */

@Entity(tableName = "Developers")
data class DeveloperModel(

@PrimaryKey
var username:String,
var url:String,
var avatar:String

)