package com.example.numbergame;



import java.util.Timer;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GameActivity extends Activity {	

	TextView[] Tv = new TextView[3];
	int[] RedIdTv = { R.id.num, R.id.min, R.id.sec};
	
	Button[] btn = new Button[10];
	int btnId[] = { R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4, R.id.btn5, R.id.btn6, R.id.btn7,
			R.id.btn8, R.id.btn9, R.id.btn10};
	clicklistener Cl = new clicklistener();
	
	Timer timer;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game);
        
        for(int i=1;i<11;i++){
    		btn[i] = (Button)findViewById(btnId[i]);
    	}
        
    }	
	
	class clicklistener implements View.OnClickListener{
		int num = 1, min = 0, sec = 0;
		

		@Override
		public void onClick(View v) {
			if(v.getId() == R.id.btn1){
								
			}
		}
		
	}
	
}
