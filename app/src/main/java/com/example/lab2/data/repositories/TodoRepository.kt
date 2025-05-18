package com.example.lab2.data.repository

import com.example.lab2.data.local.TodoDao
import com.example.lab2.data.local.TodoEntity
import com.example.lab2.domain.model.Todo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class TodoRepository(
    private val todoDao: TodoDao
) {
    fun getAllTodos(): Flow<List<Todo>> {
        return todoDao.getAllTodos().map { entities ->
            entities.map { it.toDomain() }
        }
    }

    suspend fun addTodo(todo: Todo) {
        todoDao.insertTodo(TodoEntity.fromDomain(todo))
    }

    suspend fun toggleTodoStatus(id: Int, completed: Boolean) {
        todoDao.updateTodoStatus(id, completed)
    }

    suspend fun deleteTodo(todo: Todo) {
        todoDao.deleteTodo(TodoEntity.fromDomain(todo))
    }
}