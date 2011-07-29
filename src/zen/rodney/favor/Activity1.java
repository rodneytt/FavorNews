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
			setTitle("现在是在activity1中：" + data);
		}
		((Button)findViewById(R.id.activity_button2)).setOnClickListener(listen);
	}

	private OnClickListener listen = new OnClickListener() {

		@Override
		public void onClick(View v) {
			Bundle bundle = new Bundle();
			bundle.putString("store", "数据来自activity1");
			Intent intent = new Intent();
			intent.putExtras(bundle);
			setResult(RESULT_OK, intent);
			finish();
		}
	};
}
