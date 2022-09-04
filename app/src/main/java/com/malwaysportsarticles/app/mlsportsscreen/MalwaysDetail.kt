package com.malwaysportsarticles.app.mlsportsscreen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.malwaysportsarticles.app.databinding.ActivityDetailMalwayBinding
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import com.walleyfreshnews.app.wnewsdata.Articles
import java.lang.Exception

class MalwaysDetail : AppCompatActivity() {
    private lateinit var binding : ActivityDetailMalwayBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailMalwayBinding.inflate(layoutInflater)
        setContentView(binding.root)
        udsfsfds()
    }


    private fun udsfsfds() = with(binding){
        val hdsfsdfsdf = intent.getSerializableExtra("spmdata") as Articles
        kdsldsd.text = hdsfsdfsdf.title
        ldsdssdk.text = hdsfsdfsdf.description
        odpsd.text = hdsfsdfsdf.author
        Picasso.get().load(hdsfsdfsdf.urlToImage).into(mainImage,object :
            Callback {
            override fun onSuccess() {
                pbBar.visibility = View.GONE
            }

            override fun onError(e: Exception?) {

            }

        })
        odssd.setOnClickListener {
            finish()
        }
    }
}