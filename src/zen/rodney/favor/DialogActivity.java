/**
 * DialogActivity.java 2011-7-31 下午9:08:10
 * AII Rights Reserved
 */

package zen.rodney.favor;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
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
		((Button) findViewById(R.id.dialog_button3)).setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				showDialog(3);
			}

		});
		((Button) findViewById(R.id.dialog_button4)).setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				showDialog(4);
			}

		});
	}

	@Override
	protected Dialog onCreateDialog(int id) {
		switch (id) {
		case 1:
			return buildDialog1(this);
		case 3:
			return buildDialog3(this);
		case 4:
			return buildDialog4(this);
		default:
			break;
		}
		return null;
	}

	@Override
	protected void onPrepareDialog(int id, Dialog dialog) {
		if (id == 1) {
			setTitle("测试啊");
		}
	}

	private Dialog buildDialog1(Context context) {
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

	private Dialog buildDialog3(Context context) {
		LayoutInflater inflater = LayoutInflater.from(this);
		final View textEntryView = inflater.inflate(R.layout.dialog_text, null);
		AlertDialog.Builder builder = new AlertDialog.Builder(context);
		builder.setTitle("请输入用户名和密码");
		builder.setView(textEntryView);
		builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface arg0, int arg1) {
				setTitle("点了确定");
			}
		});
		builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				setTitle("点了取消");
			}
		});
		return builder.create();
	}

	private Dialog buildDialog4(Context context) {
		ProgressDialog d = new ProgressDialog(context);
		d.setTitle("正在下载");
		d.setMessage("请稍候!");
		return d;
	}
}
