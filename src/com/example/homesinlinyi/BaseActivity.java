package com.example.homesinlinyi;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Toast;

import com.example.homesinlinyi.tools.CustomProgressDialog;

public abstract class BaseActivity extends Activity implements OnClickListener{

	protected CustomProgressDialog progressDialog = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
	}
	
	
	/**
	 * ï¿½ï¿½Ê¼ï¿½ï¿½viewï¿½ï¿½ï¿½ï¿½
	 */
	abstract void initView();
	/**
	 * ï¿½ï¿½ï¿½Ã¼ï¿½ï¿½ï¿½ï¿½ï¿½
	 */
	abstract void setListener();
	
	/**
	 * ï¿½ï¿½Ê¼ï¿½ï¿½ï¿½ï¿½ï¿?
	 */
	abstract void initData();

	// ÌáÈ¡´æÔÚÊÖ»úÄÚµÄÊý¾Ý¡¢
	protected String getSharedPreferenceValue(String key) {
		SharedPreferences sp = getSharedPreferences("SETTING_INFO", 0);
		return sp.getString(key, null);
	}

	protected void putSharedPreferenceValue(String key, String value) {
		SharedPreferences sp = getSharedPreferences("SETTING_INFO", 0);
		SharedPreferences.Editor editor;
		editor = sp.edit();
		editor.putString(key, value);
		editor.commit();
	}

	protected void startProgressDialog() {
        try{
			if(progressDialog == null){
				
				progressDialog = CustomProgressDialog.createDialog(this);
			}
			//CustomProgressDialog progressDialog = CustomProgressDialog.createDialog(this);
			progressDialog.setMessage("");
	
			progressDialog.show();
        }catch(Exception e) {
        	System.out.println("11111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111");
        }
	}

	protected void stopProgressDialog() {
		if (progressDialog != null) {
			progressDialog.dismiss();
			progressDialog = null;
		}
	}
}
