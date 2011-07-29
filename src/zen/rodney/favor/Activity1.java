package zen.rodney.favor;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Activity1 extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity1);
		Bundle extras = getIntent().getExtras();
		if (extras != null) {
			String data = extras.getString("activityMain");
			setTitle("��������activity1�У�" + data);
		}
		((Button)findViewById(R.id.activity_button2)).setOnClickListener(listen);
	}

	private OnClickListener listen = new OnClickListener() {

		@Override
		public void onClick(View v) {
			Bundle bundle = new Bundle();
			bundle.putString("store", "��������activity1");
			Intent intent = new Intent();
			intent.putExtras(bundle);
			setResult(RESULT_OK, intent);
			finish();
		}
	};
}
