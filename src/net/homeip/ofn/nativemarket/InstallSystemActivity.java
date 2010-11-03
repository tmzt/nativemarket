package net.homeip.ofn.nativemarket;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.ViewFlipper;

public class InstallSystemActivity extends Activity {

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        setContentView(LayoutInflater.from(this).inflate(R.layout.installsystem, null, true));
		ImageView i = (ImageView)findViewById(R.id.installsystemicon);
		TextView tv = (TextView)findViewById(R.id.installsystemtitle);
        Drawable icon = getResources().getDrawable(((Integer)(getIntent().getExtras().get("icon"))).intValue());
        i.setImageDrawable(icon);
//          i.setScaleType(ImageView.ScaleType.FIT_CENTER);
//          final int w = (int) (36 * FrontActivity.this.getResources().getDisplayMetrics().density + 0.5f);
//          i.setLayoutParams(new GridView.LayoutParams(w, w));
        tv.setText((String)getIntent().getExtras().get("title"));
        
        /* page 2 */
        Spinner destvol = (Spinner)findViewById(R.id.installsystemdestvolume);
        destvol.setAdapter(new DestVolsAdapter(getDestVols()));
        
        Button prev = (Button)findViewById(R.id.installsystemprev);
        prev.setOnClickListener(new OnClickListener(){
			public void onClick(View v) {
		        ViewFlipper flip = (ViewFlipper)findViewById(R.id.installsystemflip);
				flip.showNext();
			}
        });
        
        Button next = (Button)findViewById(R.id.installsystemnext);
        next.setOnClickListener(new OnClickListener(){
			public void onClick(View v) {
		        ViewFlipper flip = (ViewFlipper)findViewById(R.id.installsystemflip);
				flip.showNext();
			}
        });
	};
	
    protected List<Map<String, Object>> getDestVols() {
    	List<Map<String, Object>> destvols = new ArrayList<Map<String, Object>>();
        Map<String, Object> item = new HashMap<String, Object>();
        item.put("title", "Internal Volume");
        item.put("name", "data");
        destvols.add(item);
        item = new HashMap<String,Object>();
        item.put("title", "Removable Volume");
        item.put("name", "sdcard");
        destvols.add(item);
        return destvols;
    }
	
	class DestVolsAdapter extends BaseAdapter {
    	private List<Map<String, Object>> mDestVols;
    	
    	public Map<String, Object> getItem(int position) {
    		return mDestVols.get(position);
    	}
    	
    	public DestVolsAdapter(List<Map<String,Object>> destvols) {
    		mDestVols = destvols;
    	}
    	    	
    	public View getView(int position, View convertView, ViewGroup parent) {
            Map<String,Object> info = mDestVols.get(position % mDestVols.size());
    		//View item = LayoutInflater.from(getBaseContext()).inflate(R.layout.installsystemsdestvolitem, null);
    		//TextView tv = (TextView)item.findViewById(R.id.installsystemdestvoltitle);
            TextView tv = new TextView(InstallSystemActivity.this);
            tv.setText((String)info.get("title"));
            return tv;
    	}
        
        public final int getCount() { return mDestVols.size(); }

        public final long getItemId(int position) {
            return position;
        }

    }

}
