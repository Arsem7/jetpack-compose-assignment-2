package com.example.lab2.domain.model

data class Todo(
    val id: Int = 0,
    val title: String,
    val completed: Boolean = false
)