package com.example.abslistviewexample;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	AbsListView absListView;

	static String[] listItems = { "First Item", "Second Item", "Third Item",
			"Fourth Item", "Fifth Item", "Sixth Item", "Seventh Item",
			"Eight Item", "Ninth Item", "Tenth Item" };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		absListView = (AbsListView) findViewById(R.id.listView1);
		
		absListView.setAdapter( new MyArrayAdapter(this, R.layout.row, listItems));
	}

	
	private class MyArrayAdapter extends ArrayAdapter<String>{

		public MyArrayAdapter(Context context, int resource,
				String[] values) {
			super(context, resource, values);	
		}
		
		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			LayoutInflater inflater = (LayoutInflater) getContext()
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			View view = inflater.inflate(R.layout.row, parent, false);
			TextView textView = (TextView) view.findViewById(R.id.textView1);
			ImageView imageView = (ImageView) view.findViewById(R.id.imageView1);
			
			textView.setText( getItem(position));
			
			return view;
		}
	}
}
