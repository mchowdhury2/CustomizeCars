package com.example.customizecars

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper


class AllDbHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    private val SQL_CREATE_ENTRIES =
        "CREATE TABLE ${DBSchema.AccountsTable.TABLENAME} (" +
                "${DBSchema.AccountsTable.Cols.ACCTNO} INTEGER PRIMARY KEY," +
                "${DBSchema.AccountsTable.Cols.NAME} TEXT," +
                "${DBSchema.AccountsTable.Cols.PASSWORD} TEXT)"

    private val SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS ${DBSchema.AccountsTable.TABLENAME}"


    override fun onCreate(db: SQLiteDatabase) {

        db.execSQL(SQL_CREATE_ENTRIES)
    }
    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        // This database is only a cache for online data, so its upgrade policy is
        // to simply to discard the data and start over
        db.execSQL(SQL_DELETE_ENTRIES)
        onCreate(db)
    }
    override fun onDowngrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        onUpgrade(db, oldVersion, newVersion)
    }
    companion object {
        // If you change the database schema, you must increment the database version.
        const val DATABASE_VERSION = 1
        const val DATABASE_NAME = "CustomizeCars.db"
    }
}