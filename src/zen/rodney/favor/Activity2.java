package zen.rodney.favor;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Activity2 extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity2);
		((Button)findViewById(R.id.activity_button1)).setOnClickListener(listen);
		setTitle("现在这是在activity2中");
	}
	private OnClickListener listen = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			finish();
		}
	};
}
