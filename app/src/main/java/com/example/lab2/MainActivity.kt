package com.example.lab2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.lab2.data.local.TodoDatabase
import com.example.lab2.data.repository.TodoRepository
import com.example.lab2.presentation.TodoViewModel
import com.example.lab2.presentation.TodoViewModelFactory
import com.example.lab2.presentation.screens.TodoScreen
import com.example.lab2.ui.theme.Lab2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val database = TodoDatabase.getDatabase(applicationContext)
        val repository = TodoRepository(database.todoDao())
        val factory = TodoViewModelFactory(repository)

        setContent {
            Lab2Theme {
                val viewModel: TodoViewModel = viewModel(factory = factory)
                TodoScreen(viewModel = viewModel)
            }
        }
    }
}