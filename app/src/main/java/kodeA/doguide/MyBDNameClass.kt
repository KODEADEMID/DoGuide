package kodeA.doguide

import android.provider.BaseColumns

object MyBDNameClass {
    const val TABLE_NAME = "MY_TABLE"
    const val COLUMN_NICKNAME = "nickname"
    const val COLUMN_BREED = "breed"
    const val DATABASE_VERSION =1
    const val DATABASE_NAME="InfoAnimal.db"

    const val CREATE_TABLE = "CREATE TABLE IF NOT EXIST $TABLE_NAME(" +
            "${BaseColumns._ID} INTEGER PRIMARY KEY, $COLUMN_NICKNAME TEXT," +
            "$COLUMN_BREED TEXT) "

   const val SQL_DELETE_TABLE = "DROP TABLE IF EXISTS $TABLE_NAME"
}