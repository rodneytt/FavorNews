/**
 * AlarmReceiver.java 2011-8-13 下午8:56:35
 * AII Rights Reserved
 */

package zen.rodney.favor;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class AlarmReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		context.startService(new Intent(context, NotifyService.class));
	}
}
