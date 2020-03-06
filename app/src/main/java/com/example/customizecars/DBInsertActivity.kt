package com.example.customizecars

import android.content.ContentValues
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView


class DBInsertActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dbinsert)
        val username = intent.getStringExtra("com.example.customizecars.USERNAME")
        val password = intent.getStringExtra("com.example.customizecars.PASSWORD")

        val dbHelper = AllDbHelper(this)
        val db = dbHelper.writableDatabase

        val values = ContentValues().apply {
            put(DBSchema.AccountsTable.Cols.ACCTNO, username)
            put(DBSchema.AccountsTable.Cols.PASSWORD, password)
        }
        val newRowId = db?.insert(DBSchema.AccountsTable.TABLENAME, null, values)

        findViewById<TextView>(R.id.textView5).apply {
            text = username

        }
    }
}
