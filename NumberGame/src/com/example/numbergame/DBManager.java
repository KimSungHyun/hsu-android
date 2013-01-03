package com.example.numbergame;

import java.util.Vector;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class DBManager {
	private static final String DATABASE_NAME = "Rank.db";
	private static final String CREATE_TABLE_SQL = "CREATE TABLE IF NOT EXISTS Rank ("
			+ " Id INTEGER PRIMARY KEY AUTOINCREMENT,"
			+ " UserName NVARCHAR(256) NOT NULL,"
			+ " EndTime LONG NOT NULL DEFAULT 0)";
	private static final String TABLE_NAME = "Rank";
	private static final String FIELD_ID = "Id";
	private static final String FIELD_NAME = "UserName";
	private static final String FIELD_ENDTIME = "EndTime";
	private static final String TAG = "DBManager";

	private SQLiteDatabase db;
	private Vector<Rank> vector = new Vector<Rank>();

	public DBManager(Context context) {
		db = context.openOrCreateDatabase(DATABASE_NAME, Context.MODE_PRIVATE,
				null);

		db.execSQL(CREATE_TABLE_SQL);
		loadData();
	}

	public Vector<Rank> getData() {
		return vector;
	}

	private void loadData() {
		vector.removeAllElements();
		 Cursor cursor = db.query(TABLE_NAME, null, null, null, null, null,
		 FIELD_ID);
//		Cursor cursor = db.rawQuery("SELECT * FROM Rank", null);

		while (cursor.moveToNext()) {
			Rank rank = new Rank(cursor);
			vector.add(rank);
		}
	}

	public boolean add(String name, long time) {
		ContentValues values = new ContentValues();
		values.put(FIELD_NAME, name);
		values.put(FIELD_ENDTIME, time);

		long row_id = db.insert(TABLE_NAME, null, values);
		if (row_id < 0) {
			return false;
		}

		loadData();
		return true;
	}

	public void delete(int id) {
		db.delete(TABLE_NAME, "Id=" + id, null);
		loadData();
	}

	public class Rank {

		private int id;
		private String name;
		private long endTime;

		public Rank(Cursor cursor) {
			id = cursor.getInt(cursor.getColumnIndex("Id"));
			name = cursor.getString(cursor.getColumnIndex("UserName"));
			endTime = cursor.getInt(cursor.getColumnIndex("EndTime"));
		}

		public int getId() {
			return id;
		}

		public String getName() {
			return name;
		}

		public long getTime() {
			return endTime;
		}
	}
}
