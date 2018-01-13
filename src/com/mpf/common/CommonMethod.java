package com.mpf.common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.mpf.entity.Book;

public class CommonMethod {
	//去除重复数据
     public static ArrayList<String> removeDuplication(ArrayList<String> list){
    	 Set<String> set = new  HashSet<String>(); 
    	 ArrayList<String> newList = new  ArrayList<String>(); 
         for (String str:list) {
            if(set.add(str)){
                newList.add(str);
            }
        }
         return newList;
     }
     //选取评分最高的前100本数据（并且评价数目不低于1000）
     public static ArrayList<Book> selectBooks(ArrayList<Book> list){
    	 //去除title，ranking，commentNum都一样的Book
    	 for ( int i = 0 ; i < list.size() - 1 ; i ++ ) {   //从左向右循环  
    	     for ( int j = list.size() - 1 ; j > i; j -- ) {  //从右往左内循环  
    	       if (list.get(j).getTitle().equals(list.get(i).getTitle())&&
    	    	   list.get(j).getCommentNum()==list.get(i).getCommentNum()&&
    	    	   list.get(j).getRanking()==list.get(i).getRanking()) {  
    	             list.remove(j);                              //相等则移除  
    	       }   
    	     }   
    	  } 
    	 //按照评分从大到小进行排序
    	 Collections.sort(list);
    	 //去除掉评价数小于1000的书籍
    	 Iterator<Book> sListIterator = list.iterator();
    	 while(sListIterator.hasNext()){
    		 Book book = sListIterator.next();
    		 if(book.getCommentNum() < 1000){
    			 sListIterator.remove();
    		 }
    	 }
    	 //只保留前面的100本数据
    	 ArrayList<Book> newList = new ArrayList<Book>();
    	 for(int i = 0; i < 100; i++){
    		 newList.add(list.get(i));
    	 }
    	 return (ArrayList<Book>)newList;
    }
}
