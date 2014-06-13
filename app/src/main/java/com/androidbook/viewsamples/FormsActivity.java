package com.androidbook.viewsamples;

public class FormsActivity extends MenuActivity {

	@Override
	void prepareMenu() {
		addMenuItem("Wprowadzanie tekstu", TextInputActivity.class);
		addMenuItem("Przyciski", ButtonsActivity.class);
		addMenuItem("Wybieranie", PickersActivity.class);
		
	}

}
