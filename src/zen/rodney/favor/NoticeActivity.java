/**
 * NoticeActivity.java 2011-8-2 下午7:47:03
 * AII Rights Reserved
 */

package zen.rodney.favor;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class NoticeActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.notice);
		((Button) findViewById(R.id.notice_1)).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				setTitle("学校notification");
				Intent it = new Intent();
				it.setClass(NoticeActivity.this, NotificationActivity.class);
				startActivity(it);
			}
		});
		((Button) findViewById(R.id.notice_2)).setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				setTitle("学校toast");
				Intent it = new Intent();
				it.setClass(NoticeActivity.this, ToastActivity.class);
				startActivity(it);
			}
		});
	}
}
