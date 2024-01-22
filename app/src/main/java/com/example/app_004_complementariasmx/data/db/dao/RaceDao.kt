package com.example.app_004_complementariasmx.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.app_004_complementariasmx.data.db.entities.Race

@Dao
interface RaceDao {

    @Insert
    suspend fun insertRace(race: Race)

    @Query("SELECT * FROM race")
    fun getAllRaces(): List<Race>
}
