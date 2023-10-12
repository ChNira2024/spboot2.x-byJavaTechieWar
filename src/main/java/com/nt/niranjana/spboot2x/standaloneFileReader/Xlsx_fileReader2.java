package com.nt.niranjana.spboot2x.standaloneFileReader;  //working fine
/*
 * commons-collections4-4.1.jar Click Here
poi-3.17.jar Click Here
poi-ooxml-3.17.jar Click Here
poi-ooxml-schemas-3.17.jar Click Here
xmlbeans-2.6.0.jar Click Here
 */

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class Xlsx_fileReader2 {
  public static void main(String[] args) {
    try {
      File file = new File("C:\\Users\\Sreenivas Bandaru\\Downloads\\Sisu\\Sample files\\file_example_XLSX_1000.xlsx");
      //creating a new file instance  
      FileInputStream fis = new FileInputStream(file);
      //obtaining bytes from the file  
      //creating Workbook instance that refers to .xlsx file  
      XSSFWorkbook wb = new XSSFWorkbook(fis);
      XSSFSheet sheet = wb.getSheetAt(0);
      //creating a Sheet object to retrieve object  
      Iterator < Row > itr = sheet.iterator();
      //iterating over excel file
      System.out.println("The given file is");
      while (itr.hasNext()) {
        Row row = itr.next();
        Iterator < Cell > cellIterator = row.cellIterator();
        //iterating over each column  
        while (cellIterator.hasNext()) {
          Cell cell = cellIterator.next();
          switch (cell.getCellType()) {
          case STRING:
            //field that represents string cell type  
            System.out.print(cell.getStringCellValue() + "\t");
            break;
          case NUMERIC:
            //field that represents number cell type  
            System.out.print(cell.getNumericCellValue() + "\t");
            break;
          default:
          }
        }
        System.out.println("");
      }
    }
    catch(Exception e) {
      e.printStackTrace();
    }
  }
}
