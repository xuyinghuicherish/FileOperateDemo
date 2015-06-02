package com.example.fileoperatedemo.test;

import com.example.fileoperatedemo.service.FileService;

import android.test.AndroidTestCase;

public class FileServieTest extends AndroidTestCase {
    public void testSave(){
    	/*
    	 * 普通类中没有context方法。****/
    	FileService fileService=new FileService(getContext(), "test.txt");
    	fileService.save("hello world");
    }
}
