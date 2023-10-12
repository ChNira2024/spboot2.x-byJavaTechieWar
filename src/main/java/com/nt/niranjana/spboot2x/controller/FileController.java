package com.nt.niranjana.spboot2x.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.opencsv.CSVReader;

import io.swagger.annotations.ApiOperation;

@RestController
public class FileController 
{
	@GetMapping("/readTextFile")
	@ApiOperation(value="ReadTextFile",notes = "reading text file from request param")
	public String ReadTextFile(@RequestParam(name = "textFile") MultipartFile file) throws IOException 
	{
		// Convert Multipart file to File
		System.out.println("type of file is: " + file.getName());
		System.out.println("Original file name is: " + file.getOriginalFilename());
		
	//Approach 1: Read Multipart file Using BufferedReader and InputStreamReader
		InputStream is = file.getInputStream();
		String line;
		StringBuilder result= new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
			while ((line = br.readLine()) != null) 
			{
			    result.append(line).append("\n");			         
			}
			System.out.println("Text file contents are: "+result);
			System.out.println("------------------------------------");
			return "file name is: "+file.getOriginalFilename();
	}
//================================================================================================================================	
	@GetMapping("/readCSVFile")
	@ApiOperation(value="ReadCSVFile",notes = "reading csv file from request param")
	public String ReadCSVFile(@RequestParam(name = "csvFile") MultipartFile file) throws IOException 
	{
		// Convert Multipart file to File
		System.out.println("type of file is: " + file.getName());
		System.out.println("Original file name is: " + file.getOriginalFilename());	
		
	//Approach 1: Read Multipart file Using BufferedReader and InputStreamReader
		InputStream is = file.getInputStream();
		String line;
		StringBuilder result= new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
			while ((line = br.readLine()) != null) 
			{
			    result.append(line).append("\n");			         
			}
			System.out.println("CSV file contents are: "+result);
			System.out.println("------------------------------------");
	//Approach 2: Read Multipart file Using CSVReader and InputStreamReader
			CSVReader reader = null;  
			InputStream iss = file.getInputStream();
			try  
			{  
				reader = new CSVReader(new InputStreamReader(iss));  
				String [] nextLine;  
				//reads one line at a time  
				while ((nextLine = reader.readNext()) != null)  
				{  
					for(String token : nextLine)  
					{  
						System.out.print(token);  
					}  
					System.out.print("\n");
				} 				
			}  
			catch (Exception e)   
			{  
				e.printStackTrace();  
			} 
			System.out.println("------------------------------------");
			InputStream isss = file.getInputStream();
			// create csvReader object and skip first Line
	       //  reader = new CSVReaderBuilder(file).withSkipLines(1).build();
	       // List<String[]> allData = reader.readAll();
	  
	        // print Data
//	        for (String[] row : allData) {
//	            for (String cell : row) {
//	                System.out.print(cell + "\t");
//	            }
//	            System.out.println();
//	        }
			return "file name is: "+file.getOriginalFilename();
	}
//				 br= new BufferedReader(new FileReader(originalFileName));
//		           String st;
//		           while ((st = br.readLine()) != null)
//		            System.out.println("Text file content are: "+st);
//		           
//		           
//		           
//		           FileOutputStream fos = new FileOutputStream( originalFileName );
//		           fos.write( file.getBytes() );
//		           fos.close();
		

//===============================================================		
//			@PostMapping("/writefile")
//			public void WriteFile( @RequestBody Employee emp)
//			{					
//				try {
//	            FileWriter f1 = new FileWriter("C://Users//Administrator//Downloads//test1.txt");
//	           f1.write(emp.toString());
//	           // f1.write(new ObjectMapper().writeValueAsString(emp));
//	            f1.close();
//				}
//				catch(Exception  fe)
//				{
//					fe.printStackTrace();
//				}
//			}
////===========================================
//			@PostMapping("/excelData")
//			public void DataInsertIntoExcel( @RequestBody Excel xls)
//			{					
//				//here we create empty workbook
//		        XSSFWorkbook workbook = new XSSFWorkbook();     
//		      //Create a blank sheet
//		        XSSFSheet sheet = workbook.createSheet( "Sheet1");
//		        //Create row object
//		        XSSFRow rowhead = sheet.createRow(0);
//		        rowhead.createCell(0).setCellValue("EmpId");
//			    rowhead.createCell(1).setCellValue("EmpName");
//			    rowhead.createCell(2).setCellValue("EmpRole");
//			     rowhead.createCell(3).setCellValue("EmpSalary");
//			     rowhead.createCell(4).setCellValue("EmpCity");
//			     rowhead.createCell(5).setCellValue("EmpContact");
//		       XSSFRow rowhead1 = sheet.createRow(1);
//		       rowhead1.createCell(0).setCellValue(xls.getEmpId());
//		       rowhead1.createCell(1).setCellValue(xls.getEmpName());
//		       rowhead1.createCell(2).setCellValue(xls.getEmpRole());
//		       rowhead1.createCell(3).setCellValue(xls.getEmpSalary());
//		       rowhead1.createCell(4).setCellValue(xls.getEmpCity());
//		       rowhead1.createCell(5).setCellValue(xls.getEmpContact());
//		   
//		       try {
//		       File f1 = new File("C:\\Users\\Administrator\\eclipse-workspace\\Niranjana_WorkSpace\\SpBoot_WebConcept\\src\\main\\java\\com\\eidiko\\SpBoot_WebConcept\\xls\\TestData.xls");
//				FileOutputStream fos = new FileOutputStream(f1);
//			        workbook.write(fos);
//			        fos.close();
//		       }
//		       catch(Exception e)
//		       {
//		    	   e.printStackTrace();
//		       }
//		       System.out.println("ok...Done");
//			}
}
