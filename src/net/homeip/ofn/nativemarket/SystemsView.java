package net.homeip.ofn.nativemarket;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class SystemsView extends ListView {

	public SystemsView(Context context) {
		super(context);
	    setAdapter(new SystemsAdapter(getSystems()));
	    setTextFilterEnabled(true);
	}
	
    protected List<Map<String, Object>> getSystems() {
    	List<Map<String, Object>> systems = new ArrayList<Map<String, Object>>();
        Map<String, Object> item = new HashMap<String, Object>();
        item.put("icon", R.drawable.ubuntu);
        item.put("title", "Ubuntu 10.4 Natty Narwal Desktop");
        systems.add(item);
        return systems;
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
	    		View item = LayoutInflater.from(getContext()).inflate(R.layout.systemsitem, null);
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