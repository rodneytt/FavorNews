package zen.rodney.favor;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class FavorNewsActivity extends Activity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		find_and_modify_button();
		((Button) findViewById(R.id.edit_view))
				.setOnClickListener(edit_view_button_listen);
	}

	private void find_and_modify_button() {
		Button button = (Button) findViewById(R.id.button);
		button.setOnClickListener(button_listen);
	}

	private OnClickListener button_listen = new OnClickListener() {

		@Override
		public void onClick(View v) {
			setTitle("哎呦，button被点了一下");
		}
	};
	private OnClickListener edit_view_button_listen = new OnClickListener() {

		@Override
		public void onClick(View v) {
			Intent intent = new Intent();
			intent.setClass(FavorNewsActivity.this, EditTextActivity.class);
			startActivity(intent);
		}
	};
}