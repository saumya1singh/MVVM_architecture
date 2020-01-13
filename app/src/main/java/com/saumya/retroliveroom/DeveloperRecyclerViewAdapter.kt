package com.saumya.retroliveroom

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.saumya.retroliveroom.Model.DeveloperModel
import com.squareup.picasso.Picasso

import kotlinx.android.synthetic.main.each_row.view.*

class DeveloperRecyclerViewAdapter(_context: Context, _developerList: List<DeveloperModel>) :
    RecyclerView.Adapter<DeveloperRecyclerViewAdapter.DeveloperViewHolder>() {

    val context=_context
    val developerList=_developerList

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): DeveloperRecyclerViewAdapter.DeveloperViewHolder {

        val view = LayoutInflater.from(context).inflate(R.layout.each_row, parent, false)
        return DeveloperViewHolder(view)
    }

    override fun getItemCount(): Int {
        return developerList.size
    }

    override fun onBindViewHolder(
        holder: DeveloperRecyclerViewAdapter.DeveloperViewHolder,
        position: Int
    ) {
        val current = developerList[position]
        with(holder.itemView) {
            developer_name.text = current.username
            developer_link.text = current.url
            Picasso.get().load(current.avatar).into(developer_image)

        }

    }

    class DeveloperViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {


    }

}