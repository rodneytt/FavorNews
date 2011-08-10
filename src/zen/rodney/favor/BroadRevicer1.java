/**
 * BroadRevicer1.java 2011-8-10 下午9:46:41
 * AII Rights Reserved
 */

package zen.rodney.favor;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class BroadRevicer1 extends BroadcastReceiver {
	Context context;
	public static final int NOTIFICATION_ID = 21321;

	@Override
	public void onReceive(Context context, Intent intent) {
		this.context = context;
		showNotification();
	}

	private void showNotification() {
		NotificationManager manager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
		Notification notice = new Notification(R.drawable.sun, "在broadreceiver1中", System.currentTimeMillis());
		PendingIntent it = PendingIntent.getActivity(context, 0, new Intent(context, BroadCastActivity.class), 0);
		notice.setLatestEventInfo(context, "in broadreceive1", null, it);
		manager.notify(NOTIFICATION_ID, notice);
	}
}
