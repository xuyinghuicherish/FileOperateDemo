/****package com.example.fileoperatedemo.process;

import java.security.PublicKey;

import android.R;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class TitleProgressBar  extends Activity
{
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		//设置窗口特征，启动显示进度的进度条
		requestWindowFeature(Window.FEATURE_PROGRESS);
		//设置窗口特征，启动不显示进度的进度条
		requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);
		setContentView(R.layout.activity_list_item);
        Button btn1=(Button)findViewById(R.id.button1);
        Button btn2=(Button)findViewById(R.id.button2);
        btn1.setOnClickListener(new OnClickListener(){
        	public void onClick(View view){
        		//显示不带进度的进度条
        		setProgressBarIndeterminateVisibility(true);
        		//显示带进度的进度条
        		setProgressBarVisibility(true);
        		//设置进度条的进度
        		setProgress(5000);
        	}
        	
        });
        btn2.setOnClickListener(new OnClickListener()
        {
        	public void onClick(View view){
        		//显示不带进度的进度条
        		setProgressBarIndeterminateVisibility(true);
        		//显示带进度的进度条
        		setProgressBarVisibility(true);
        		//设置进度条的进度
        		setProgress(5000);
        	}
        	
        });
	}

}*/
