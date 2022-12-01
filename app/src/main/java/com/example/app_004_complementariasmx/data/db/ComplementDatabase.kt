package com.example.app_004_complementariasmx.data.db


import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.app_004_complementariasmx.data.db.dao.RaceDao
import com.example.app_004_complementariasmx.data.db.dao.UserDao
import com.example.app_004_complementariasmx.data.db.entities.User


@Database(entities = [User::class, RaceDao::class], version = 1, exportSchema = false)

abstract class ComplementDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao
    abstract fun raceDao(): RaceDao
}