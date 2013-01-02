package com.example.numbergame;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import java.text.SimpleDateFormat;
import java.util.Timer;
import java.util.TimerTask;

public class GameActivity extends Activity {
	
	TextView timeView;
	TextView numView;
	
	Timer timer = new Timer();	
	SimpleDateFormat simpleDateFormat = new SimpleDateFormat("mm:ss:S");	
	long time = 0;
	
	int currentNum = 1;
	
	Button[] button = new Button[10];
	int buttonId[] = {R.id.Button01, R.id.Button02, R.id.Button03,
			R.id.Button04, R.id.Button05, R.id.Button06, R.id.Button07,
			R.id.Button08, R.id.Button09};
	
	clickListener listener = new clickListener();
	
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);        
        setContentView(R.layout.game);
        
        numView = (TextView) findViewById(R.id.currentNum);
        timeView = (TextView) findViewById(R.id.time);
       
        for(int i =0; i<buttonId.length ; i++){
        	button[i] = (Button) findViewById(buttonId[i]);
       	button[i].setOnClickListener(listener);
        }
        numView.setText(Integer.toString(currentNum));
      
        timer.scheduleAtFixedRate(new TimerTask() {
			public void run() {				
				timeView.post(new Runnable() {
					public void run() {					
						time += 1;						
						timeView.setText(simpleDateFormat.format(time));			
						}			
					});			
				}		
			}, 0, 10);       
        
    }
    
    
    
    class clickListener implements View.OnClickListener {

		@Override
		public void onClick(View v) {
			if(v.getId() == R.id.Button01){
				if(currentNum == Integer.parseInt(button[0].getText().toString())){
					if(currentNum <20){
						button[0].setText(Integer.toString(currentNum+9));
						currentNum++;
						numView.setText(Integer.toString(currentNum));
					}
					else
						numView.setText("");
				}
				else {
					Toast.makeText(getApplication(), "잘못된숫자입니다.",
							Toast.LENGTH_SHORT).show();
				}
			}
			else if(v.getId() == R.id.Button02){
				if(currentNum == Integer.parseInt(button[1].getText().toString())){
					button[1].setText(Integer.toString(currentNum+9));
					currentNum++;					
					if(currentNum <11){
						numView.setText(Integer.toString(currentNum));
					}
					else
						numView.setText("");
				}
				else{
					Toast.makeText(getApplication(), "잘못된숫자입니다.",
							Toast.LENGTH_SHORT).show();
				}
				
			}

			else if(v.getId() == R.id.Button03){
				if(currentNum == Integer.parseInt(button[2].getText().toString())){
					if(currentNum <11){
						button[2].setText(Integer.toString(currentNum+9));
						currentNum++;
						numView.setText(Integer.toString(currentNum));
					}
					else
						numView.setText("");
				}
				else{
					Toast.makeText(getApplication(), "잘못된숫자입니다.",
							Toast.LENGTH_SHORT).show();
				}
				
			}
			else if(v.getId() == R.id.Button04){
				if(currentNum == Integer.parseInt(button[3].getText().toString())){
					if(currentNum <11){
						button[3].setText(Integer.toString(currentNum+9));
						currentNum++;
						numView.setText(Integer.toString(currentNum));
					}
					else
						numView.setText("");
				}
				else{
					Toast.makeText(getApplication(), "잘못된숫자입니다.",
							Toast.LENGTH_SHORT).show();
				}
				
			}
			else if(v.getId() == R.id.Button05){
				if(currentNum == Integer.parseInt(button[4].getText().toString())){
					if(currentNum <11){
						button[4].setText(Integer.toString(currentNum+9));
						currentNum++;
						numView.setText(Integer.toString(currentNum));
					}
					else
						numView.setText("");
				}
				else{
					Toast.makeText(getApplication(), "잘못된숫자입니다.",
							Toast.LENGTH_SHORT).show();
				}
				
			}
			else if(v.getId() == R.id.Button06){
				if(currentNum == Integer.parseInt(button[5].getText().toString())){
					if(currentNum <11){
						button[5].setText(Integer.toString(currentNum+9));
						currentNum++;
						numView.setText(Integer.toString(currentNum));
					}
					else
						numView.setText("");
				}
				else{
					Toast.makeText(getApplication(), "잘못된숫자입니다.",
							Toast.LENGTH_SHORT).show();
				}
				
			}
			else if(v.getId() == R.id.Button07){
				if(currentNum == Integer.parseInt(button[6].getText().toString())){
					if(currentNum <11){
						button[6].setText(Integer.toString(currentNum+9));
						currentNum++;
						numView.setText(Integer.toString(currentNum));
					}
					else
						numView.setText("");
				}
				else{
					Toast.makeText(getApplication(), "잘못된숫자입니다.",
							Toast.LENGTH_SHORT).show();
				}
				
			}
			else if(v.getId() == R.id.Button08){
				if(currentNum == Integer.parseInt(button[7].getText().toString())){
					if(currentNum <11){
						button[7].setText(Integer.toString(currentNum+9));
						currentNum++;
						numView.setText(Integer.toString(currentNum));
					}
					else
						numView.setText("");
				}
				else{
					Toast.makeText(getApplication(), "잘못된숫자입니다.",
							Toast.LENGTH_SHORT).show();
				}
				
			}
			else if(v.getId() == R.id.Button09){
				if(currentNum == Integer.parseInt(button[8].getText().toString())){
					if(currentNum <11){
						button[8].setText(Integer.toString(currentNum+9));
						currentNum++;
						numView.setText(Integer.toString(currentNum));
					}
					else
						numView.setText("");
						
				}
				else{
					Toast.makeText(getApplication(), "잘못된숫자입니다.",
							Toast.LENGTH_SHORT).show();
				}
				
			}
		}
    	
    }
}
