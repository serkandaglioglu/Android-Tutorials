package com.alexander.adapters;

import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.alexander.androidtutorials.R;
import com.alexander.models.UserModel;

public class TestAdapter extends BaseAdapter
{
	private LayoutInflater	inflater;
	private List<UserModel>	users;

	public TestAdapter(Activity activity, List<UserModel> users)
	{
		inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		this.users = users;
	}

	@Override
	public int getCount()
	{
		return users.size();
	}

	@Override
	public UserModel getItem(int pos)
	{
		return users.get(pos);
	}

	@Override
	public long getItemId(int pos)
	{
		UserModel user = this.getItem(pos);
		return user.UserId;
	}

	@Override
	public View getView(int pos, View convertView, ViewGroup parentView)
	{
		View rowView = inflater.inflate(R.layout.test_list_view_row, null);
		TextView textViewName = (TextView) rowView.findViewById(R.id.full_name);
		TextView textViewAbout = (TextView) rowView.findViewById(R.id.about);
		ImageView imageViewAvatar = (ImageView) rowView.findViewById(R.id.avatar);
		
		UserModel user = this.getItem(pos);
		
		LinearLayout l = (LinearLayout) rowView.findViewById(R.id.row_container);
		if (pos==0)
		{
			l.setPadding(0, 0, 0, 0);			
		}
		
		textViewName.setText(user.FullName);
		textViewAbout.setText(user.About);
		imageViewAvatar.setImageResource(R.drawable.test);
		
		return rowView;
	}

}
