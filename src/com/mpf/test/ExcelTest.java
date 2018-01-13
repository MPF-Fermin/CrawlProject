package com.mpf.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mpf.entity.Book;

import junit.framework.TestCase;

public class ExcelTest extends TestCase{
	
	private String filePath="E://Workspace/CrawlProject/src/data.xls";
	
	@Override
	protected void setUp() throws Exception {
		
		 System.out.println(getClass().getResource("").toString());
	}
	public void test_expoprt(ArrayList<Book> list){
		
		Map<Class<?>,Collection<?>> maps=new HashMap<Class<?>, Collection<?>>();
		
		maps.put(Book.class, list);
		new ExportExcel().export(maps,filePath);
		try {
			Runtime.getRuntime().exec("cmd /c start "+filePath);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
