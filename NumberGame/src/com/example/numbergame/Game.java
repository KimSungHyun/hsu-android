package com.example.numbergame;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.os.Bundle;
import android.text.format.Time;
import android.widget.TextView;

public class Game extends Activity {
	Time t = new Time();
	long time = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.game);

		final TextView tvTime = (TextView) findViewById(R.id.tvTime);

//		TimerTask timerTask = new TimerTask() {
//
//			@Override
//			public void run() {
//				// TODO Auto-generated method stub
//				time += 1000;
//				t.set(time);
//				tvTime.setText(t.minute + ":" + t.second);
//			}
//		};
		
		Timer timer = new Timer();
		//t.setToNow();
		time = t.toMillis(true);
		time += 1000;
		t.set(time);
		tvTime.setText(t.minute + ":" + t.second);
		
		//timer.schedule(timerTask, 500, 1000);
	}
}
