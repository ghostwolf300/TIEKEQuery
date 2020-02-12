package org.tiekeqry.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.tiekeqry.dto.OrganizationEAddressDTO;
import org.tiekeqry.dto.ResultDTO;

public class Excel {
	
	private Workbook book=null;

	
	public Excel() {
		
	}
	
	public void openFile(File file) {
		FileInputStream ins=null;
		try {
			ins=new FileInputStream(file);
			book=new XSSFWorkbook(ins);
		} 
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				if(ins!=null) {
					ins.close();
				}
			} 
			catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	public void createFile(File file) {
		
	}
	
	public List<String> readYTJIds(){
		List<String> ytjIds = new ArrayList<String>();
		Sheet sheet=book.getSheet("YTJID");
		Iterator<Row> iter=sheet.iterator();
		String ytjId=null;
		while(iter.hasNext()) {
			Row row=iter.next();
			ytjId=row.getCell(0).getStringCellValue();
			ytjIds.add(ytjId);
		}
		return ytjIds;
	}
	
	public void writeResults(List<ResultDTO> results,File file) {
		Sheet sheet=book.createSheet("Results");
	
		int rowIndex=1;
		Row row=null;
		FileOutputStream out=null;
		
		row=sheet.createRow(0);
		row.createCell(0).setCellValue("YTJID");
		row.createCell(1).setCellValue("ORGANIZATION");
		row.createCell(2).setCellValue("EADDR_NAME");
		row.createCell(3).setCellValue("SERVICE_ID");
		row.createCell(4).setCellValue("CONTEXT");
		row.createCell(5).setCellValue("DIRECTION");
		row.createCell(6).setCellValue("PRMSN_SEND");
		row.createCell(7).setCellValue("EADDR_ID");
		
		
		for(ResultDTO result : results) {
			for (OrganizationEAddressDTO eaddr : result.geteAddresses()) {
				row=sheet.createRow(rowIndex++);
				row.createCell(0).setCellValue(result.getOrganization().getIdentifier().split(":")[1]);
				row.createCell(1).setCellValue(result.getOrganization().getName());
				row.createCell(2).setCellValue(eaddr.getName());
				row.createCell(3).setCellValue(eaddr.getServiceId());
				row.createCell(4).setCellValue(eaddr.getContextOfAddress());
				row.createCell(5).setCellValue(eaddr.getDirectionOfAddress());
				row.createCell(6).setCellValue(eaddr.isPermissionToSend());
				row.createCell(7).setCellValue(eaddr.getIdentifier().split(":")[1]);
			}	
		}
		
		for(int c=0;c<7;c++) {
			sheet.autoSizeColumn(c);
		}
		
		try {
			out=new FileOutputStream(file);
			book.write(out);
		} 
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if(out!=null) {
				try {
					out.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
	
}
