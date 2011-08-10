/**
 * BroadCastActivity.java 2011-8-10 下午9:37:45
 * AII Rights Reserved
 */

package zen.rodney.favor;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class BroadCastActivity extends Activity {
	private static final int ITEM0 = Menu.FIRST;
	private static final int ITEM1 = Menu.FIRST + 1;

	private static final String ACTION1 = "com.rodney.action.new_broadcast1";
	private static final String ACTION2 = "com.rodney.action.new_broadcast2";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.broadcast);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		super.onCreateOptionsMenu(menu);
		menu.add(0, ITEM0, 0, "显示notification");
		menu.add(0, ITEM1, 0, "清除notification");
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case ITEM0:
			actionClickMenu1();
			break;

		case ITEM1:
			actionClickMenu2();
			break;
		}
		return true;
	}

	private void actionClickMenu1() {
		Intent it = new Intent(ACTION1);
		sendBroadcast(it);
	}

	private void actionClickMenu2() {
		Intent it = new Intent(ACTION2);
		sendBroadcast(it);
	}
}
