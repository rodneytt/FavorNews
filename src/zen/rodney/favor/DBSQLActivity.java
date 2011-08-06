/**
 * DBSQLActivity.java 2011-8-6 下午5:52:34
 * AII Rights Reserved
 */

package zen.rodney.favor;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DBSQLActivity extends Activity {
	private static final String DATABASE_NAME = "DIARY";
	private static final String TABLE_NAME = "USERS";
	private SQLiteOpenHelper mOpenHelper = new DataBaseHelper(this);

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dbsql);
		((Button) findViewById(R.id.db_insert_button)).setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				insertItem();
			}
		});
		((Button) findViewById(R.id.db_query_button)).setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				showItems();
			}
		});
		((Button) findViewById(R.id.db_delete_button)).setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				deleteItem();
			}
		});
	}

	private void insertItem() {
		SQLiteDatabase db = mOpenHelper.getWritableDatabase();
		String sql1 = "insert into " + TABLE_NAME + " (title,body) values('chenwei','欢迎光临')";
		String sql2 = "insert into " + TABLE_NAME + " (title,body) values('admin','管理员')";
		try {
			db.execSQL(sql1);
			db.execSQL(sql2);
			setTitle("插入数据成功！");
		} catch (Exception e) {
			setTitle("插入数据失败！");
		}
	}

	private void showItems() {
		SQLiteDatabase db = mOpenHelper.getReadableDatabase();
		String[] col = { "title", "body" };
		Cursor cur = db.query(TABLE_NAME, col, null, null, null, null, null);
		Integer num = cur.getCount();
		setTitle(num + "条记录");
	}

	private void deleteItem() {
		SQLiteDatabase db = mOpenHelper.getWritableDatabase();
		db.delete(TABLE_NAME, " title='chenwei'", null);
		setTitle("删除title为chenwei的记录");
	}

	private static class DataBaseHelper extends SQLiteOpenHelper {
		public DataBaseHelper(Context context) {
			super(context, DATABASE_NAME, null, 1);
		}

		@Override
		public void onCreate(SQLiteDatabase db) {
			String sql = "create table " + TABLE_NAME + " (title text not null,body text not null);";
			db.execSQL(sql);
		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		}
	}
}
