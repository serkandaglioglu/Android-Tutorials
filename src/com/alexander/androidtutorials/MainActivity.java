package com.alexander.androidtutorials;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity
{
	private Button		btnText;
	private Button		btnLayoutTutorial;
	private Button		btnVideoTutorial;
	private Button		btnAsyncTaskTutorial;
	private Button		btnTransitionTutorial;
	private Button		btnSeekBarTutorial;
	private WebView		webViewTest;
	private ListView	listViewTest;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		btnLayoutTutorial = (Button) findViewById(R.id.btnLayoutTutorial);
		btnText = (Button) findViewById(R.id.textViewTest);
		btnVideoTutorial = (Button) findViewById(R.id.btnVideoTutorial);
		btnAsyncTaskTutorial = (Button) findViewById(R.id.btnAsyncTaskTutorial);
		btnTransitionTutorial = (Button) findViewById(R.id.btnTransitionTutorial);
		btnSeekBarTutorial = (Button) findViewById(R.id.btnSeekBarTutorial);
		/*
		 * webViewTest = (WebView) findViewById(R.id.webView1);
		 * webViewTest.getSettings().setJavaScriptEnabled(true);
		 * webViewTest.loadUrl("http://www.tarihtenalintilar.com");
		 */

		/*
		 * ListView listViewText = (ListView) findViewById(R.id.listViewTest);
		 * final String[] countries = { "Türkiye", "Almanya", "Avusturya",
		 * "Amerika", "İngiltere", "Macaristan", "Yunanistan", "Rusya",
		 * "Suriye", "İran", "Irak", "Şili", "Brezilya", "Japonya",
		 * "Portekiz", "İspanya", "Makedonya", "Ukrayna", "İsviçre" };
		 * ArrayAdapter<String> countriesAdapter = new
		 * ArrayAdapter<String>(getApplicationContext(),
		 * android.R.layout.simple_list_item_2, android.R.id.text1, countries);
		 * listViewText.setAdapter(countriesAdapter);
		 * listViewText.setOnItemClickListener(new OnItemClickListener() {
		 * @Override
		 * public void onItemClick(AdapterView<?> parent, View view, int
		 * position, long id)
		 * {
		 * AlertDialog.Builder dialog = new
		 * AlertDialog.Builder(MainActivity.this);
		 * dialog.setMessage(countries[position]);
		 * dialog.setPositiveButton("Ok", new AlertDialog.OnClickListener() {
		 * @Override
		 * public void onClick(DialogInterface dialog, int which)
		 * {
		 * dialog.dismiss();
		 * }
		 * });
		 * dialog.create().show();
		 * }
		 * });
		 */

		btnText.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v)
			{
				Toast.makeText(getApplicationContext(), "Merhaba!", Toast.LENGTH_SHORT).show();

				SharedPreferences sp = getSharedPreferences("MyApp", Context.MODE_PRIVATE);
				SharedPreferences.Editor spEditor = sp.edit();
				spEditor.putBoolean("ilkCalisma", true);
				spEditor.commit();

				Intent intent = new Intent(MainActivity.this, TestActivity.class);
				intent.putExtra("Param1", 1);
				intent.putExtra("Param2", "Serkan");
				intent.putExtra("Param3", new String[] { "1", "2", "3" });
				startActivity(intent);
			}
		});

		btnLayoutTutorial.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v)
			{
				Intent intent = new Intent(MainActivity.this, LayoutTutorialActivity.class);
				startActivity(intent);
			}
		});

		btnVideoTutorial.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v)
			{
				startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.youtube.com/watch?v=AoS9VTSiwBA")));
				// Intent intent = new Intent(MainActivity.this,
				// VideoTutorialActivity.class);
				// startActivity(intent);
			}
		});

		btnAsyncTaskTutorial.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v)
			{
				Intent intent = new Intent(MainActivity.this, AsyncTaskTutorialActivity.class);
				startActivity(intent);
			}
		});

		btnTransitionTutorial.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v)
			{
				Intent intent = new Intent(MainActivity.this, TransitionTutorialActivity.class);
				startActivity(intent);
			}
		});

		btnSeekBarTutorial.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v)
			{
				Intent intent = new Intent(MainActivity.this, SeekBarTutorialActivity.class);
				startActivity(intent);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main1, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings)
		{
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

}
