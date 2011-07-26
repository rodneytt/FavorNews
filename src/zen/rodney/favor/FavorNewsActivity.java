package zen.rodney.favor;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class FavorNewsActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        find_and_modify_button();
    }
    private void find_and_modify_button(){
    	Button button = (Button)findViewById(R.id.button);
    	button.setOnClickListener(button_listen);
    }
    private OnClickListener button_listen = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			setTitle("哎呦，button被点了一下");
		}
	};
}