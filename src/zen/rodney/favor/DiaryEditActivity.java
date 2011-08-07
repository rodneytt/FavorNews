/**
 * DiaryEditActivity.java 2011-8-7 下午2:46:09
 * AII Rights Reserved
 */

package zen.rodney.favor;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class DiaryEditActivity extends Activity {
	private Long mRowId;
	private DiaryDbAdapter mDbHelper;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.diary_edit);
		mDbHelper = new DiaryDbAdapter(this);
		mDbHelper.open();
		final EditText titleText = (EditText) findViewById(R.id.diary_title);
		final EditText bodyText = (EditText) findViewById(R.id.diary_body);
		Button confirmButton = (Button) findViewById(R.id.diary_confirm);

		Bundle extras = getIntent().getExtras();
		if (extras != null) {
			String title = extras.getString(DiaryDbAdapter.KEY_TITLE);
			String body = extras.getString(DiaryDbAdapter.KEY_BODY);
			mRowId = extras.getLong(DiaryDbAdapter.KEY_ROWID);
			if (title != null) {
				titleText.setText(title);
			}
			if (body != null) {
				bodyText.setText(body);
			}
		}
		confirmButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				String title = titleText.getText().toString();
				String body = bodyText.getText().toString();
				if (mRowId != null) {
					mDbHelper.updateDiary(mRowId, title, body);
				} else {
					mDbHelper.createDiary(title, body);
				}
				Intent it = new Intent();
				setResult(RESULT_OK, it);
				finish();
			}
		});
	}
}
