package com.alexander.androidtutorials;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;

public class SeekBarTutorialActivity extends Activity
{
	SeekBar			seekBarBgColor;
	RelativeLayout	layoutBgColor;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_seek_bar_tutorial);

		layoutBgColor = (RelativeLayout) findViewById(R.id.layoutBg);
		seekBarBgColor = (SeekBar) findViewById(R.id.seekBarBgColor);
		
		// seekBarBgColor.setBackgroundColor(Color.TRANSPARENT);
		

		seekBarBgColor.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
			@Override
			public void onStopTrackingTouch(SeekBar arg0)
			{
			}

			@Override
			public void onStartTrackingTouch(SeekBar arg0)
			{
			}

			@Override
			public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser)
			{
				seekBar.setMax(255);
				int bg = android.graphics.Color.rgb(progress, 0, 0);
				layoutBgColor.setBackgroundColor(bg);
				;
			}
		});
	}
}
