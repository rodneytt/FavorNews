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
		((Button) findViewById(R.id.button1)).setOnClickListener(button1_listen);
		((Button) findViewById(R.id.button2)).setOnClickListener(button2_listen);
	}

	private OnClickListener button1_listen = new OnClickListener() {

		@Override
		public void onClick(View paramView) {
			System.out.println(paramView.getId());
			Intent it = new Intent();
			it.setClass(FavorNewsActivity.this, DialogActivity.class);
			startActivity(it);
		}
	};
	private OnClickListener button2_listen = new OnClickListener() {

		@Override
		public void onClick(View paramView) {
			System.out.println(paramView.getId());
			Intent it = new Intent();
			it.setClass(FavorNewsActivity.this, ActivityList2.class);
			startActivity(it);
		}
	};
}