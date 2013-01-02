package com.example.numbergame;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Game extends Activity {

	final static int maxNum = 30;
	int currentNumber = 1;
	int nextNumber = 10;
	int buttonId[] = { R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4, R.id.btn5,
			R.id.btn6, R.id.btn7, R.id.btn8, R.id.btn9 };
	Button buttonView[] = new Button[9];

	Timer timer = new Timer();
	SimpleDateFormat simpleDateFormat = new SimpleDateFormat("mm:ss:SSS");
	long time = 0;
	
	TextView tvTime;
	TextView tvNumber;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.game);

		tvTime = (TextView) findViewById(R.id.tvTime);
		tvNumber = (TextView) findViewById(R.id.tvNumber);

		for (int i = 0; i < buttonId.length; i++) {
			Log.i("check", Integer.toString(i));
			buttonView[i] = (Button) findViewById(buttonId[i]);
		}

		timer.scheduleAtFixedRate(new TimerTask() {
			@Override
			public void run() {
				tvTime.post(new Runnable() {
					public void run() {
						time += 1;
						tvTime.setText(simpleDateFormat.format(time));
					}
				});
			}
		}, 0, 1);

		initGame();
	}

	public void initGame() {
		ArrayList<String> numberList = new ArrayList<String>();

		for (int i = 1; i <= buttonView.length; i++) {
			Log.i("check", String.valueOf(i));
			numberList.add(Integer.toString(i));
		}

		Collections.shuffle(numberList);
		for (int i = 0; i < numberList.size(); i++) {
			buttonView[i].setText(numberList.get(i));
		} 
	}

	public void onNumberButton(View v) {
		Log.i("onNumberButton", Integer.toString(v.getId()));
		Button tempButton = (Button)findViewById(v.getId());
		tempButton.setText(Integer.toString(nextNumber));
		nextNumber++;
		tvNumber.setText(Integer.toString(nextNumber));
		currentNumber++;
	}
}
