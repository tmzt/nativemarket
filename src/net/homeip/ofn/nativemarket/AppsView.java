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

public class AppsView extends ListView {
	
    public AppsView(Context context) {
		super(context);
	    setAdapter(new AppsAdapter(getApps()));  
	    setTextFilterEnabled(true);
	}

	protected List<Map<String, Object>> getApps() {
    	List<Map<String, Object>> apps = new ArrayList<Map<String, Object>>();
        Map<String, Object> item = new HashMap<String, Object>();
        item.put("icon", R.drawable.abiword_48);
        item.put("title", "Abiword - Word Processor");
        apps.add(item);
        item = new HashMap<String, Object>();
        item.put("icon", R.drawable.chromiumbsu);
        item.put("title", "Chromium BSU - Space Shooter");       
        apps.add(item);
        return apps;
    }
	
	class AppsAdapter extends BaseAdapter {
    	private List<Map<String, Object>> mApps;
    	
    	public Map<String, Object> getItem(int position) {
    		return mApps.get(position);
    	}
    	
    	public AppsAdapter(List<Map<String,Object>> systems) {
    		mApps = systems;
    	}
    	
    	public View getView(int position, View convertView, ViewGroup parent) {
            Map<String,Object> info = mApps.get(position % mApps.size());
    		View item = LayoutInflater.from(getContext()).inflate(R.layout.appsitem, null);
    		ImageView i = (ImageView)item.findViewById(R.id.appsitemicon);
    		TextView tv = (TextView)item.findViewById(R.id.appsitemtitle);
            Drawable icon = getResources().getDrawable(((Integer)(mApps.get(position).get("icon"))).intValue());
            i.setImageDrawable(icon);
//          i.setScaleType(ImageView.ScaleType.FIT_CENTER);
//          final int w = (int) (36 * AppsView.this.getResources().getDisplayMetrics().density + 0.5f);
//          i.setLayoutParams(new GridView.LayoutParams(w, w));
            tv.setText((String)info.get("title"));
            return item;
    	}
    	
        public final int getCount() { return mApps.size(); }

        public final long getItemId(int position) {
            return position;
        }

	}
}