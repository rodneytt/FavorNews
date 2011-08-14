/**
 * MusicServcie.java 2011-8-14 下午9:23:21
 * AII Rights Reserved
 */

package zen.rodney.favor;

import java.io.IOException;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.util.Log;

public class MusicServcie extends Service {
	private static final String TAG = "MusicService";
	private NotificationManager manager;
	private MediaPlayer player;

	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}

	@Override
	public void onCreate() {
		super.onCreate();
		Log.e("ggg", "----------------");
		player = MediaPlayer.create(this, R.raw.gequ);
		try {
			player.prepare();
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		player.start();
		manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
		showNotification();
	}
	@Override
	public void onStart(Intent intent, int startId) {
		super.onStart(intent, startId);
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		Log.e("ggg", "++++++++++++++++++");
		player.stop();
	}
	private void showNotification() {
		Notification n = new Notification(R.drawable.sun, "start service", System.currentTimeMillis());
		PendingIntent pi = PendingIntent.getActivity(this, 0, new Intent(this, PlayService.class), 0);
		n.setLatestEventInfo(this, "start Service", "服务运行中", pi);
		manager.notify(R.string.service_started, n);
	}
}
