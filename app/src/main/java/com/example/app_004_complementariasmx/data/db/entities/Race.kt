package com.example.app_004_complementariasmx.data.db.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Race(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val race: String,
    val image: String
)