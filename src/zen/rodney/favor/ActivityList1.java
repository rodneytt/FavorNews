package zen.rodney.favor;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ActivityList1 extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		ListView lv = new ListView(this);
		String[] data = { "开心", "校花", "色情" };
		lv.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, data));
		setContentView(lv);
	}
}
