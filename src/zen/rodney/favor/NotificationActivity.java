/**
 * NotificationActivity.java 2011-8-2 7:49:33
 * AII Rights Reserved
 */

package zen.rodney.favor;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class NotificationActivity extends Activity {
	NotificationManager nm;
	final static int NOTICE_ID = R.layout.notification;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setTitle("notification使用举例");
		setContentView(R.layout.notification);
		nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
		((Button) findViewById(R.id.n_sun)).setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				setWeather("晴空万里", "天气预报", "晴空万里oooo", R.drawable.sun);
			}
		});
		((Button) findViewById(R.id.n_cloud)).setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				setWeather("阴云密布", "天气预报", "阴云密布oooo", R.drawable.cloudy);
			}
		});
		((Button) findViewById(R.id.n_rain)).setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				setWeather("大雨连绵", "天气预报", "大雨连绵oooo", R.drawable.rain);
			}
		});
	}

	private void setWeather(String text, String title, String content, int drawable) {
		Notification nn = new Notification(drawable, text, System.currentTimeMillis());
		PendingIntent pi = PendingIntent.getActivity(this, 0, new Intent(this,
				NotificationActivity.class), 0);
		nn.setLatestEventInfo(this, title, content, pi);
		nn.defaults = Notification.DEFAULT_SOUND;
		nm.notify(NOTICE_ID, nn);
	}
}
