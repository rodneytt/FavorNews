/**
 * DiaryDbAdapter.java 2011-8-6 下午8:29:52
 * AII Rights Reserved
 */

package zen.rodney.favor;

import java.text.SimpleDateFormat;
import java.util.Date;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DiaryDbAdapter {
	public static final String KEY_TITLE = "title";
	public static final String KEY_BODY = "body";
	public static final String KEY_ROWID = "_id";
	public static final String KEY_CREATED = "created";
	private static final String DATABASE_NAME = "DATABASE";
	private static final String DATABASE_TABLE = "diary";
	private static final int DATABASE_VERSION = 1;
	private static final String DATABASE_CREATE = "create table diary (_id integer primary key autoincrement, "
			+ "title text not null, body text not null, created text not null);";
	private final Context ctx;
	private SQLiteOpenHelper mDbHelper;
	private SQLiteDatabase mDb;

	public DiaryDbAdapter(Context context) {
		this.ctx = context;
	}

	public DiaryDbAdapter open() {
		mDbHelper = new DatabaseHelper(ctx);
		mDb = mDbHelper.getWritableDatabase();
		return this;
	}

	public void close() {
		mDb.close();
		mDbHelper.close();
	}

	public long createDiary(String title, String text) {
		ContentValues cvalue = new ContentValues();
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		cvalue.put(KEY_TITLE, title);
		cvalue.put(KEY_BODY, text);
		cvalue.put(KEY_CREATED, sdf.format(d));
		return mDb.insert(DATABASE_TABLE, null, cvalue);
	}

	public boolean deleteDiary(long rowId) {
		return mDb.delete(DATABASE_TABLE, KEY_ROWID + "=" + rowId, null) > 0;
	}

	public Cursor getAllNotes() {
		return mDb.query(DATABASE_TABLE, new String[] { KEY_ROWID, KEY_TITLE, KEY_BODY, KEY_CREATED }, null, null,
				null, null, null);
	}

	public Cursor getDiary(long rowId) {
		Cursor cur = mDb.query(true, DATABASE_TABLE, new String[] { KEY_ROWID, KEY_TITLE, KEY_BODY, KEY_CREATED },
				KEY_ROWID + "=" + rowId, null, null, null, null, null);
		if (cur != null) {
			cur.moveToFirst();
		}
		return cur;
	}

	public boolean updateDiary(long rowId, String title, String text) {
		ContentValues cvalue = new ContentValues();
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		cvalue.put(KEY_TITLE, title);
		cvalue.put(KEY_BODY, text);
		cvalue.put(KEY_CREATED, sdf.format(d));
		return mDb.update(DATABASE_TABLE, cvalue, KEY_ROWID + "=" + rowId, null) > 0;
	}

	private static class DatabaseHelper extends SQLiteOpenHelper {
		public DatabaseHelper(Context context) {
			super(context, DATABASE_NAME, null, DATABASE_VERSION);
		}

		@Override
		public void onCreate(SQLiteDatabase db) {
			db.execSQL(DATABASE_CREATE);
		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			db.execSQL("drop table if exists " + DATABASE_NAME);
			onCreate(db);
		}
	}
}
