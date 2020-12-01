package kodeA.doguide

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class MyDB(context: Context): SQLiteOpenHelper(context, "ANIMALDB", null, 1) {
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("CREATE TABLE ANIMALS(ANIMALID INTEGER PRIMARY KEY AUTOINCREMENT, NICKNAME TEXT, BREED TEXT)")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }

}