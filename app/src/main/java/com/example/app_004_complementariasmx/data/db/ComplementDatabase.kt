package com.example.app_004_complementariasmx.data.db


import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.app_004_complementariasmx.data.db.dao.RaceDao
import com.example.app_004_complementariasmx.data.db.dao.UserDao
import com.example.app_004_complementariasmx.data.db.entities.Race
import com.example.app_004_complementariasmx.data.db.entities.User


@Database(entities = [User::class, Race::class], version = 2, exportSchema = false)

abstract class ComplementDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao
    abstract fun raceDao(): RaceDao
}