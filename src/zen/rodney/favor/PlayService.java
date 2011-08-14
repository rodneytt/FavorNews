/**
 * PlayService.java 2011-8-14 下午9:18:27
 * AII Rights Reserved
 */

package zen.rodney.favor;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class PlayService extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.playservice);
		((Button)findViewById(R.id.play)).setOnClickListener(startIt);
		((Button)findViewById(R.id.stop)).setOnClickListener(stopIt);
	}

	private OnClickListener startIt = new OnClickListener() {

		@Override
		public void onClick(View v) {
			startService(new Intent("zen.rodney.favor.SATRT_AUDIO_SERVICE"));
		}
	};
	private OnClickListener stopIt = new OnClickListener() {

		@Override
		public void onClick(View v) {
			stopService(new Intent("zen.rodney.favor.SATRT_AUDIO_SERVICE"));
			finish();
		}
	};
}
