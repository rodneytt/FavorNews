/**
 * ActivityList2.java 2011-7-30 ����10:06:58
 * AII Rights Reserved
 */

package zen.rodney.favor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class ActivityList2 extends Activity {
	private List<Map<String, Object>> data;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		prepareData();
		ListView lv = new ListView(this);
		SimpleAdapter sa = new SimpleAdapter(this, data, R.layout.listitem, new String[] { "����",
				"�Ա�" }, new int[] { R.id.mvName, R.id.mvSex });
		lv.setAdapter(sa);
		setContentView(lv);
		lv.setOnItemClickListener(listen);
	}

	private void prepareData() {
		data = new ArrayList<Map<String, Object>>();
		Map<String, Object> item;
		item = new HashMap<String, Object>();
		item.put("����", "����");
		item.put("�Ա�", "��");
		data.add(item);
		item = new HashMap<String, Object>();
		item.put("����", "����");
		item.put("�Ա�", "Ů");
		data.add(item);
	}

	private OnItemClickListener listen = new OnItemClickListener() {

		@Override
		public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt,
				long paramLong) {
			System.out.println(paramView.getId()+":"+paramInt+":"+paramLong);
			setTitle(paramAdapterView.getItemAtPosition(paramInt).toString());
		}
	};
}
