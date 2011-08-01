/**
 * DialogActivity.java 2011-7-31 ����9:08:10
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
			setTitle("���԰�");
		}
	}

	private Dialog buildDialog1(Context context) {
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

	private Dialog buildDialog3(Context context) {
		LayoutInflater inflater = LayoutInflater.from(this);
		final View textEntryView = inflater.inflate(R.layout.dialog_text, null);
		AlertDialog.Builder builder = new AlertDialog.Builder(context);
		builder.setTitle("�������û���������");
		builder.setView(textEntryView);
		builder.setPositiveButton("ȷ��", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface arg0, int arg1) {
				setTitle("����ȷ��");
			}
		});
		builder.setNegativeButton("ȡ��", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				setTitle("����ȡ��");
			}
		});
		return builder.create();
	}

	private Dialog buildDialog4(Context context) {
		ProgressDialog d = new ProgressDialog(context);
		d.setTitle("��������");
		d.setMessage("���Ժ�!");
		return d;
	}
}
