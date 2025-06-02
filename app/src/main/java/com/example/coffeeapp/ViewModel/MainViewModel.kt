package com.example.coffeeapp.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.coffeeapp.Domain.BannerModel
import com.example.coffeeapp.Repository.MainRpository

class MainViewModel: ViewModel() {
    private val repository=MainRpository()

    fun loadBanner():LiveData<MutableList<BannerModel>>{
        return repository.loadBanner()
    }
}