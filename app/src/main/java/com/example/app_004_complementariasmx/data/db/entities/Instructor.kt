package com.example.app_004_complementariasmx.data.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Instructor(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String,
    val sex: String,
    @ColumnInfo(defaultValue = "false")
    val isActive: Boolean,
    val idRace: Int
)