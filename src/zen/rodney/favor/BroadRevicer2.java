/**
 * BroadRevicer2.java 2011-8-10 下午9:59:04
 * AII Rights Reserved
 */

package zen.rodney.favor;

import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class BroadRevicer2 extends BroadcastReceiver {
	Context context;

	@Override
	public void onReceive(Context context, Intent intent) {
		this.context = context;
		deleteNotification();
	}

	private void deleteNotification() {
		NotificationManager manager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
		manager.cancel(BroadRevicer1.NOTIFICATION_ID);
	}

}
