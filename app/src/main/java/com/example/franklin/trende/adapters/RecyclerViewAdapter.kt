package com.example.franklin.trende.adapters

import android.content.Context
import android.content.Intent
import android.support.v4.content.ContextCompat.startActivity
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.franklin.trende.R
import com.example.franklin.trende.activities.AnimeActivity


import com.example.franklin.trende.models.Anime

class RecyclerViewAdapter(ctx: Context, mData: List<Anime>) : RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>() {
    val mContext = ctx
    val mData = mData
    val option = RequestOptions().centerCrop().placeholder(R.drawable.loading_shape).error(R.drawable.loading_shape)


    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): MyViewHolder {
        val view = LayoutInflater.from(mContext).inflate(R.layout.anime_row_item, parent, false)
        val viewHolder = MyViewHolder(view)



        return viewHolder
    }

    override fun getItemCount(): Int {
        return mData.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, positon: Int) {


        holder.tv_name.text = mData[positon].name
//        holder.tv_rating.text = mData[positon].rating
//        holder.tv_studio.text = mData[positon].studio
//        holder.tv_category.text = mData[positon].categorie
        holder.itemView.setOnClickListener {



                val i = Intent(mContext,AnimeActivity::class.java)
                i.putExtra("anime_name", mData[positon].name)
                i.putExtra("anime_description", mData[positon].description)
                i.putExtra("anime_studio", mData[positon].studio)
                i.putExtra("anime_category", mData[positon].categorie)
                i.putExtra("anime_nb_episode", mData[positon].nb_episode)
                i.putExtra("anime_img", mData[positon].image_url)
                i.putExtra("anime_rating", mData[positon].rating)


                mContext.startActivity(i)


        }

        Glide.with(mContext).load(mData[positon].image_url).apply(option).into(holder.img_thumbnail)
    }


    class MyViewHolder(v: View) : RecyclerView.ViewHolder(v) {


        val tv_name = itemView.findViewById<TextView>(R.id.anime_name)
        val tv_category = itemView.findViewById<TextView>(R.id.categorie)
        val tv_rating = itemView.findViewById<TextView>(R.id.rating)
        val tv_studio = itemView.findViewById<TextView>(R.id.studio)
        val img_thumbnail = itemView.findViewById<ImageView>(R.id.thumbnail)
        val container = itemView.findViewWithTag<LinearLayout>(R.id.container)

    }

}