package kodeA.doguide.ToDoList.screens

import android.view.MenuItem
import kodeA.doguide.ToDoList.models.TaskModel

interface MainContract {
    interface Views {
        fun setupViews()
        fun setupListeners()
        fun getTask(): TaskModel
        fun addTaskToDatabase(item: TaskModel)
        fun deleteTaskFromDatabase(item: TaskModel)
        fun getAllTasksFromDatabase(): List<TaskModel>
        fun addTaskToRecyclerViewList(list: ArrayList<TaskModel>)
        fun addTaskToRecyclerView(item: TaskModel)
       // fun addTaskList(list: ArrayList<TaskModel>)
       // fun addTask(model: TaskModel)
    }

    interface Actions {
        fun initScreen()
        fun addTaskToRecyclerView()
       fun addTaskToDatabase()
        fun fetchAllTasksFromDatabase()
    }
}