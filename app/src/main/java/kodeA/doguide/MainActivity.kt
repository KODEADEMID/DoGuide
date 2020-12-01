package kodeA.doguide

import android.content.ContentValues
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.content.contentValuesOf
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var myDB = MyDB(applicationContext)
        var db =myDB.readableDatabase
        var rs = db.rawQuery("SELECT * FROM  ANIMALS", null)

        if(rs.moveToNext())
        {
            Toast.makeText(applicationContext, rs.getString(1), Toast.LENGTH_LONG).show()
        }
        button.setOnClickListener(){
            var cv = ContentValues()
            cv.put("NICKNAME", editTextTextPersonName.text.toString())
            cv.put("BREED", editTextTextPersonName.text.toString())
            db.insert("ANIMALS", null, cv)

            editTextTextPersonName.setText("")
            editTextTextPersonName2.setText("")
            editTextTextPersonName.requestFocus()
        }
    }
}