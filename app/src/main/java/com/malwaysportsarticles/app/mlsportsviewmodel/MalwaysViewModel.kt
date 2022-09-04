package com.malwaysportsarticles.app.mlsportsviewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.walleyfreshnews.app.wnewsdata.Articles

class MalwaysViewModel : ViewModel() {
    val opsdsd = MutableLiveData<List<Articles>>()
}