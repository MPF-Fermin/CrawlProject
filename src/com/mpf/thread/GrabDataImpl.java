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
				for(int i = 0; i < 10; i++){     //ÿ�����Ͳ�ѯ��ҳ��������Ҫ����30���̣߳�ͼ���ѯ����������600��
					Thread thread = new Thread(st);
					thread.start();
					try {
						thread.sleep(1000);        //�����߳̿����̼߳��ʱ�䣬��ֹ��ʱ��Ƶ�����ʷ�����������403�ȶ���Ȩ�޷��ʵ�����
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
