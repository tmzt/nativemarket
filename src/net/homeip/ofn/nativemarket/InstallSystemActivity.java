package net.homeip.ofn.nativemarket;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.TextView;

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
	};
}