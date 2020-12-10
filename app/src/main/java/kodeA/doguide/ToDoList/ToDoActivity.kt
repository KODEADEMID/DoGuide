package kodeA.doguide.ToDoList

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kodeA.doguide.R
import kodeA.doguide.ToDoList.adapter.TodoAdapter
import kodeA.doguide.ToDoList.db.TodoDatabase
import kodeA.doguide.ToDoList.listeners.OnItemClicked
import kodeA.doguide.ToDoList.models.TaskModel
import kodeA.doguide.ToDoList.screens.MainContract
import kodeA.doguide.ToDoList.screens.MainPresenter
import kotlinx.android.synthetic.main.activity_to_do.*
import kotlin.random.Random

class ToDoActivity : AppCompatActivity(), MainContract.Views {

    lateinit var presenter: MainPresenter
    lateinit var mAdapter: TodoAdapter
    lateinit var db: TodoDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_to_do)

            db = TodoDatabase.getInstance(this)
        presenter = MainPresenter(this)
    }

    override fun setupViews() {
        mAdapter = TodoAdapter(this, object : OnItemClicked{
            override fun onClick(position: Int) {
                db.taskDao().deleteTask(mAdapter.list[position])
                mAdapter.deleteItem(position)
            }
        })
        task_recycler.apply{
            layoutManager = LinearLayoutManager(this.context)
            adapter=mAdapter
        }

    }

    override fun setupListeners() {
        btn_add.setOnClickListener{
            val task = edit_write_task.text.toString()
            if(task.equals("")){
                Toast.makeText(this, "Напишите задачу", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            else{
                presenter.addTaskToRecyclerView()
                presenter.addTaskToDatabase()
                edit_write_task.setText("")
            }
        }
    }

    override fun getTask(): TaskModel {
        return TaskModel(Random.nextLong(), edit_write_task.text.toString())
    }

   override fun addTaskToDatabase(item: TaskModel) {
        db.taskDao().addTask(item)
    }

    override fun deleteTaskFromDatabase(item: TaskModel) {
        db.taskDao().deleteTask(item)
    }

    override fun getAllTasksFromDatabase(): List<TaskModel> {
         return db.taskDao().getAllDataFromDatabase()
    }

    override fun addTaskToRecyclerViewList(list: ArrayList<TaskModel>) {
        mAdapter.setItem(list)
    }

    override fun addTaskToRecyclerView(item: TaskModel) {
        mAdapter.addItem(item)
    }

}