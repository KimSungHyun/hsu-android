package com.example.numbergame;

import java.util.ArrayList;
import java.util.HashMap;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class RankList extends Activity {

	ArrayList<HashMap<String,String>> arrayList = new ArrayList<HashMap<String, String>>();
	HashMap<String, String> tempMap = new HashMap<String, String>();
	DBManager rank;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.rank);
		
		ListView lv = (ListView)findViewById(R.id.list);
		
		rank = new DBManager(this);
		
		for(int i = 0; i < rank.getData().size(); i++)
		{
			tempMap.put("Id", Integer.toString(rank.getData().get(i).getId()));
			tempMap.put("Name", rank.getData().get(i).getName());
			tempMap.put("Time", Long.toString(rank.getData().get(i).getTime()));
			
			arrayList.add(tempMap);
		}
		
		SimpleAdapter sa = new SimpleAdapter(this, arrayList, R.layout.listrow, new String[] {"Id", "Name", "Time"}, new int[] {R.id.tvId, R.id.tvName, R.id.tvTime});
		lv.setAdapter(sa);
	}
}
