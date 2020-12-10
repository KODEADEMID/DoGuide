package kodeA.doguide.ToDoList.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import kodeA.doguide.ToDoList.models.TaskModel

@Dao
interface TaskDao {
    @Query("select * from todo_table")
    fun getAllDataFromDatabase(): List<TaskModel>

    @Insert
    fun addTask(item: TaskModel)

    @Delete
    fun deleteTask(item: TaskModel)

}