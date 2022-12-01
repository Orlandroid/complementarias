package com.example.app_004_complementariasmx.data.db.dao

import androidx.room.*
import com.example.app_004_complementariasmx.data.db.entities.User


@Dao
interface UserDao {

    @Insert
    suspend fun insertUser(user: User)

    @Query("SELECT * FROM USER")
    fun getAllAppointment(): List<User>

}