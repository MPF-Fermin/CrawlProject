package com.mpf.test;

import java.util.Date;

import com.mpf.entity.Row;
import com.mpf.entity.Sheet;

@Sheet("����Excel")
public class TestExcelEntity {

	@Row(index=0,columnName="����")
	private int index;
	@Row(index=1,columnName="Ȩ��")
	private double weight;
	@Row(index=2,columnName="����")
	private String title;
	@Row(index=3,columnName="����ʱ��")
	private Date createBy;
	
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getCreateBy() {
		return createBy;
	}
	public void setCreateBy(Date createBy) {
		this.createBy = createBy;
	}
	@Override
	public String toString() {
		return "TestExcelEntity [index=" + index + ", weight=" + weight + ", title=" + title + ", createBy=" + createBy
				+ "]";
	}
	
	
}
