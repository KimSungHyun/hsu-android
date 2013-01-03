package com.example.numbergame;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class InputDialog extends Dialog {

	private EditText etInput;
	private Button btnOK;
	private Button btnCancel;
	private OnDismissListener listener;

	public InputDialog(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.inputdialog);
		this.setTitle("ют╥б");

		etInput = (EditText) findViewById(R.id.etInput);
		btnOK = (Button) findViewById(R.id.btnOK);
		btnCancel = (Button) findViewById(R.id.btnCancel);

		btnOK.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (listener == null) {
				} else {
					listener.onDismiss(InputDialog.this);
				}
				dismiss();
			}
		});

		btnCancel.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				dismiss();
			}
		});
	}

	public void setOnDismissListener(OnDismissListener listener) {
		this.listener = listener;
	}

	public String getReturnValue() {
		return etInput.getText().toString();
	}
}