//package com.example.shiba.samplequizapp.db
//
//import android.content.Context
//import android.database.sqlite.SQLiteDatabase
//import android.database.sqlite.SQLiteOpenHelper
//
//public class UserOpenHelper: SQLiteOpenHelper {
//
//	companion object {
//		val DB_NAME = "myapp.db"
//		val DB_VERSION = 1
//		val CREATE_TABLE = "create table ${UserContract.Users.TABLE_NAME} (" +
//				"${UserContract.Users._ID} integer primary key autoincrement, " +
//				"${UserContract.Users.COL_NAME} text," +
//				"${UserContract.Users.COL_SCORE} integer)"
//
//		val INIT_TABLE = "insert int users (name, score) values " +
//				"('taguchi', 42), " +
//				"('fkoji', 82), " +
//				"('dotinstall', 62)"
//
//		val DROP_TABLE = "drop table if exists users";
//	}
//
//	constructor(c: Context) : super(c, DB_NAME, null, DB_VERSION) {
//	}
//
//	//DB生成時
//	override fun onCreate(sqLiteDatabase: SQLiteDatabase):Unit {
//		// create table
//		sqLiteDatabase.execSQL(CREATE_TABLE);
//		// init table
//		sqLiteDatabase.execSQL(INIT_TABLE);
//	}
//
//	//DBのバージョンアップ時（DB_VERSIONの値を書き換えた時？）
//	override fun onUpgrade(sqLiteDatabase:SQLiteDatabase, i:Int, i1:Int):Unit {
//		// drop table
//		sqLiteDatabase.execSQL(DROP_TABLE);
//		// onCreate
//		onCreate(sqLiteDatabase);
//	}
//
//}