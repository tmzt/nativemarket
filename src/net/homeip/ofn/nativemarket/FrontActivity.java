package net.homeip.ofn.nativemarket;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.TabActivity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TextView;

public class FrontActivity extends TabActivity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TabHost tabHost = getTabHost();

        LayoutInflater.from(this).inflate(R.layout.tabs1, tabHost.getTabContentView(), true);

        
        tabHost.addTab(tabHost.newTabSpec("tab1")
                .setIndicator("Applications")
                /*.setContent(R.id.view1));*/
                .setContent(new TabHost.TabContentFactory() {
					public View createTabContent(String tag) {
//				        ListView apps = new ListView(FrontActivity.this);
//				        LayoutInflater.from(FrontActivity.this).inflate(R.layout.appsview, apps, false);
//				        return apps;
						return new AppsView(FrontActivity.this);
					}
                }));
        tabHost.addTab(tabHost.newTabSpec("tab3")
                .setIndicator("Systems")
                .setContent(R.id.view2));
        tabHost.addTab(tabHost.newTabSpec("tab3")
                .setIndicator("Desktops")
                .setContent(R.id.view3));

//	    ViewGroup apps = (ViewGroup)findViewById(R.id.view1);
//   	    apps.setAdapter(new AppsAdapter(getApps()));  
//   	    apps.setTextFilterEnabled(true);
//        LayoutInflater.from(this).inflate(R.layout.appsview, apps, false);

        
	    ListView systems = (ListView)findViewById(R.id.view2);
	    
/*
	    systems.setAdapter(new SimpleAdapter(this, getSystems(),
	            R.layout.systemsitem, new String[] { "title" },
	            new int[] { 0 }));
*/
	    systems.setAdapter(new SystemsAdapter(getSystems()));
	    
	    systems.setTextFilterEnabled(true);
	    
	    ListView desktops = (ListView)findViewById(R.id.view3);
	    desktops.setAdapter(new DesktopsAdapter(getDesktops()));
	    desktops.setTextFilterEnabled(true);

    }


    
    protected List<Map<String, Object>> getSystems() {
    	List<Map<String, Object>> systems = new ArrayList<Map<String, Object>>();
        Map<String, Object> item = new HashMap<String, Object>();
        item.put("icon", R.drawable.ubuntu);
        item.put("title", "Ubuntu 10.4 Natty Narwal Desktop");
        systems.add(item);
        return systems;
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
    
    public class SystemsAdapter extends BaseAdapter {
    	private List<Map<String, Object>> mSystems;
    	
    	public Map<String, Object> getItem(int position) {
    		return mSystems.get(position);
    	}
    	
    	public SystemsAdapter(List<Map<String,Object>> systems) {
    		mSystems = systems;
    	}
    	    	
    	public View getView(int position, View convertView, ViewGroup parent) {
            Map<String,Object> info = mSystems.get(position % mSystems.size());
    		
    		View item = LayoutInflater.from(FrontActivity.this).inflate(R.layout.systemsitem, null);
    		ImageView i = (ImageView)item.findViewById(R.id.systemsitemicon);
    		TextView tv = (TextView)item.findViewById(R.id.systemsitemtitle);
            Drawable icon = FrontActivity.this.getResources().getDrawable(((Integer)(mSystems.get(position).get("icon"))).intValue());
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

    public class DesktopsAdapter extends BaseAdapter {
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
            
    		View item = LayoutInflater.from(FrontActivity.this).inflate(R.layout.desktopsitem, null);
    		ImageView i = (ImageView)item.findViewById(R.id.desktopsitemicon);
    		TextView tv = (TextView)item.findViewById(R.id.desktopsitemtitle);
    		if (info.containsKey("icon")) {
    			icon = FrontActivity.this.getResources().getDrawable(((Integer)(info.get("icon"))).intValue());
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