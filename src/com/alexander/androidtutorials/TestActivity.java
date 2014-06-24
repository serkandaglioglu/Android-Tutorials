package com.alexander.androidtutorials;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ListView;

import com.alexander.adapters.TestAdapter;
import com.alexander.models.UserModel;

public class TestActivity extends Activity
{
	private List<UserModel>	users	= new ArrayList<UserModel>();
	private ListView listViewTest;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_test);

		listViewTest = (ListView) findViewById(R.id.listViewTest);
		
		users.add(new UserModel(1, "Serkan", "", "Bilgisayar Mühendisi"));
		users.add(new UserModel(2, "Fırat Özdemir", "", "Gıda Mühendisi"));
		users.add(new UserModel(3, "Fatih Türker", "", "Bilgisayar Mühendisi"));
		users.add(new UserModel(4, "Abdurrahman Koçak", "", "Bilgisayar Mühendisi"));
		users.add(new UserModel(5, "Ali Türker", "", "Grafik Tasarımcı"));
		users.add(new UserModel(6, "Ammar Jabakji", "", "Computer Engineer"));
		
		UserModel u = users.get(2);
		TestAdapter adapter = new TestAdapter(this, users);
		listViewTest.setAdapter(adapter);
		
		Bundle bundle = getIntent().getExtras();
		String[] arr = bundle.getStringArray("Param3");
		

		SharedPreferences sp = getSharedPreferences("MyApp", Context.MODE_PRIVATE);
		boolean ilkCalisma = sp.getBoolean("ilkCalisma", false);

	}
}
