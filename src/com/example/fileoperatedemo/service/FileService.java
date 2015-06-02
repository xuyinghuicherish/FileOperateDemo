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
			 * �˴���Ҫ�õ�io�����ģʽ��װ���ࡣ*
			 * 1:�����ļ������ͨ����FileOutputStream��������Ҫ�õ�context��openFileOutput����
			 * 2����OutputStream��װFileOutputStream��װ�����ַ��������ʹ�û���������ʱ�����������롣
			 * 3��ʹ��BufferedWriterʵ�ֻ��幦�ܣ���װWriter��
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
		{//��ռ����Դ����������йرա�
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

	//���ļ�������sd����
	/***���浽sd���µ�.ainibaichi�ļ����µ�׼ȷ���еĴ���****/
    public void saveToSDCard(String filename,String content) throws Exception{
        String dir=Environment.getExternalStorageDirectory()+"/.ainibaichi";
         
        java.io.File a=new java.io.File(dir);
       /***�ж��ļ����Ƿ���ڣ��������򴴽�***/
        if (!a.exists()){
            a.mkdir();
        }
        File file=new File(a,filename);
        FileOutputStream outStream=new FileOutputStream(file);
        outStream.write(content.getBytes());
        outStream.close();
}
}
