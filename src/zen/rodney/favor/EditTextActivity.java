package zen.rodney.favor;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class EditTextActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setTitle("±‡º≠ΩÁ√Ê");
		setContentView(R.layout.editview);
		((Button) findViewById(R.id.get_edit_text_button))
				.setOnClickListener(get_edit_text_button_listen);
	}

	private OnClickListener get_edit_text_button_listen = new OnClickListener() {

		@Override
		public void onClick(View v) {
			EditText et = (EditText) findViewById(R.id.edit_text);
			CharSequence val = et.getText();
			setTitle("÷µ£∫" + val);
		}
	};
}
