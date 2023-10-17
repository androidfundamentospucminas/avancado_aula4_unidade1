package com.walker.aula5modulo1androidavancado

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TaskViewModel: ViewModel() {

    private val tasks_: MutableLiveData<MutableList<TaskModel>> = MutableLiveData(mutableListOf())
    val tasks: LiveData<MutableList<TaskModel>> = tasks_

    init {
        addTask(TaskModel("Tarefa 1", "Descricao da Tarefa 1", false))
        addTask(TaskModel("Tarefa 2", "Descricao da Tarefa 2", true))
        addTask(TaskModel("Tarefa 3", "Descricao da Tarefa 3", false))
    }

    fun addTask(task: TaskModel) {
        val currentTasks = tasks_.value ?: mutableListOf()
        currentTasks.add(task)
        tasks_.value = currentTasks
    }

    fun updateTask(position: Int) {
        val currentTasks = tasks_.value ?: mutableListOf()
        currentTasks[position].isCompleted = !currentTasks[position].isCompleted
        tasks_.value = currentTasks
    }

    fun deleteTask(position: Int) {
        val currentTasks = tasks_.value ?: mutableListOf()
        currentTasks.remove(currentTasks[position])
        tasks_.value = currentTasks
    }

}