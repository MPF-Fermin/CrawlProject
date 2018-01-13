package com.mpf.common;

import java.util.Comparator;

import com.mpf.entity.Book;

public class BookComparator implements Comparator{

	public int compare(Object o1, Object o2) {
		Book t1=(Book) o1;
		Book t2=(Book) o2;
        //int result=t1.getRanking()<t2.getRanking()?1:(t1.getRanking()==t2.getRanking()?0:-1);
		int result=t1.ranking<t2.ranking?1:(t1.ranking==t2.ranking?0:-1);
        return result;
	}
}
