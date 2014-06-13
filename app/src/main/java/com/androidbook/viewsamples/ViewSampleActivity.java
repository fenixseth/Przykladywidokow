package com.androidbook.viewsamples;

import android.content.Intent;
import android.util.Log;
import android.view.MenuItem;
import android.view.SubMenu;

public class ViewSampleActivity extends MenuActivity {
	public final static String debugTag = "ViewSample";

	void prepareMenu() {
		addMenuItem("Formularze", FormsActivity.class);
		addMenuItem("Wskaźniki", IndicatorsActivity.class);
		addMenuItem("Pojemniki", ContainersActivity.class);
		addMenuItem("Prezentacja tekstu", TextDisplayActivity.class);
		addMenuItem("Zdarzenia", EventsActivity.class);
	}


    @Override
public boolean onCreateOptionsMenu(
    android.view.Menu menu) {
     super.onCreateOptionsMenu(menu);
     
     menu.add("Formularze")
         .setIcon(android.R.drawable.ic_menu_edit)
         .setIntent(new Intent(this, FormsActivity.class));
     menu.add("Wskaźniki")
         .setIntent(new Intent(this, IndicatorsActivity.class))
         .setIcon(android.R.drawable.ic_menu_info_details);
     menu.add("Pojemniki")
         .setIcon(android.R.drawable.ic_menu_view)
         .setIntent(new Intent(this, ContainersActivity.class));
     SubMenu style_choice = menu.addSubMenu("Style")
                                 .setIcon(android.R.drawable.ic_menu_preferences);
     style_choice.add(style_group, light_id, 1, "Jasny").setChecked(isLight);
     style_choice.add(style_group, dark_id, 2, "Ciemny").setChecked(!isLight);
     
     style_choice.setGroupCheckable(style_group, true, true);
             
     Log.d(ViewSampleActivity.debugTag, "Wywołano metodę onCreateOptionsMenu()");
     
     return true;
}

    private static final int light_id = 1;
    private static final int dark_id = 2;
    private static final int style_group = 1;
    private boolean isLight = true;

    
    @Override
public boolean onOptionsItemSelected(
    MenuItem item) {
    
    if (item.getItemId() == light_id)
    {
       item.setChecked(true);
       isLight = true;
       return true;
    } else if (item.getItemId() == dark_id)
    {
        item.setChecked(true);
        isLight = false;
        return true;
    }
    
    return super.onOptionsItemSelected(item);
}

    
}