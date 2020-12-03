package kodeA.doguide

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.provider.ContactsContract

class MyDBManager(val context: Context) {
    val myDBHelper = MyDBHelper(context)
    var db:SQLiteDatabase? = null

    fun openDB(){
        db=myDBHelper.writableDatabase
    }
    fun insertToDB(nickname: String, breed: String){
        val values = ContentValues().apply {
            put(MyBDNameClass.COLUMN_NICKNAME, nickname)
            put(MyBDNameClass.COLUMN_BREED, breed)
        }
        db?.insert(MyBDNameClass.TABLE_NAME, null, values)
    }
    fun readDBData() : ArrayList<String>{
        val dataList = ArrayList<String>()
        val cursor =db?.query(MyBDNameClass.TABLE_NAME, null, null, null, null, null, null)
        with(cursor){
            while (this?.moveToNext()!!){
                val dataText = cursor?.getString(cursor.getColumnIndex(MyBDNameClass.COLUMN_NICKNAME))
                dataList.add(dataText.toString())
            }
        }
        cursor?.close()
        return dataList
    }
    fun closeDB(){
        myDBHelper.close()

    }
}