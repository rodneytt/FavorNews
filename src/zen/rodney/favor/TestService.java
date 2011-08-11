/**
 * TestService.java 2011-8-11 下午9:09:05
 * AII Rights Reserved
 */

package zen.rodney.favor;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class TestService extends Service {
	private static final String TAG = "TestService";
	private NotificationManager manager;

	@Override
	public IBinder onBind(Intent intent) {
		Log.e(TAG, "-->onbind");
		return null;
	}

	public class LocalBinder extends Binder {
		TestService getTestService() {
			return TestService.this;
		}
	}

	@Override
	public boolean onUnbind(Intent intent) {
		Log.e(TAG, "-->onunbind");
		return super.onUnbind(intent);
	}

	@Override
	public void onRebind(Intent intent) {
		Log.e(TAG, "-->onrebind");
		super.onRebind(intent);
	}

	@Override
	public void onCreate() {
		Log.e(TAG, "-->oncreate");
		manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
		showNotification();
	}

	@Override
	public void onStart(Intent intent, int startId) {
		super.onStart(intent, startId);
		Log.e(TAG, "-->onstart");
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		Log.e(TAG, "-->ondestroy");
		manager.cancel(R.string.service_started);
	}

	private void showNotification() {
		Notification n = new Notification(R.drawable.sun, "start service", System.currentTimeMillis());
		PendingIntent pi = PendingIntent.getActivity(this, 0, new Intent(this, TestServiceHolder.class), 0);
		n.setLatestEventInfo(this, "start Service", "服务运行中", pi);
		manager.notify(R.string.service_started, n);
	}
}
