package com.example.fileoperatedemo;

import android.media.MediaPlayer.OnCompletionListener;

import java.io.IOException;

import com.example.fileoperatedemo.service.FileService;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

//控制层
public class MainActivity extends Activity
{
	 private MediaPlayer mMediaPlayer; 
	   private EditText etContent;
	   private Button button;
		    private void playLocalFile() {        
		        mMediaPlayer = MediaPlayer.create(this,R.raw.shoulder);       
		    try {    
		        mMediaPlayer.prepare();       
		    }   catch (IllegalStateException e) {                   
		    }    catch (IOException e) { 
		    }
		    mMediaPlayer.start();        
		    
		    mMediaPlayer.setOnCompletionListener(new OnCompletionListener() {                
		        public void onCompletion(MediaPlayer mp) {                          
		         }}); 
		    }
		

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		playLocalFile();
		initViews();
		button=(Button) findViewById(R.id.btnOk);
		//定义弹出框
		AlertDialog.Builder builder=new AlertDialog.Builder(this);
		builder.setMessage(R.string.dialog_text).setCancelable(false).setTitle(R.string.dialog_title).setPositiveButton(R.string.dialog_ok, new DialogInterface.OnClickListener(){
			public void onClick(DialogInterface dialog,int id){
				dialog.dismiss();
			}
		});
		final AlertDialog alert=builder.create();
		//绑定事件
		button.setOnClickListener(new View.OnClickListener()
		{
			
			@Override
			public void onClick(View view)
			{
				alert.show();
			}
		});
		/**
		 fileService=new FileService(this);
       Button button=(Button)this.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
             
            @Override
            public void onClick(View v) {
                    EditText text1=(EditText)findViewById(R.id.filename);
                    EditText text2=(EditText)findViewById(R.id.filecontent);
                    String filename=text1.getText().toString();
                    String content=text2.getText().toString();
                    try {
                        fileService.saveToSDCard(filename, content);
                        Toast.makeText(MainActivity.this,R.string.success, 1).show();
                    } catch (Exception e) {
                        // TODO Auto-generated catch block
                        Log.e(TAG, e.toString());
                        Toast.makeText(MainActivity.this,R.string.error, 1).show();
                    }
                 
                 
            */
	}

	private void initViews()
	{
		etContent = (EditText) findViewById(R.id.etContent);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public void save(View view)
	{
		// 从V获取数据
		String content = etContent.getText().toString();
		// 调用模型层M进行处理
		FileService fileService = new FileService(this, "data.txt");
		boolean isSavesucceed = fileService.save(content);
		if (isSavesucceed)
		{
			Toast.makeText(this, "恭喜你，保存成功了", Toast.LENGTH_LONG).show();
		}

	}
}
