package zen.rodney.favor;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.TabHost;

public class TabActivity extends android.app.TabActivity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setTitle("TabµÄÊµÀý");
		TabHost th = getTabHost();
		LayoutInflater.from(this).inflate(R.layout.tab, th.getTabContentView(), true);
		th.addTab(th.newTabSpec("tab1").setIndicator("tab11").setContent(R.id.view1));
		th.addTab(th.newTabSpec("tab2").setIndicator("tab22").setContent(R.id.view2));
		th.addTab(th.newTabSpec("tab3").setIndicator("tab33").setContent(R.id.view3));
	}
}
