package com.walker.aula5modulo1androidavancado

data class TaskModel(
    var title: String,
    var description: String,
    var isCompleted: Boolean,
    var id: Int? = null
)