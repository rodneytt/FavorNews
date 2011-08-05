/**
 * SharedActivity.java 2011-8-5 下午9:22:09
 * AII Rights Reserved
 */

package zen.rodney.favor;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;

public class SharedActivity extends Activity {
	private static final String SETTING_INFO = "setting_infos";
	private static final String NAME = "NAME";
	private static final String PASSWORD = "PASSWORD";
	private EditText name;
	private EditText pass;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.shared);
		name = (EditText) findViewById(R.id.susername);
		pass = (EditText) findViewById(R.id.spassword);
		SharedPreferences settings = getSharedPreferences(SETTING_INFO, 0);
		String username = settings.getString(NAME, "");
		String password = settings.getString(PASSWORD, "");
		name.setText(username);
		pass.setText(password);
	}

	@Override
	protected void onStop() {
		super.onStop();
		SharedPreferences settings = getSharedPreferences(SETTING_INFO, 0);
		settings.edit().putString(NAME, name.getText().toString())
				.putString(PASSWORD, pass.getText().toString()).commit();
	}
}
