package com.example.numbergame;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.Button;
import android.view.Window;
import android.view.View;

public class MainActivity extends Activity {
	
	Button start;
	Button rank;
	clickListener listener = new clickListener();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        start = (Button) findViewById(R.id.btnStart);
        rank = (Button) findViewById(R.id.btnRank);
        
        start.setOnClickListener(listener);
        rank.setOnClickListener(listener);
        
    } 

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
    class clickListener implements View.OnClickListener {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			if(v.getId() == R.id.btnStart){
//				Intent 
			}
			
		}
    }
    
}
