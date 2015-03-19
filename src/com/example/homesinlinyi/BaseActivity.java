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
	 * ��ʼ��view����
	 */
	abstract void initView();
	/**
	 * ���ü�����
	 */
	abstract void setListener();
	
	/**
	 * ��ʼ�����?
	 */
	abstract void initData();

	// ��ȡ�����ֻ��ڵ����ݡ�
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
