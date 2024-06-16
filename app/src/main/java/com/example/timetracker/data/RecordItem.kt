package com.example.timetracker.data

import java.sql.Date
import java.sql.Time

data class RecordItem(
    val id: Int,
    val title: String,
    val category: String,
    val date: String,
    val time: String
)
