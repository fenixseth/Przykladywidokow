package com.androidbook.viewsamples;

import java.util.HashMap;
import java.util.Map;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public abstract class MenuActivity extends ListActivity {
	private Map<String, Object> actions = new HashMap<String, Object>();

	
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		String key = (String) l.getItemAtPosition(position);
		startActivity((Intent) actions.get(key));
	}
	
	/** Wywoływana przy pierwszym wykonaniu aktywności. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		prepareMenu();

		String[] keys = actions.keySet().toArray(
				new String[actions.keySet().size()]);

		setListAdapter(new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, keys));
	}
	
	public void addMenuItem(String label, Class<?> cls){
		actions.put(label, new Intent(this, cls	));
	}
	
	abstract void prepareMenu();
}
