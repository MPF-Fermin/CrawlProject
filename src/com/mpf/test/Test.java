package com.mpf.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;

import com.mpf.entity.Book;
import com.sun.org.apache.xalan.internal.xsltc.compiler.Pattern;

public class Test {
	public static void main(String[] args) {/*
	         List<String> list  =   new  ArrayList<String>(); 
	         list.add("aaa");
	         list.add("bbb");
	         list.add("aaa");
	         list.add("aba");
	         list.add("aaa");

	         Set set = new  HashSet(); 
	         List newList = new  ArrayList(); 
	         for (String cd:list) {
	            if(set.add(cd)){
	                newList.add(cd);
	            }
	        }
	         System.out.println( "去重后的集合： " + newList); 
	*/
		/*String s = "aba13az";
		List<String> ss = new ArrayList<String>();
		for(String sss:s.replaceAll("[^0-9]", ",").split(",")){
		    if (sss.length()>0)
		        ss.add(sss);
		}
		//System.out.print(ss.get(0));
		
		String str = "(123人评价）";
		str = str.replaceAll("[^0-9]", "");
		System.out.println(str);*/
		/*ArrayList<Book> list = new ArrayList<Book>();
		Book book1 = new Book();
		Book book2 = new Book();
		Book book3 = new Book();
		book1.setCommentNum(123);
		book1.setRanking(9.1);
		book1.setTitle("Hello");
		book2.setCommentNum(123);
		book2.setRanking(9.1);
		book2.setTitle("Hello");
		book3.setCommentNum(234);
		book3.setRanking(9.5);
		book3.setTitle("world");
		list.add(book1);
		list.add(book2);
		list.add(book3);
	   for ( int i = 0 ; i < list.size() - 1 ; i ++ ) {   //从左向右循环  
	     for ( int j = list.size() - 1 ; j > i; j -- ) {  //从右往左内循环  
	       if (list.get(j).getTitle().equals(list.get(i).getTitle())&&
	    		   list.get(j).getCommentNum()==list.get(i).getCommentNum()&&
	    		   list.get(j).getRanking()==list.get(i).getRanking()) {  
	         list.remove(j);                              //相等则移除  
	       }   
	      }   
	    }   
	    System.out.println(list);  
		
	}*/
	/*public static void bubbleSort(int[] numbers)
    {
        int temp = 0;
        int size = numbers.length;
        for(int i = 0 ; i < size-1; i ++)
        {
        for(int j = 0 ;j < size-1-i ; j++)
        {
            if(numbers[j] > numbers[j+1])  //交换两数位置
            {
            temp = numbers[j];
            numbers[j] = numbers[j+1];
            numbers[j+1] = temp;
            }
        }
        }
    }*/
		String filePath="E://Test/testData.xls";
		try {
			Runtime.getRuntime().exec("cmd /c start "+filePath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
