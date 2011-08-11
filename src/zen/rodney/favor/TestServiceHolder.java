/**
 * TestServiceHolder.java 2011-8-11 下午9:26:29
 * AII Rights Reserved
 */

package zen.rodney.favor;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class TestServiceHolder extends Activity {
	private boolean isBound;
	private TestService boundService;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.testservice);
		setTitle("测试服务");
		initButtons();
	}

	private void startService() {
		Intent it = new Intent(this, TestService.class);
		this.startService(it);
	}

	private void stopService() {
		Intent it = new Intent(this, TestService.class);
		this.stopService(it);
	}

	private void bindService() {
		Intent it = new Intent(this, TestService.class);
		this.bindService(it, connection, Context.BIND_AUTO_CREATE);
		isBound = true;
	}

	private void unbindService() {
		if (isBound) {
			unbindService(connection);
			isBound = false;
		}
	}

	private ServiceConnection connection = new ServiceConnection() {

		@Override
		public void onServiceDisconnected(ComponentName name) {
			boundService = null;
			Toast.makeText(TestServiceHolder.this, "service disconnected", Toast.LENGTH_SHORT).show();
		}

		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
			boundService = ((TestService.LocalBinder) service).getTestService();
			Toast.makeText(TestServiceHolder.this, "service connected", Toast.LENGTH_SHORT).show();
		}
	};

	private void initButtons() {
		((Button) findViewById(R.id.start_service)).setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				startService();
			}
		});
		((Button) findViewById(R.id.stop_service)).setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				stopService();
			}
		});
		((Button) findViewById(R.id.bind_service)).setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				bindService();
			}
		});
		((Button) findViewById(R.id.unbind_service)).setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				unbindService();
			}
		});
	}
}
