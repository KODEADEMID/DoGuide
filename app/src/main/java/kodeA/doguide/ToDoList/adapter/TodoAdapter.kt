package kodeA.doguide.ToDoList.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageButton
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import kodeA.doguide.R
import kodeA.doguide.ToDoList.listeners.OnItemClicked
import kodeA.doguide.ToDoList.models.TaskModel

class TodoAdapter(var context: Context, var itemClicked: OnItemClicked): RecyclerView.Adapter<TodoAdapter.Holder>() {

    var list = arrayListOf<TaskModel>()


    fun setItem(items: ArrayList<TaskModel>) {
        this.list.clear()
        this.list.addAll(items)
        notifyDataSetChanged()
    }

    fun addItem(item: TaskModel) {
        list.add(item)
        notifyDataSetChanged()
    }

    fun deleteItem(position: Int) {
        list.removeAt(position)
        notifyItemRemoved(position)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false)
      return Holder(itemView)
    }

    override fun getItemCount(): Int {
      return list.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
      holder.edt_task.text = list[position].task
    }

    inner class Holder(itemView: View):RecyclerView.ViewHolder(itemView){
        val edt_task = itemView.findViewById<AppCompatTextView>(R.id.item_task)
        val btn_delete = itemView.findViewById<AppCompatImageButton>(R.id.btn_delete)

        init {
            btn_delete.setOnClickListener{
                itemClicked.onClick(adapterPosition)
            }
        }
    }

}