package com.mpf.common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.mpf.entity.Book;

public class CommonMethod {
	//ȥ���ظ�����
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
     //ѡȡ������ߵ�ǰ100�����ݣ�����������Ŀ������1000��
     public static ArrayList<Book> selectBooks(ArrayList<Book> list){
    	 //ȥ��title��ranking��commentNum��һ����Book
    	 for ( int i = 0 ; i < list.size() - 1 ; i ++ ) {   //��������ѭ��  
    	     for ( int j = list.size() - 1 ; j > i; j -- ) {  //����������ѭ��  
    	       if (list.get(j).getTitle().equals(list.get(i).getTitle())&&
    	    	   list.get(j).getCommentNum()==list.get(i).getCommentNum()&&
    	    	   list.get(j).getRanking()==list.get(i).getRanking()) {  
    	             list.remove(j);                              //������Ƴ�  
    	       }   
    	     }   
    	  } 
    	 //�������ִӴ�С��������
    	 Collections.sort(list);
    	 //ȥ����������С��1000���鼮
    	 Iterator<Book> sListIterator = list.iterator();
    	 while(sListIterator.hasNext()){
    		 Book book = sListIterator.next();
    		 if(book.getCommentNum() < 1000){
    			 sListIterator.remove();
    		 }
    	 }
    	 //ֻ����ǰ���100������
    	 ArrayList<Book> newList = new ArrayList<Book>();
    	 for(int i = 0; i < 100; i++){
    		 newList.add(list.get(i));
    	 }
    	 return (ArrayList<Book>)newList;
    }
}
