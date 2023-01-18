package com.turun.retrofit840

import android.content.Context
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.row_items.view.*

class MyAdapter(val context: Context, val userList:List<MyDataItem>):
RecyclerView.Adapter<MyAdapter.ViewHolder>(){
    class ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView) {

       // var AM:TextView
    //    var Depth:TextView
      //  var ID:TextView
     //   var LastUpdate:TextView
     //   var Latitude:TextView
      //  var Longitude:TextView
     //   var Magnitude:TextView
        var MagnitudeType:TextView
        var MapImageList:ImageView
        var Region:TextView
        var Time:TextView



        init {
            Region= itemView.regionList
            Time=itemView.timeList
            MagnitudeType=itemView.magnitudeTypeList
            MapImageList= itemView.mapImageList

        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        var itemView= LayoutInflater.from(context).inflate(R.layout.row_items,parent,false)
        return ViewHolder(itemView)


    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.Region.text= userList[position].Region.toString()
        holder.Time.text= userList[position].Time.toString()
        holder.MagnitudeType.text= userList[position].MagnitudeType.toString()


        //mapimage glide



        Glide.with(holder.MapImageList)
            .load(userList[position].MapImage)
            .circleCrop()
            .placeholder(R.drawable.ic_launcher_foreground)
            .error(R.drawable.ic_launcher_background)
            .fallback(R.drawable.ic_launcher_background)
            .into(holder.MapImageList)

    }

    override fun getItemCount(): Int {
        return userList.size
    }
}