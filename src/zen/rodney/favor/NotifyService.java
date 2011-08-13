/**
 * NotifyService.java 2011-8-13 下午9:09:48
 * AII Rights Reserved
 */

package zen.rodney.favor;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;

public class NotifyService extends Service {

	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}

	@Override
	public void onCreate() {
		AlarmService app = AlarmService.getApp();
		app.btEvent("from notifyservice");
		Toast.makeText(this, "hello,my friends", Toast.LENGTH_LONG).show();
	}
}
