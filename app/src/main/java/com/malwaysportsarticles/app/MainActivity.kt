package com.malwaysportsarticles.app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.malwaysportsarticles.app.databinding.ActivityMainBinding
import com.malwaysportsarticles.app.mladapter.MalwaysSportsAdapter
import com.malwaysportsarticles.app.mlsportsapi.MalwaysRetrofitInstance
import com.malwaysportsarticles.app.mlsportsscreen.MalwaysDetail
import com.malwaysportsarticles.app.mlsportsviewmodel.MalwaysViewModel
import com.walleyfreshnews.app.wnewsdata.Articles
import com.walleyfreshnews.app.wnewsdata.MalwaysSportsResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity(), MalwaysSportsAdapter.Listener {
    private lateinit var binding: ActivityMainBinding

    private val mainviewModel : MalwaysViewModel by viewModels()
    private lateinit var adapter: MalwaysSportsAdapter
    private val ids = CoroutineScope(Dispatchers.IO + Job())
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        kdwewfef()
        odpsdsd()
        mainviewModel.opsdsd.observe(this,{
            adapter.submitList(it)
        })
    }


    private fun kdwewfef() = with(binding){
        adapter = MalwaysSportsAdapter(this@MainActivity)
        odsuidsf.layoutManager = LinearLayoutManager(this@MainActivity,LinearLayoutManager.VERTICAL,false)
        odsuidsf.adapter = adapter

    }

    private fun odpsdsd() = with(binding){
        ids.launch {
            val data =  MalwaysRetrofitInstance.api.jfsfsdf()

            data.enqueue(object : Callback<MalwaysSportsResponse> {
                override fun onResponse(
                    call: Call<MalwaysSportsResponse>,
                    response: Response<MalwaysSportsResponse>
                ) {
                    mainviewModel.opsdsd.postValue(response.body()?.articles)
                    progressBar.visibility = View.GONE

                }

                override fun onFailure(call: Call<MalwaysSportsResponse>, t: Throwable) {

                }

            })

        }



    }

    override fun onClickItem(item: Articles) {
        startActivity(
            Intent(this, MalwaysDetail::class.java).putExtra("spmdata",item)
        )
    }
}