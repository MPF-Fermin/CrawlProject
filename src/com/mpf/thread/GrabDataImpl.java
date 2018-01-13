package com.mpf.thread;

import java.util.ArrayList;

import com.mpf.ShareData;
import com.mpf.common.CommonMethod;
import com.mpf.common.Constant;
import com.mpf.entity.Book;
import com.mpf.test.ExcelTest;

public class GrabDataImpl implements GrabData{

	public void grabData(){
		ArrayList<Book> finalAllBooks = new ArrayList<Book>();
		String[] categoryArr = Constant.classfication.split(",");
		for(String str : categoryArr){
			ShareData sd = new ShareData(str);
			SingleThread st = new SingleThread(sd,finalAllBooks);
				for(int i = 0; i < 10; i++){     //每种类型查询的页数，这里要开启30个线程，图书查询出的总数是600本
					Thread thread = new Thread(st);
					thread.start();
					try {
						thread.sleep(1000);        //设置线程开启线程间隔时间，防止短时间频繁访问服务器，导致403等豆瓣权限访问的限制
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
		}
		ArrayList<Book> bookList = new ArrayList<Book>();
		bookList.addAll(CommonMethod.selectBooks(finalAllBooks));
		new ExcelTest().test_expoprt(bookList);
	}
}
