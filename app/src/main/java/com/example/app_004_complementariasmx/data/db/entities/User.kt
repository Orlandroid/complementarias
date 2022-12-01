package com.example.app_004_complementariasmx.data.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val user: String,
    val password: String,
    val type: String,
    @ColumnInfo(defaultValue = "false")
    val isActive: Boolean
)