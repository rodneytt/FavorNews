/**
 * DialogActivity.java 2011-7-31 ����9:08:10
 * AII Rights Reserved
 */

package zen.rodney.favor;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class DialogActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dialog);
		((Button) findViewById(R.id.dialog_button1)).setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				showDialog(1);
			}

		});
	}

	@Override
	protected Dialog onCreateDialog(int id) {
		switch (id) {
		case 1:
			return buildDialg1(this);

		default:
			break;
		}
		return null;
	}

	private Dialog buildDialg1(Context context) {
		AlertDialog.Builder b = new AlertDialog.Builder(context);
		b.setTitle("�Ի���");
		b.setMessage("����һ���Ի���?");
		b.setPositiveButton("ȷ��", new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				setTitle("�����Ի����е�ȷ����ť");
			}
		});
		b.setNegativeButton("ȡ��", new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				setTitle("�����˶Ի����е�ȡ����ť");
			}
		});
		return b.create();

	}
}
