package com.nt.niranjana.spboot2x.util;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import com.nt.niranjana.spboot2x.entity.Employee;

/*
 <!-- https://mvnrepository.com/artifact/org.apache.poi/poi-ooxml -->
		<dependency>
			<groupId>org.apache.poi</groupId>
			<artifactId>poi-ooxml</artifactId>
			<version>4.1.1</version>
		</dependency>
		<!-- https://mvnrepository.com/artifact/org.apache.poi/poi-scratchpad -->
		<dependency>
			<groupId>org.apache.poi</groupId>
			<artifactId>poi-scratchpad</artifactId>
			<version>4.1.2</version>
		</dependency>
 */

public class CheckFileFormat 
{

	//check provided file is excel type or not
	public static boolean checkExcelFormat(MultipartFile file)
	{
	  String excelContentTye =	file.getContentType();
	  
	  if(excelContentTye.equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"))
	  {
		  return true;
	  }
	  else
	  {
		  return false;
	  }
	}
	
	//convert excel data to list of Employee
	public static List<Employee> convertExcelDataToListOfEmployee(InputStream is)
	{
		List<Employee> list = new ArrayList<>();
		
		try
		{
			XSSFWorkbook workbook=new XSSFWorkbook(is);
			XSSFSheet sheet=workbook.getSheet("Locations Data"); //sheet name
			
			int rowNumber = 0;
           Iterator<Row> iterator =	sheet.iterator();
           while(iterator.hasNext())
           {
         	 Row row  = iterator.next();
         	 if(rowNumber == 0)
         	 {
         		 rowNumber++;
         		 continue;
         	 }
         	 int cid = 0;
         	Employee emp = new Employee();
         	 Iterator<Cell> cells = row.iterator();
         	 while(cells.hasNext())
         	 {
         		Cell cell =  cells.next();
         		switch(cid)
         		{
         		case 0:
         			emp.setLOCATION_ID((int)cell.getNumericCellValue());
         			break;
         		case 1:
         			emp.setSTREET_ADDRESS(cell.getStringCellValue());
         			break;
         		case 2:
    				emp.setPOSTAL_CODE(cell.getStringCellValue());
    				break;
         		case 3:
    				emp.setCITY(cell.getStringCellValue());
    				break;
         		case 4:
    				emp.setSTATE_PROVINCE(cell.getStringCellValue());
    				break;
         		case 5:
    				emp.setCOUNTRY_ID(cell.getStringCellValue());
    				break;
    			default:
    				break;
         		}//end switch case
         		cid++;
       		
         	 }//end while-loop
         	 list.add(emp);
           }
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}
}



//===================Below code also work to save excel data in to db(Manual file from Local folder)===========
/*
@Override
public void insertExcelToDB()  {
	
	//Excel
	FileInputStream fis;
	try {
		fis = new FileInputStream("C:\\Users\\Sreenivas Bandaru\\Downloads\\Sisu\\Sample files\\locations.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		XSSFSheet sheet=workbook.getSheet("Locations Data");
		
		int rows=sheet.getLastRowNum();
		
		for(int r=1;r<=rows;r++)
		{
			XSSFRow row=sheet.getRow(r);
			double LOCATION_ID=row.getCell(0).getNumericCellValue();
			String STREET_ADDRESS=row.getCell(1).getStringCellValue();
			String POSTAL_CODE=row.getCell(2).getStringCellValue();
			String CITY=row.getCell(3).getStringCellValue();
			String STATE_PROVINCE=row.getCell(4).getStringCellValue();
			String COUNTRY_ID=row.getCell(5).getStringCellValue();
			
			
			Employee emp = new Employee();
			emp.setLOCATION_ID(LOCATION_ID);
			emp.setSTREET_ADDRESS(STREET_ADDRESS);
			emp.setPOSTAL_CODE(POSTAL_CODE);
			emp.setCITY(CITY);
			emp.setSTATE_PROVINCE(STATE_PROVINCE);
			emp.setCOUNTRY_ID(COUNTRY_ID);
			repo.save(emp);
			
		}
		workbook.close();
		fis.close();
	
		System.out.println("Data insert into DB from Excel!!");
	} 
	
	catch (FileNotFoundException e1) {
		e1.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}
}
*/