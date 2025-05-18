package com.example.lab2.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.lab2.domain.model.Todo

@Entity(tableName = "todos")
data class TodoEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val title: String,
    val completed: Boolean
) {
    fun toDomain(): Todo = Todo(
        id = id,
        title = title,
        completed = completed
    )

    companion object {
        fun fromDomain(todo: Todo) = TodoEntity(
            id = todo.id,
            title = todo.title,
            completed = todo.completed
        )
    }
}