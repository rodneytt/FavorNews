/**
 * ToastActivity.java 2011-8-2 7:49:49
 * AII Rights Reserved
 */

package zen.rodney.favor;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ToastActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setTitle("toast使用举例");
		setContentView(R.layout.toast);
		((Button) findViewById(R.id.toast_1)).setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View paramView) {
				setTitle("短时间的toast");
				showToast(Toast.LENGTH_SHORT);
			}
		});
		((Button) findViewById(R.id.toast_2)).setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View paramView) {
				setTitle("长时间的toast");
				showToast(Toast.LENGTH_LONG);
			}
		});
	}

	private void showToast(int type) {
		LayoutInflater inf = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
		View view = inf.inflate(R.layout.toastcontent, null);
		Toast toast = new Toast(this);
		toast.setView(view);
		toast.setDuration(type);
		toast.show();
	}
}
