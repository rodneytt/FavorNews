/**
 * DialogActivity.java 2011-7-31 下午9:08:10
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
		b.setTitle("对话框");
		b.setMessage("这是一个对话框?");
		b.setPositiveButton("确定", new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				setTitle("单击对话框中的确定按钮");
			}
		});
		b.setNegativeButton("取消", new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				setTitle("单击了对话框中的取消按钮");
			}
		});
		return b.create();

	}
}
