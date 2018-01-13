package com.mpf.thread;

import java.util.ArrayList;

import com.mpf.ShareData;
import com.mpf.entity.Book;

public class SingleThread implements Runnable{
	ShareData sd;
	ArrayList<Book> finalAllBooks = new ArrayList<Book>();
	public SingleThread(ShareData sd,ArrayList<Book> finalAllBooks){
		this.sd = sd;
		this.finalAllBooks = finalAllBooks;
	}
	public void run() {
		sd.searchHref(finalAllBooks);
	}
}
