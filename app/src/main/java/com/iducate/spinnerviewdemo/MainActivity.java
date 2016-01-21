package com.iducate.spinnerviewdemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends Activity {

	private String[] items = { " Item 0", "Item 1", "Item 2", "Item 3", "Item 4",
			"Item 5", "Item 6", "Item 7" };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Spinner spinner = (Spinner) findViewById(R.id.spinner1);

		//we use a predefined simple spinner drop down, 
		//you could define your own layout, so that for instance
		//there was pictures in the drop down list.
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_dropdown_item, items);
 
		spinner.setAdapter(adapter);

		spinner.setOnItemSelectedListener(new OnItemSelectedListener() {

		//The AdapterView<?> type means that this can be any type,
	    //so we can use both AdapterView<String> or any other
			@Override
			public void onItemSelected(AdapterView<?> adapterView, View view,
					int position, long id) {
				Toast.makeText(MainActivity.this,
						"Item selected: " + items[position], Toast.LENGTH_SHORT)
						.show();
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO you would normally do something here
				// for instace setting the selected item to "null"
				// or something. 
			}
		});
	}
}
