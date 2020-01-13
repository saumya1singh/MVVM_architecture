package com.saumya.retroliveroom.Activity

import android.content.Context
import android.net.ConnectivityManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.saumya.retroliveroom.DeveloperRecyclerViewAdapter
import com.saumya.retroliveroom.Model.DeveloperModel
import com.saumya.retroliveroom.R

class MainActivity : AppCompatActivity() {

/*an instance of viewmodel class is created here*/

    lateinit var developerRecyclerView:RecyclerView
    lateinit var mainActivityViewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        developerRecyclerView=findViewById(R.id.developersRecyclerView)

        mainActivityViewModel=ViewModelProviders.of(this).get(MainActivityViewModel::class.java)

        if (isNetworkConnected(this)){
        mainActivityViewModel.getDevelopersFromAPIAndStoreInDB()
        }
        else{
            Toast.makeText(this,"No internet found. Showing cached list in the view",Toast.LENGTH_LONG).show()
        }

            mainActivityViewModel.getAllDeveloperList()?.observe(this, Observer<List<DeveloperModel>> { developersList->
                    Log.e("OBSERVABLE",developersList.toString())
                    setUpDeveloperRecyclerView(developersList)
                })


    }
    fun isNetworkConnected(context: Context): Boolean {
        val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork = cm.activeNetworkInfo
        return activeNetwork != null && activeNetwork.isConnectedOrConnecting
    }

    fun setUpDeveloperRecyclerView(developers: List<DeveloperModel>){
        Log.e("RECYCLER",developers.toString())
        val developerRecyclerViewAdapter=DeveloperRecyclerViewAdapter(this,developers)
        developerRecyclerView.adapter=developerRecyclerViewAdapter
        developerRecyclerView.layoutManager=LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        developerRecyclerView.setHasFixedSize(true)

    }

}
