package com.mehmetalivargun.odev1.ui.login


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel



class LoginViewModel() : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "still in building progress"
    }
    val text: LiveData<String> = _text

}