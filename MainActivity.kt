package com.walker.aula5modulo1androidavancado

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ListView

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: TaskAdapter
    private val taskViewModel: TaskViewModel = TaskViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = TaskAdapter(this, taskViewModel.tasks.value ?: listOf())

        val tasksList = findViewById<ListView>(R.id.tasksList)
        tasksList.adapter = adapter

        taskViewModel.tasks.observe(this) {
            adapter.notifyDataSetChanged()
        }

        tasksList.setOnItemLongClickListener { _, _, position, _ ->
            // Deletar a task
            taskViewModel.deleteTask(position)
            true
        }

        tasksList.setOnItemClickListener { _, _, position, _ ->
            // Atualizar o isCompleted da task (checked ou não)
            taskViewModel.updateTask(position)
        }

        findViewById<Button>(R.id.button).setOnClickListener {
            // Adicionar nova tarefa
            val newTaskModel = TaskModel("Nova Tarefa", "Descricao da Nova tarefa", false)
            taskViewModel.addTask(newTaskModel)
        }

    }
}