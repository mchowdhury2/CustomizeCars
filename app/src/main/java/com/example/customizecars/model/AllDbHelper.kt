package com.example.customizecars.model

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper


class AllDbHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    private val SQL_CREATE_ACCOUNT =
        "CREATE TABLE ${DBSchema.AccountsTable.TABLENAME} (" +
                "${DBSchema.AccountsTable.Cols.ACCTNO} INTEGER PRIMARY KEY AUTOINCREMENT," +
                "${DBSchema.AccountsTable.Cols.NAME} TEXT," +
                "${DBSchema.AccountsTable.Cols.PASSWORD} TEXT)"

    private val SQL_DELETE_ACCOUNT = "DROP TABLE IF EXISTS ${DBSchema.AccountsTable.TABLENAME}"

    private val SQL_CREATE_USER =
        "CREATE TABLE ${DBSchema.UsersTable.TABLENAME} (" +
                "${DBSchema.UsersTable.Cols.NAME} TEXT," +
                "${DBSchema.UsersTable.Cols.ADDRESS} TEXT," +
                "${DBSchema.UsersTable.Cols.PHONE} TEXT," +
                "${DBSchema.UsersTable.Cols.EMAIL} TEXT," +
                "${DBSchema.UsersTable.Cols.USERACCTNO} INTEGER PRIMARY KEY AUTOINCREMENT)"

    private val SQL_DELETE_USER = "DROP TABLE IF EXISTS ${DBSchema.UsersTable.TABLENAME}"

    private val SQL_CREATE_REVIEW =
        "CREATE TABLE ${DBSchema.ReviewsTable.TABLENAME} (" +
                "${DBSchema.ReviewsTable.Cols.YEAR} TEXT," +
                "${DBSchema.ReviewsTable.Cols.MAKE} TEXT," +
                "${DBSchema.ReviewsTable.Cols.MODEL} TEXT," +
                "${DBSchema.ReviewsTable.Cols.INTDASHCOLOR} TEXT," +
                "${DBSchema.ReviewsTable.Cols.INTSCREEN} TEXT," +
                "${DBSchema.ReviewsTable.Cols.INTSUNROOF} TEXT," +
                "${DBSchema.ReviewsTable.Cols.INTGPS} TEXT," +
                "${DBSchema.ReviewsTable.Cols.EXTWHEEL} TEXT," +
                "${DBSchema.ReviewsTable.Cols.EXTBUMPERS} TEXT," +
                "${DBSchema.ReviewsTable.Cols.EXTENGINE} TEXT," +
                "${DBSchema.ReviewsTable.Cols.LOCATION} TEXT," +
                "${DBSchema.ReviewsTable.Cols.USERACCTNO} INTEGER," +
                "FOREIGN KEY (${DBSchema.ReviewsTable.Cols.USERACCTNO}) REFERENCES ${DBSchema.UsersTable.TABLENAME} (${DBSchema.UsersTable.Cols.USERACCTNO}))"

    private val SQL_DELETE_REVIEW = "DROP TABLE IF EXISTS ${DBSchema.ReviewsTable.TABLENAME}"

