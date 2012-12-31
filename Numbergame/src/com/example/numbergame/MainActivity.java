package com.example.numbergame;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

	Button start;
	Button rank;
	clickListener listener = new clickListener(); 
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        

        start = (Button)findViewById(R.id.start);
        rank  = (Button)findViewById(R.id.ranking);
        start.setOnClickListener(listener);
        rank.setOnClickListener(listener);
        }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
    class clickListener implements View.OnClickListener{
		
		@Override
		public void onClick(View v) {			
		    	if(v.getId() == R.id.start){
		    		Intent intent = new Intent(MainActivity.this, GameActivity.class);
		    		startActivity(intent);
		    	}
		    	else if(v.getId() == R.id.ranking){
		    		Intent intent = new Intent(MainActivity.this, RankActivity.class);
		    		startActivity(intent);    	
		    	}
		    };
		}
}
