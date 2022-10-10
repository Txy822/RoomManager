package com.tes.eat.anywhere.roommanager.model.remote.virginmoney

import com.tes.eat.anywhere.roommanager.model.data.people.People
import com.tes.eat.anywhere.roommanager.model.data.room.Room
import retrofit2.Response
import retrofit2.http.GET

interface EmployeeApi {//we do not have to any implementation

    @GET(PeopleApiDetails.PEOPLE) //to define type of request GET, POST, PUT
    suspend fun getPeople(): Response<People>

    @GET(PeopleApiDetails.ROOM) //to define type of request GET, POST, PUT
    suspend fun getRoom(): Response<Room>
}