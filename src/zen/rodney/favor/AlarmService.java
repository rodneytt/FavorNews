/**
 * AlarmService.java 2011-8-13 下午8:46:37
 * AII Rights Reserved
 */

package zen.rodney.favor;

import java.util.Calendar;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class AlarmService extends Activity implements OnClickListener {

	private static AlarmService appRef = null;
	private Button b_alarm_call, b_alarm_exit;
	boolean k = false;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		appRef = this;
		setContentView(R.layout.alarmservice);
		b_alarm_call = (Button) findViewById(R.id.alarm_call);
		b_alarm_call.setOnClickListener(this);
		b_alarm_exit = (Button) findViewById(R.id.alarm_exit);
		b_alarm_exit.setOnClickListener(this);
	}

	public static AlarmService getApp() {
		return appRef;
	}

	public void btEvent(String data) {
		setTitle(data);
	}

	@Override
	public void onClick(View v) {
		if (v == b_alarm_call) {
			setTitle("waiting ****** alarm=5");
			Intent it = new Intent(this, AlarmReceiver.class);
			PendingIntent pi = PendingIntent.getBroadcast(this, 0, it, 0);
			Calendar calendar = Calendar.getInstance();
			calendar.setTimeInMillis(System.currentTimeMillis());
			calendar.add(Calendar.SECOND, 5);
			AlarmManager am = (AlarmManager) getSystemService(ALARM_SERVICE);
			am.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pi);
		} else if (v == b_alarm_exit) {
			Intent it = new Intent(this, AlarmReceiver.class);
			PendingIntent pi = PendingIntent.getBroadcast(this, 0, it, 0);
			AlarmManager am = (AlarmManager) getSystemService(ALARM_SERVICE);
			am.cancel(pi);
			finish();
		}
	}
};
