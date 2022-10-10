package com.tes.eat.anywhere.roommanager.ui.room

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tes.eat.anywhere.roommanager.model.remote.virginmoney.EmployeeApi
import com.tes.eat.anywhere.roommanager.model.data.room.Room
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RoomViewModel @Inject constructor(
//    private val api: RoomApi
    private val api: EmployeeApi
): ViewModel() {

    private val _room = MutableLiveData<Room>()
    val room: LiveData<Room> = _room
    // API call to fetch the data


    fun getRoom() {
        CoroutineScope(Dispatchers.Main).launch {
            val roomList = api.getRoom()
            // verify if the response was successful
            if (roomList.isSuccessful) {
                _room.postValue(roomList.body())
            } else {
                _room.postValue(Room())
            }
        }
    }

}