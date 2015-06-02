package com.example.fileoperatedemo.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import com.example.fileoperatedemo.MainActivity;

import android.content.Context;
import android.os.Environment;
import android.view.View.OnClickListener;

public class FileService
{
	private Context context;
	private String fileName;

	public FileService(Context context2, String fileName)
	{
		this.context = (Context) context2;
		this.fileName = fileName;
	}

	public boolean save(String content)
	{
		BufferedWriter bw = null;
		boolean isSaveSucceed = false;
		try
		{
			/*
			 * 此处需要用到io留设计模式。装饰类。*
			 * 1:构建文件输出流通道：FileOutputStream，其中需要用到context的openFileOutput方法
			 * 2：用OutputStream包装FileOutputStream，装换成字符输出流，使用户输入中文时，不出现乱码。
			 * 3：使用BufferedWriter实现缓冲功能，包装Writer。
			 **/
			FileOutputStream fos = context.openFileOutput(fileName, context.MODE_PRIVATE);
			OutputStreamWriter writer = new OutputStreamWriter(fos);
			bw = new BufferedWriter(writer);//
			bw.write(content);
			isSaveSucceed = true;

		} catch (FileNotFoundException e)
		{
			e.printStackTrace();
		} catch (IOException e)
		{
			e.printStackTrace();
		} finally
		{//流占用资源，最后必须进行关闭。
			if (bw != null)
				try
				{
					bw.close();
				} catch (IOException e)
				{
					e.printStackTrace();
				}
		}
		return isSaveSucceed;
	}

	public String read()
	{
		String line;
		StringBuilder sb = new StringBuilder();
		BufferedReader br = null;
		try
		{
			FileInputStream fis = context.openFileInput(fileName);
			br = new BufferedReader(new InputStreamReader(fis));
			while ((line = br.readLine()) != null)
			{
				sb.append(line);
			}

		} catch (FileNotFoundException e)
		{
			e.printStackTrace();
		} catch (IOException e)
		{
			e.printStackTrace();
		} finally
		{
			if (br != null)
			{
				try
				{
					br.close();
				} catch (IOException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return sb.toString();
	}

	//将文件保存至sd卡。
	/***保存到sd卡下的.ainibaichi文件夹下的准确可行的代码****/
    public void saveToSDCard(String filename,String content) throws Exception{
        String dir=Environment.getExternalStorageDirectory()+"/.ainibaichi";
         
        java.io.File a=new java.io.File(dir);
       /***判断文件夹是否存在，不存在则创建***/
        if (!a.exists()){
            a.mkdir();
        }
        File file=new File(a,filename);
        FileOutputStream outStream=new FileOutputStream(file);
        outStream.write(content.getBytes());
        outStream.close();
}
}
