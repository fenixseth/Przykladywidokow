package com.androidbook.viewsamples;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.Toast;

public class ContainersActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.containers);
		
		Button switch_button = (Button)findViewById(R.id.flip_button);
		final ImageSwitcher switcher = (ImageSwitcher) findViewById(R.id.img_switch);
		
		switch_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
        		Toast.makeText(ContainersActivity.this, "Zmieniamy...", Toast.LENGTH_SHORT).show();
        		switcher.showNext();
            }
        });
		
	}



}
