package com.tes.eat.anywhere.roommanager.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Smart and Simple Room Management System"
    }
    val text: LiveData<String> = _text
}