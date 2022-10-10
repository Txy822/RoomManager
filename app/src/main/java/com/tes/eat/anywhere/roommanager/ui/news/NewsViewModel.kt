package com.tes.eat.anywhere.roommanager.ui.news

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tes.eat.anywhere.roommanager.data.EmployeeApi
import com.tes.eat.anywhere.roommanager.data.NewsApi
import com.tes.eat.anywhere.roommanager.data.model.news.News
import com.tes.eat.anywhere.roommanager.data.model.room.Room
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(
    private val api: NewsApi
): ViewModel() {

    private val _news = MutableLiveData<News>()
    val news: LiveData<News> = _news
    // API call to fetch the data
    fun getNews() {
        CoroutineScope(Dispatchers.Main).launch {
            val newsList = api.getNews()
            // verify if the response was successful
            if (newsList.isSuccessful) {
                _news.postValue(newsList.body())

            } else {
                _news.postValue(News())
            }
        }
    }

}