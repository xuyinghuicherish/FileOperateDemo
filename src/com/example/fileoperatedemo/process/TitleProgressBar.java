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
		//���ô���������������ʾ���ȵĽ�����
		requestWindowFeature(Window.FEATURE_PROGRESS);
		//���ô�����������������ʾ���ȵĽ�����
		requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);
		setContentView(R.layout.activity_list_item);
        Button btn1=(Button)findViewById(R.id.button1);
        Button btn2=(Button)findViewById(R.id.button2);
        btn1.setOnClickListener(new OnClickListener(){
        	public void onClick(View view){
        		//��ʾ�������ȵĽ�����
        		setProgressBarIndeterminateVisibility(true);
        		//��ʾ�����ȵĽ�����
        		setProgressBarVisibility(true);
        		//���ý������Ľ���
        		setProgress(5000);
        	}
        	
        });
        btn2.setOnClickListener(new OnClickListener()
        {
        	public void onClick(View view){
        		//��ʾ�������ȵĽ�����
        		setProgressBarIndeterminateVisibility(true);
        		//��ʾ�����ȵĽ�����
        		setProgressBarVisibility(true);
        		//���ý������Ľ���
        		setProgress(5000);
        	}
        	
        });
	}

}*/
