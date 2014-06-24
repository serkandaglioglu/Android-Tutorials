package com.alexander.androidtutorials;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class LayoutTutorialActivity extends Activity
{

	Button	btnShowHorizontalTutorial;
	Button	btnShowVerticalTutorial;
	Button	btnShowWeightTutorial;
	Button	btnShowGravityTutorial;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_layout_tutorial);

		btnShowHorizontalTutorial = (Button) findViewById(R.id.btn_show_horizantal_example);
		btnShowVerticalTutorial = (Button) findViewById(R.id.btn_show_vertical_example);
		btnShowWeightTutorial = (Button) findViewById(R.id.btn_show_weight_example);
		btnShowGravityTutorial = (Button) findViewById(R.id.btn_show_gravity_example);

		btnShowHorizontalTutorial.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v)
			{
				Intent intent = new Intent(LayoutTutorialActivity.this, LayoutTutorial2Activity.class);
				intent.putExtra("tutorial", 1);
				startActivity(intent);
			}
		});
		btnShowVerticalTutorial.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v)
			{
				Intent intent = new Intent(LayoutTutorialActivity.this, LayoutTutorial2Activity.class);
				intent.putExtra("tutorial", 2);
				startActivity(intent);
			}
		});
		btnShowWeightTutorial.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v)
			{
				Intent intent = new Intent(LayoutTutorialActivity.this, LayoutTutorial2Activity.class);
				intent.putExtra("tutorial", 3);
				startActivity(intent);
			}
		});
		btnShowGravityTutorial.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v)
			{
				Intent intent = new Intent(LayoutTutorialActivity.this, LayoutTutorial2Activity.class);
				intent.putExtra("tutorial", 4);
				startActivity(intent);
			}
		});
	}
}
