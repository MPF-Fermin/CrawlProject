package com.mpf.test;


import java.io.FileOutputStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class ExportExcel{
	
	//����
	public <T> boolean export(Collection<T> books,Class<T> clazz,String filePath){
		Map<Class<?>,Collection<?>> maps =new HashMap<Class<?>, Collection<?>>();
		maps.put(clazz, books);
		return export(maps, filePath);
	}
	
	//��sheet
	public boolean export(Map<Class<?>,Collection<?>> maps,String filePath){
		HSSFWorkbook workbook = new HSSFWorkbook();
		for(Entry<Class<?>,Collection<?>> entry:maps.entrySet()){
			List<Map<Integer, Object>> transObjs2Rows = ExcelHelper.transObjs2Rows(entry.getValue());
			ExcelNode node = ExcelHelper.node(entry.getKey());
			export(transObjs2Rows, node, workbook);
		}
		try {
			FileOutputStream fOut = new FileOutputStream(filePath);
			workbook.write(fOut);
			fOut.flush();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	protected HSSFSheet export(List<Map<Integer, Object>> rows,ExcelNode node,HSSFWorkbook workbook){
        HSSFSheet sheet = workbook.createSheet(node.getSheetName());
        //����
        int rowCount=rows.size()+1;
        //����
        int columnCount=node.getTitles().size();
        HSSFRow headerRow = sheet.createRow(0);
        //����ͷ����
        for(int i=0;i<columnCount;i++){
        	 HSSFCell cell = headerRow.createCell(i);
        	 cell.setCellValue(node.getTitles().get(i));
        }
        
        for(int i=1;i<rowCount;i++){
        	HSSFRow contentRow = sheet.createRow(i);
        	for(int j=0;j<columnCount;j++){
        		HSSFCell cell = contentRow.createCell(j);
        		cell.setCellValue(rows.get(i-1).get(j).toString());
        	}
        }
        
        return sheet;
        
	}

}