//    private val SQL_CREATE_CUSTOMIZE =
//        "CREATE TABLE ${DBSchema.CustomizesTable.TABLENAME} (" +
//                "${DBSchema.CustomizesTable.Cols.SAVEID} INTEGER PRIMARY KEY," +
//                "${DBSchema.CustomizesTable.Cols.CUSACCTNO} INTEGER)"
//
//    private val SQL_DELETE_CUSTOMIZE = "DROP TABLE IF EXISTS ${DBSchema.CustomizesTable.TABLENAME}"
//
//
//    private val SQL_CREATE_CARTYPE =
//        "CREATE TABLE ${DBSchema.CartypesTable.TABLENAME} (" +
//                "${DBSchema.CartypesTable.Cols.NAME} TEXT PRIMARY KEY)"
//
//    private val SQL_DELETE_CARTYPE = "DROP TABLE IF EXISTS ${DBSchema.CartypesTable.TABLENAME}"
//
//    private val SQL_CREATE_LOCATION =
//        "CREATE TABLE ${DBSchema.LocationsTable.TABLENAME} (" +
//                "${DBSchema.LocationsTable.Cols.ADDRESS} TEXT PRIMARY KEY," +
//                "${DBSchema.LocationsTable.Cols.PHONE} TEXT," +
//                "${DBSchema.LocationsTable.Cols.EMAIL} TEXT," +
//                "${DBSchema.LocationsTable.Cols.CARTYPENAME} TEXT," +
//                "${DBSchema.LocationsTable.Cols.NAME} TEXT)"
//
//    private val SQL_DELETE_LOCATION = "DROP TABLE IF EXISTS ${DBSchema.LocationsTable.TABLENAME}"
//
//    private val SQL_CREATE_MODEL =
//        "CREATE TABLE ${DBSchema.ModelsTable.TABLENAME} (" +
//                "${DBSchema.ModelsTable.Cols.NAME} TEXT PRIMARY KEY," +
//                "${DBSchema.ModelsTable.Cols.MODELNO} INTEGER," +
//                "${DBSchema.ModelsTable.Cols.CARTYPENAME} TEXT)"
//
//    private val SQL_DELETE_MODEL = "DROP TABLE IF EXISTS ${DBSchema.ModelsTable.TABLENAME}"
//
//
//    private val SQL_CREATE_COLOR =
//        "CREATE TABLE ${DBSchema.ColorsTable.TABLENAME} (" +
//                "${DBSchema.ColorsTable.Cols.NAME} TEXT PRIMARY KEY," +
//                "${DBSchema.ColorsTable.Cols.SAVEID} INTEGER," +
//                "${DBSchema.ColorsTable.Cols.MODLENAME} TEXT)"
//
//    private val SQL_DELETE_COLOR = "DROP TABLE IF EXISTS ${DBSchema.ColorsTable.TABLENAME}"
//
//
//    private val SQL_CREATE_EXTERIOR =
//        "CREATE TABLE ${DBSchema.ExteriorsTable.TABLENAME} (" +
//                "${DBSchema.ExteriorsTable.Cols.EXTERIORID} INTEGER PRIMARY KEY," +
//                "${DBSchema.ExteriorsTable.Cols.WHEEL} TEXT," +
//                "${DBSchema.ExteriorsTable.Cols.BUMPER} TEXT," +
//                "${DBSchema.ExteriorsTable.Cols.ENGINE} TEXT," +
//                "${DBSchema.ExteriorsTable.Cols.SAVEID} INTEGER)"
//
//    private val SQL_DELETE_EXTERIOR = "DROP TABLE IF EXISTS ${DBSchema.ExteriorsTable.TABLENAME}"
//
//
//    private val SQL_CREATE_INTERIOR =
//        "CREATE TABLE ${DBSchema.InteriorsTable.TABLENAME} (" +
//                "${DBSchema.InteriorsTable.Cols.INTERIORID} INTEGER PRIMARY KEY," +
//                "${DBSchema.InteriorsTable.Cols.DASHBOARD} TEXT," +
//                "${DBSchema.InteriorsTable.Cols.SUNROOF} TEXT," +
//                "${DBSchema.InteriorsTable.Cols.SCREENSIZE} TEXT," +
//                "${DBSchema.InteriorsTable.Cols.SAVEID} INTEGER)"
//
//    private val SQL_DELETE_INTERIOR = "DROP TABLE IF EXISTS ${DBSchema.InteriorsTable.TABLENAME}"


    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(SQL_CREATE_ACCOUNT)
        db.execSQL(SQL_CREATE_USER)
        db.execSQL(SQL_CREATE_REVIEW)
//        db.execSQL(SQL_CREATE_CUSTOMIZE)
//        db.execSQL(SQL_CREATE_CARTYPE)
//        db.execSQL(SQL_CREATE_LOCATION)
//        db.execSQL(SQL_CREATE_MODEL)
//        db.execSQL(SQL_CREATE_COLOR)
//        db.execSQL(SQL_CREATE_EXTERIOR)
//        db.execSQL(SQL_CREATE_INTERIOR)
    }
    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        // This database is only a cache for online data, so its upgrade policy is
        // to simply to discard the data and start over
        db.execSQL(SQL_DELETE_ACCOUNT)
        db.execSQL(SQL_DELETE_USER)
        db.execSQL(SQL_DELETE_REVIEW)
//        db.execSQL(SQL_DELETE_CUSTOMIZE)
//        db.execSQL(SQL_DELETE_CARTYPE)
//        db.execSQL(SQL_DELETE_LOCATION)
//        db.execSQL(SQL_DELETE_MODEL)
//        db.execSQL(SQL_DELETE_COLOR)
//        db.execSQL(SQL_DELETE_EXTERIOR)
//        db.execSQL(SQL_DELETE_INTERIOR)
        onCreate(db)
    }
    override fun onDowngrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        onUpgrade(db, oldVersion, newVersion)
    }
    companion object {
        // If you change the database schema, you must increment the database version.
        const val DATABASE_VERSION = 3
        const val DATABASE_NAME = "CustomizeCars.db"
    }

}