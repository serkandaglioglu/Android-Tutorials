package com.alexander.androidtutorials;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class LayoutTutorial2Activity extends Activity
{

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		// setContentView(R.layout.activity_layout_tutorial2);
		
		int tutorial = getIntent().getIntExtra("tutorial", 0);

		switch (tutorial)
		{
			case 1:
				setContentView(R.layout.activity_linear_layout_horizontal);
				break;
			case 2:
				setContentView(R.layout.activity_linear_layout_vertical);
				break;
			case 3:
				setContentView(R.layout.activity_linear_layout_weight);
				break;
			case 4:
				setContentView(R.layout.activity_linear_layout_gravity);
				break;

			default:
				break;
		}
	}
}
