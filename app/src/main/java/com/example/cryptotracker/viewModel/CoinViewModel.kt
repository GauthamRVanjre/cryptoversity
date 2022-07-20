package com.example.cryptotracker.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.cryptotracker.network.Coins
import com.example.cryptotracker.network.RetrofitInstance
import kotlinx.coroutines.launch

class CoinViewModel(application: Application) : AndroidViewModel(application) {

    private val _coinsList = MutableLiveData<List<Coins>>()
    val coinsList : LiveData<List<Coins>> = _coinsList

    fun getCoins(){
        viewModelScope.launch {
            try{
                _coinsList.value = RetrofitInstance.api.getCoins()
            }
            catch (e:Exception){
                _coinsList.value = listOf()
            }
        }
    }

}