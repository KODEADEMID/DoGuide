package kodeA.doguide.ToDoList.screens

import kodeA.doguide.ToDoList.models.TaskModel

class MainPresenter : MainContract.Actions {

    var _views: MainContract.Views? = null
    //var list = arrayListOf<TaskModel>()

    constructor(_views: MainContract.Views?) {
        this._views = _views
        initScreen()
    }


    override fun initScreen() {
        _views?.setupViews()
        _views?.setupListeners()
        fetchAllTasksFromDatabase()
    }

    override fun addTaskToRecyclerView() {
        _views?.addTaskToRecyclerView(_views?.getTask()!!)
    }

    override fun addTaskToDatabase() {
        _views?.addTaskToDatabase(_views?.getTask()!!)
    }

    override fun fetchAllTasksFromDatabase() {
        _views?.addTaskToRecyclerViewList(_views?.getAllTasksFromDatabase() as ArrayList)
    }



}