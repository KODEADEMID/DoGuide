package kodeA.doguide

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class MyDBHelper(context: Context): SQLiteOpenHelper(context, MyBDNameClass.TABLE_NAME, null, MyBDNameClass.DATABASE_VERSION ) {
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(MyBDNameClass.CREATE_TABLE)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
         db?.execSQL(MyBDNameClass.SQL_DELETE_TABLE)
        onCreate(db)
    }
}