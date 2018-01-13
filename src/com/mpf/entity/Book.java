package com.mpf.entity;

import java.io.Serializable;

@Sheet("Douban book data")
public class Book implements Serializable,Comparable<Book>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Row(index=2,columnName="评分",clazz=double.class)
	public double ranking;
	@Row(index=1,columnName="评价数",clazz=int.class)
	public int commentNum;
	@Row(index=0,columnName="标题",clazz=String.class)
	public String title;
	
	
	public Book() {
		super();
	}
	public Book(String url, double ranking, int commentNum, String title) {
		super();
		this.ranking = ranking;
		this.commentNum = commentNum;
		this.title = title;
	}
	public double getRanking() {
		return ranking;
	}
	public void setRanking(double ranking) {
		this.ranking = ranking;
	}
	public int getCommentNum() {
		return commentNum;
	}
	public void setCommentNum(int commentNum) {
		this.commentNum = commentNum;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	@Override
	public String toString() {
		return "Book [ranking=" + ranking + ", commentNum=" + commentNum + ", title="
				+ title + "]\r";
	}
	public int compareTo(Book o) {
		if(this.ranking<o.ranking){
		      return 1;
		   }else if(this.ranking>o.ranking){
		      return -1;
		   }else{
		     return 0;
		   }
	}
}
