package com.mpf.test;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.mpf.entity.Row;
import com.mpf.entity.Sheet;

public class ExcelHelper {
	
	//����excel�ı���
	public static <T> ExcelNode node(Class<T> clazz){
		
		Sheet sheet = clazz.getAnnotation(Sheet.class);
		if(sheet==null)
			return null;
		ExcelNode node=new ExcelNode();
		String sheetName = sheet.value();
		node.setSheetName(sheetName);
		Field[] fecLds = ReflectionUtil.getAllgetDeclaredFields(clazz);
		
		for(Field fecLd:fecLds){
			
			Row row = fecLd.getAnnotation(Row.class);
			if(row==null)continue;
			int index=row.index();
			if(index==-1){
				if(node.getTitles().size()==0){
					index=0;
				}else{
					index=node.getTitles().size();
				}
			}
			
			String columnName=row.columnName()==null?"":row.columnName();
			node.putTitle(index, columnName);
			//����
			node.putField(index, fecLd);
		}
		
		return node;
	}
	
	//������ʵ���ÿһ���ֶ�
	public static <T> Map<Integer,Object> transObj2Row(T obj){
		Field[] fecLds = ReflectionUtil.getAllgetDeclaredFields(obj.getClass());
		Map<Integer,Object> rows=new TreeMap<Integer, Object>();
		for(Field fecLd:fecLds){
			Row row = fecLd.getAnnotation(Row.class);
			if(row==null){
				continue;
			}
			int index=row.index();
			if(index==-1){
				if(rows.size()==0){
					index=0;
				}else{
					index=rows.keySet().size();
				}
			}
			
			try {
				rows.put(index, ReflectionUtil.invokeGetter(fecLd, obj));
			}catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
		return rows;
	}
	
	//����һϵ�е�
	public static <T> List<Map<Integer,Object>> transObjs2Rows(Collection<T> objs){
		List<Map<Integer,Object>> rows=new ArrayList<Map<Integer,Object>>();
		
		for(Object obj:objs){
			rows.add(transObj2Row(obj));
		}
		return rows;
	}
	
}
