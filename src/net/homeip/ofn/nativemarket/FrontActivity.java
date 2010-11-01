package net.homeip.ofn.nativemarket;

import android.app.TabActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TabHost;

public class FrontActivity extends TabActivity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TabHost tabHost = getTabHost();

        LayoutInflater.from(this).inflate(R.layout.tabs1, tabHost.getTabContentView(), true);

        
        tabHost.addTab(tabHost.newTabSpec("tab1")
                .setIndicator("Applications")
                .setContent(new TabHost.TabContentFactory() {
					public View createTabContent(String tag) {
						return new AppsView(FrontActivity.this);
					}
                }));
        tabHost.addTab(tabHost.newTabSpec("tab3")
                .setIndicator("Systems")
                .setContent(new TabHost.TabContentFactory() {
					public View createTabContent(String tag) {
						return new SystemsView(FrontActivity.this);
					}
                }));
        tabHost.addTab(tabHost.newTabSpec("tab3")
                .setIndicator("Desktops")
                .setContent(new TabHost.TabContentFactory() {
					public View createTabContent(String tag) {
						return new SystemsView(FrontActivity.this);
					}
                }));
    }    
}