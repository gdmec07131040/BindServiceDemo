package cn.edu.gdmec.s07131040.bindservicedemo;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.widget.Toast;

public class BoundService extends Service {

	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		Toast.makeText(this, "OnCreate", 1000).show();
	}
	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		Toast.makeText(this, "OnDestory", 1000).show();
	}
	@Override
	public boolean onUnbind(Intent intent) {
		// TODO Auto-generated method stub
		Toast.makeText(this, "OnUnbind", 1000).show();
		return super.onUnbind(intent);
	}
	@Override
	public IBinder onBind(Intent arg0) {
		// TODO Auto-generated method stub
		return null;
	}
	public long Avg(long a,long b){
		return (a+b)/2;
	}
	//创建一个服务绑定接口/类，返回服务实例
	public class LocalBinder extends Binder{
		BoundService getService(){
			return BoundService.this;
		}
	}
	
	private IBinder mBinder = new LocalBinder();
	
	public static long PI=(long) 3.1415926535798932;
}
