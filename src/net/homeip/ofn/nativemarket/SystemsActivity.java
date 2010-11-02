package net.homeip.ofn.nativemarket;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Dialog;
import android.app.ListActivity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

public class SystemsActivity extends ListActivity implements OnItemClickListener {

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		//Dialog d = new Dialog(LayoutInflater.from(getContext()).inflate(R.layout.systemsrootmsg, null, false), 100, 100, true);
		Dialog d = new Dialog(this);
		d.setContentView(R.layout.systemsrootmsg);
		d.show();
		
	    setListAdapter(new SystemsAdapter(getSystems()));
	    getListView().setTextFilterEnabled(true);
	    getListView().setOnItemClickListener(this);
	}
	
    protected List<Map<String, Object>> getSystems() {
    	List<Map<String, Object>> systems = new ArrayList<Map<String, Object>>();
        Map<String, Object> item = new HashMap<String, Object>();
        item.put("icon", R.drawable.ubuntu);
        item.put("title", "Ubuntu 10.4 Natty Narwal Desktop");
        systems.add(item);
        return systems;
    }

	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		Intent intent = new Intent().setClass(this, InstallSystemActivity.class);
		intent.putExtra("title", (String)((Map<String,Object>)(getListView().getAdapter().getItem(position))).get("title"));
		intent.putExtra("icon", ((Integer) ((Map<String,Object>)(getListView().getAdapter().getItem(position))).get("icon")).intValue());
		startActivity(intent);
	}
    
	class SystemsAdapter extends BaseAdapter {
	    	private List<Map<String, Object>> mSystems;
	    	
	    	public Map<String, Object> getItem(int position) {
	    		return mSystems.get(position);
	    	}
	    	
	    	public SystemsAdapter(List<Map<String,Object>> systems) {
	    		mSystems = systems;
	    	}
	    	    	
	    	public View getView(int position, View convertView, ViewGroup parent) {
	            Map<String,Object> info = mSystems.get(position % mSystems.size());
	    		View item = LayoutInflater.from(getBaseContext()).inflate(R.layout.systemsitem, null);
	    		ImageView i = (ImageView)item.findViewById(R.id.systemsitemicon);
	    		TextView tv = (TextView)item.findViewById(R.id.systemsitemtitle);
	            Drawable icon = getResources().getDrawable(((Integer)(mSystems.get(position).get("icon"))).intValue());
	            i.setImageDrawable(icon);
	//          i.setScaleType(ImageView.ScaleType.FIT_CENTER);
	//          final int w = (int) (36 * FrontActivity.this.getResources().getDisplayMetrics().density + 0.5f);
	//          i.setLayoutParams(new GridView.LayoutParams(w, w));
	            tv.setText((String)info.get("title"));
	            return item;
	    	}
	        
	        public final int getCount() { return mSystems.size(); }
	
	        public final long getItemId(int position) {
	            return position;
	        }
	
	    }



}
