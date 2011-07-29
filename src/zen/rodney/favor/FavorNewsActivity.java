package zen.rodney.favor;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class FavorNewsActivity extends Activity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		find_and_modify_button();
		((Button) findViewById(R.id.edit_view)).setOnClickListener(edit_view_button_listen);
		((Button) findViewById(R.id.tab_view_button)).setOnClickListener(tab_view_button_listen);
		((Button) findViewById(R.id.menu_button1)).setVisibility(View.INVISIBLE);
		((Button) findViewById(R.id.menu_button2)).setVisibility(View.INVISIBLE);
		((Button) findViewById(R.id.main_button2)).setOnClickListener(main_button2_listen);
		((Button) findViewById(R.id.main_button1)).setOnClickListener(main_button1_listen);
	}

	private void find_and_modify_button() {
		Button button = (Button) findViewById(R.id.button);
		button.setOnClickListener(button_listen);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		super.onCreateOptionsMenu(menu);
		menu.add(0, 0, 0, "��ʾbutton1");
		menu.add(0, 1, 1, "��ʾbutton2");
		menu.add(1, 2, 0, "��ʾbutton3");
		menu.add(1, 3, 0, "��ʾbutton4");
		menu.add(2, 4, 3, "��ʾbutton5");
		menu.add(2, 5, 2, "��ʾbutton6");
		menu.add(2, 6, 0, "��ʾbutton7");

		menu.findItem(0);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case 0:
			actionClickItem1();
			break;
		case 1:
			actionClickItem2();
			break;
		default:
			break;
		}
		return super.onOptionsItemSelected(item);
	}

	private void actionClickItem1() {
		((Button) findViewById(R.id.menu_button1)).setVisibility(View.VISIBLE);
		((Button) findViewById(R.id.menu_button2)).setVisibility(View.INVISIBLE);
	}

	private void actionClickItem2() {
		((Button) findViewById(R.id.menu_button1)).setVisibility(View.INVISIBLE);
		((Button) findViewById(R.id.menu_button2)).setVisibility(View.VISIBLE);
	}

	private OnClickListener button_listen = new OnClickListener() {

		@Override
		public void onClick(View v) {
			setTitle("���ϣ�button������һ��");
		}
	};
	private OnClickListener edit_view_button_listen = new OnClickListener() {

		@Override
		public void onClick(View v) {
			Intent intent = new Intent();
			intent.setClass(FavorNewsActivity.this, EditTextActivity.class);
			startActivity(intent);
		}
	};
	private OnClickListener tab_view_button_listen = new OnClickListener() {

		@Override
		public void onClick(View v) {
			Intent intent = new Intent();
			intent.setClass(FavorNewsActivity.this, TabActivity.class);
			startActivity(intent);
		}
	};
	private OnClickListener main_button2_listen = new OnClickListener() {

		@Override
		public void onClick(View v) {
			setTitle("����ʵ��activitymain");
			Intent intent = new Intent();
			intent.setClass(FavorNewsActivity.this, Activity2.class);
			startActivity(intent);
		}
	};
	private OnClickListener main_button1_listen = new OnClickListener() {

		@Override
		public void onClick(View v) {
			Intent intent = new Intent(FavorNewsActivity.this, Activity1.class);
			intent.putExtra("activityMain", "��������activityMain");
			startActivityForResult(intent, 1);
		}
	};

	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (requestCode == 1) {
			if (resultCode == RESULT_CANCELED) {
				setTitle("ȡ��");
			} else if (resultCode == RESULT_OK) {
				Bundle b = data.getExtras();
				if (b != null) {
					String t = b.getString("store");
					setTitle("���أ�" + t);
				}

			}
		}
	};

}