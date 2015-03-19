package com.example.homesinlinyi.tools;

import com.example.homesinlinyi.R;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.view.Gravity;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.TextView;


public class CustomProgressDialog extends Dialog {
	private Context context = null;
	private static CustomProgressDialog customProgressDialog = null;
	
	public CustomProgressDialog(Context context){
		super(context);
		this.context = context;
	}
	
	public CustomProgressDialog(Context context, int theme) {
        super(context, theme);
    }
	
	public static CustomProgressDialog createDialog(Context context){
//		customProgressDialog = new CustomProgressDialog(context,R.style.CustomProgressDialog);
		customProgressDialog.setContentView(R.layout.homesinlinyi_dialog);
		customProgressDialog.getWindow().getAttributes().gravity = Gravity.CENTER;
		
		return customProgressDialog;
	}
 
    public void onWindowFocusChanged(boolean hasFocus){
    	
    	if (customProgressDialog == null){
    		return;
    	}
    	
        ImageView imageView = (ImageView) customProgressDialog.findViewById(R.id.loadingImageView);
        TextView textview = (TextView)customProgressDialog.findViewById(R.id.id_tv_loadingmsg);
        AnimationDrawable animationDrawable = (AnimationDrawable) imageView.getBackground();
        animationDrawable.start();
    }
 
    /**
     * 
     * [Summary]
     *       setTitile ����
     * @param strTitle
     * @return
     *
     */
    public CustomProgressDialog setTitile(String strTitle){
    	return customProgressDialog;
    }
    
    /**
     * 
     * [Summary]
     *       setMessage ��ʾ����
     * @param strMessage
     * @return
     *
     */
    public CustomProgressDialog setMessage(String strMessage){
    	TextView tvMsg = (TextView)customProgressDialog.findViewById(R.id.id_tv_loadingmsg);
    	
    	if (tvMsg != null){
    		tvMsg.setText(strMessage);
    	}
    	
    	return customProgressDialog;
    }
    
    @Override
    public boolean onTouchEvent(MotionEvent event) {
    	// TODO Auto-generated method stub
    	return false;
    	
    }
}
