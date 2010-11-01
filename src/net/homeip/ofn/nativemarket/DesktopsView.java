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

public class DesktopsView extends ListView {

	public DesktopsView(Context context) {
		super(context);
	    setAdapter(new DesktopsAdapter(getDesktops()));
	    setTextFilterEnabled(true);
	}
	
    protected List<Map<String, Object>> getDesktops() {
    	List<Map<String, Object>> desktops = new ArrayList<Map<String, Object>>();
        Map<String, Object> item = new HashMap<String, Object>();
        item.put("title", "LXDE - Lightweight Desktop");
        desktops.add(item);
        item = new HashMap<String, Object>();
        item.put("title", "Ubuntu Gnome - Full Desktop (needs apps installed)");
        desktops.add(item);
        item = new HashMap<String, Object>();
        item.put("title", "Kubuntu");
        desktops.add(item);
        item = new HashMap<String, Object>();
        item.put("title", "Meego (needs GL support)");
        desktops.add(item);
        item = new HashMap<String, Object>();
        item.put("title", "FreeSmartphone");
        desktops.add(item);
        return desktops;
    }
	
	class DesktopsAdapter extends BaseAdapter {
	    	private List<Map<String, Object>> mDesktops;
	    	
	    	public Map<String, Object> getItem(int position) {
	    		return mDesktops.get(position);
	    	}
	    	
	    	public DesktopsAdapter(List<Map<String,Object>> desktops) {
	    		mDesktops = desktops;
	    	}
	    	
	    	public View getView(int position, View convertView, ViewGroup parent) {
	            Map<String,Object> info = mDesktops.get(position % mDesktops.size());
	    		Drawable icon = null;
	            
	    		View item = LayoutInflater.from(getContext()).inflate(R.layout.desktopsitem, null);
	    		ImageView i = (ImageView)item.findViewById(R.id.desktopsitemicon);
	    		TextView tv = (TextView)item.findViewById(R.id.desktopsitemtitle);
	    		if (info.containsKey("icon")) {
	    			icon = getResources().getDrawable(((Integer)(info.get("icon"))).intValue());
	                i.setImageDrawable(icon);
	//              i.setScaleType(ImageView.ScaleType.FIT_CENTER);
	//              final int w = (int) (36 * FrontActivity.this.getResources().getDisplayMetrics().density + 0.5f);
	//              i.setLayoutParams(new GridView.LayoutParams(w, w));
	    		}
	    		if (info.containsKey("title")) {
	    			tv.setText((String)(info.get("title")));
	    		};
	            return item;
	    	}
	        
	        public final int getCount() { return mDesktops.size(); }
	
	        public final long getItemId(int position) {
	            return position;
	        }
	
	    }
}
