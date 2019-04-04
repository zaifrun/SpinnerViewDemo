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

	//you can also put these values in xml - the book shows how.
	private String[] items = { "Item 0", "Item 1", "Item 2", "Item 3", "Item 4",
			"Item 5", "Item 6", "Item 7" };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		//The spinner is defined in our xml file
		Spinner spinner = findViewById(R.id.spinner1);
		Spinner spinner2 = findViewById(R.id.spinner2);


		//we use a predefined simple spinner drop down, 
		//you could define your own layout, so that for instance
		//there was pictures in the drop down list.
		ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
				android.R.layout.simple_spinner_dropdown_item, items);

		spinner.setAdapter(adapter);

		spinner.setOnItemSelectedListener(new OnItemSelectedListener() {

			//The AdapterView<?> type means that this can be any type,
			//so we can use both AdapterView<String> or any other
			@Override
			public void onItemSelected(AdapterView<?> adapterView, View view,
									   int position, long id) {
				//So this code is called when ever the spinner is clicked
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

		//here is another way of initializing a spinner - getting the resources
		//from the xml values file
		ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(
				this, R.array.spinner_array, android.R.layout.simple_spinner_dropdown_item);

		spinner2.setAdapter(adapter2);
		spinner2.setOnItemSelectedListener(new OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
				//String test = getResources().getString(R.string.hello_world);
			    String[] listArray = getResources().getStringArray(R.array.spinner_array);
				Toast.makeText(MainActivity.this,
						"Item selected: " + listArray[position], Toast.LENGTH_SHORT)
						.show();
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {

			}
		});

		//This line of code can always be used to get the
		//selected position in in the spinner - the first item
		//will have an index of 0.
		int position = spinner.getSelectedItemPosition();

		//This line will get the actual seleted item -
		//in our case the values in the spinner is simply
		//strings, so we need to make a cast to a String
		String item = (String) spinner.getSelectedItem();
	}
}
