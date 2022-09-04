package com.malwaysportsarticles.app.mladapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.malwaysportsarticles.app.R
import com.malwaysportsarticles.app.databinding.MalwaySportItemBinding
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import com.walleyfreshnews.app.wnewsdata.Articles
import java.lang.Exception

class MalwaysSportsAdapter(private val listener : Listener) : ListAdapter<Articles,MalwaysSportsAdapter.LeaguesHolder>(Comparator()) {
    class LeaguesHolder(view:View) : RecyclerView.ViewHolder(view) {

        private val binding = MalwaySportItemBinding.bind(view)

        fun setFootballItemInfo(item : Articles,listener : Listener) = with(binding){
           kdsldsd.text = item.title
            ldsdssdk.text = item.description
            Picasso.get().load(item.urlToImage).into(mainImage, object : Callback{
                override fun onSuccess() {
                    pbBar.visibility = View.GONE
                }

                override fun onError(e: Exception?) {
                }

            })

            itemView.setOnClickListener {
                listener.onClickItem(item)

            }

        }

    }

    class Comparator : DiffUtil.ItemCallback<Articles>() {
        override fun areItemsTheSame(oldItem: Articles, newItem: Articles): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Articles, newItem: Articles): Boolean {
            return oldItem == newItem
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LeaguesHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.malway_sport_item,parent,false)
        return LeaguesHolder(view)
    }

    override fun onBindViewHolder(holder: LeaguesHolder, position: Int) {
       holder.setFootballItemInfo(getItem(position),listener)
    }


    interface Listener {
       fun onClickItem(item:Articles)
    }
}