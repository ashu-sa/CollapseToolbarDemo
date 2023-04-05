package com.ashu.fooddeliverydemo.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.ashu.fooddeliverydemo.R
import com.ashu.fooddeliverydemo.data.Item
import com.ashu.fooddeliverydemo.data.VendorsItem
import com.bumptech.glide.Glide

class RetrofitAdapter(var list:ArrayList<Item>): RecyclerView.Adapter<RetrofitAdapter.MyViewHolder>() {


    inner class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val name: TextView = itemView.findViewById(R.id.vendor_name)
        val images: ImageView = itemView.findViewById(R.id.vendor_image)
        val description: TextView = itemView.findViewById(R.id.vendor_description)
    }
//    private val diffCallBack = object : DiffUtil.ItemCallback<VendorsItem>(){
//        override fun areItemsTheSame(oldItem: VendorsItem, newItem: VendorsItem): Boolean {
//            return oldItem.vendor_category_id == newItem.vendor_category_id
//        }
//
//        override fun areContentsTheSame(oldItem: VendorsItem , newItem: VendorsItem): Boolean {
//            return oldItem == newItem
//        }
//
//    }
//
//    val differ= AsyncListDiffer(this,diffCallBack)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.vendor_item_layout,parent,false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = list[position]
        holder.name.text = currentItem.name
        holder.description.text = currentItem.description
        Glide.with(holder.itemView).load(currentItem.icon).into(holder.images)

    }

    override fun getItemCount(): Int {
        return list.size
    }

}