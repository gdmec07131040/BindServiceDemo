package cn.edu.gdmec.s07131040.bindservicedemo;

import android.os.Bundle;
import android.os.IBinder;
import android.animation.ArgbEvaluator;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	Button myBtn1,myBtn2,myBtn3,myBtn4;
	TextView myTv;
	Intent myIt=new Intent("cn.edu.gdmec.bindserevice");
	boolean isbound=false;
	BoundService myBoundService;
	
	ServiceConnection mConnection=new ServiceConnection() {

		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
			myBoundService =((BoundService.LocalBinder)service).getService();
isbound = true;
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onServiceDisconnected(ComponentName name) {
			// TODO Auto-generated method stub
			
		}
		
		
	};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		myTv = (TextView) findViewById(R.id.textView1);
		myBtn1 = (Button) findViewById(R.id.button1);
		myBtn2 = (Button) findViewById(R.id.button2);
		myBtn3 = (Button) findViewById(R.id.button3);
		myBtn4 = (Button) findViewById(R.id.button4);
		
		myBtn1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				bindService(myIt, mConnection,BIND_AUTO_CREATE);
				
			}
		});
		
		myBtn2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				unbindService(mConnection);
				isbound=false;
			}
		});
		
		myBtn3.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				long a = Math.round(Math.random()*100);
				long b = Math.round(Math.random()*100);
				if (isbound){
					long avg = myBoundService.Avg(a, b);
					myTv.setText(String.valueOf(a)+"+"+String.valueOf(b)+"="+String.valueOf(avg));
				}
			}
		});
		
		myBtn4.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(isbound){
					String str= String.valueOf(myBoundService.PI);
					myTv.setText(str);
				}
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
