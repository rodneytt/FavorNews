/**
 * DiaryActivity.java 2011-8-7 下午2:24:17
 * AII Rights Reserved
 */

package zen.rodney.favor;

import android.app.ListActivity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class DiaryActivity extends ListActivity {
	private static final int ACTIVITY_CREATE = 0;
	private static final int ACTIVITY_EDIT = 1;
	private DiaryDbAdapter mDbHelper;
	private Cursor mCursor;
	private static final int INSERT_ID = Menu.FIRST;
	private static final int DELETE_ID = Menu.FIRST + 1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.diary_list);
		mDbHelper = new DiaryDbAdapter(this);
		mDbHelper.open();
		renderLisrView();
	}

	private void renderLisrView() {
		mCursor = mDbHelper.getAllNotes();
		startManagingCursor(mCursor);
		String[] from = new String[] { DiaryDbAdapter.KEY_TITLE, DiaryDbAdapter.KEY_CREATED };
		int[] to = new int[] { R.id.text1, R.id.created };
		SimpleCursorAdapter sca = new SimpleCursorAdapter(this, R.layout.diary_row, mCursor, from, to);
		setListAdapter(sca);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		super.onCreateOptionsMenu(menu);
		menu.add(0, INSERT_ID, 0, "添加一条新日记");
		menu.add(0, DELETE_ID, 0, "删除一篇日记");
		return true;
	}

	@Override
	public boolean onMenuItemSelected(int featureId, MenuItem item) {
		switch (item.getItemId()) {
		case INSERT_ID:
			createDiary();
			break;
		case DELETE_ID:
			mDbHelper.deleteDiary(getListView().getSelectedItemId());
			renderLisrView();
			break;
		}
		return super.onMenuItemSelected(featureId, item);
	}

	private void createDiary() {
		Intent it = new Intent();
		it.setClass(this, DiaryEditActivity.class);
		startActivityForResult(it, ACTIVITY_CREATE);
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);
		Cursor c = mCursor;
		c.moveToPosition(position);
		Intent i = new Intent(this, DiaryEditActivity.class);
		i.putExtra(DiaryDbAdapter.KEY_ROWID, id);
		i.putExtra(DiaryDbAdapter.KEY_TITLE, c.getString(c.getColumnIndexOrThrow(DiaryDbAdapter.KEY_TITLE)));
		i.putExtra(DiaryDbAdapter.KEY_BODY, c.getString(c.getColumnIndexOrThrow(DiaryDbAdapter.KEY_BODY)));
		startActivityForResult(i, ACTIVITY_EDIT);
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		renderLisrView();
	}
}
