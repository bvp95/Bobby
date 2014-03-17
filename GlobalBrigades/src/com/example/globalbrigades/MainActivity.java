package com.example.globalbrigades;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class MainActivity extends Activity {

	EditText username;
	EditText password;
	String[] usernames;
	String[] passwords;
	AlertDialog alert;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		// Create default values
		usernames = new String[20];
		passwords = new String[20];
		
		usernames[0] = "Ashley";
		usernames[1] = "Kevin";
		passwords[0] = "hello";
		passwords[1] = "hi";
		
		username = (EditText) findViewById(R.id.editText2);
		password = (EditText) findViewById(R.id.editText1);
		ImageButton login = (ImageButton) findViewById(R.id.imageButton1);
		
		// Create alert dialog
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setTitle("Whoops!").setMessage("Wrong name or password");
		builder.setPositiveButton("Ok", new OnClickListener() {
			@Override
			public void onClick(DialogInterface arg0, int arg1) {

			}
		});
		alert = builder.create();

		
		
		login.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if (checkLogin()) {
					Intent nextScreen = new Intent(MainActivity.this,Loged_In.class);
					startActivity(nextScreen);
				} else {
					alert.show();
				}
			}
		});
	}
	
	public boolean checkLogin() {
		
		String login_username = username.getText().toString();
		String login_password = password.getText().toString();
		System.out.println(login_username + " " + login_password + " eeeeeee");
		for (int i = 0; i < usernames.length; i++) {
			if (login_username.equals(usernames[i]) && login_password.equals(passwords[i])) {
				return true;
			} 
		}
		return false;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
}