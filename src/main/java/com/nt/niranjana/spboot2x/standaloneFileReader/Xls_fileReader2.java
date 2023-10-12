package com.nt.niranjana.spboot2x.standaloneFileReader;   //working fine
/*
 * commons-collections4-4.1.jar Click Here
poi-3.17.jar Click Here
poi-ooxml-3.17.jar Click Here
poi-ooxml-schemas-3.17.jar Click Here
xmlbeans-2.6.0.jar Click Here
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
public class Xls_fileReader2 {
  public static void main(String args[]) throws IOException {
    //obtaining input bytes from a file  
    FileInputStream fis = new FileInputStream(new File("C:\\Users\\Sreenivas Bandaru\\Downloads\\Sisu\\Sample files\\file_example_XLS_1000.xls"));
    //creating workbook instance that refers to .xls file  
    HSSFWorkbook wb = new HSSFWorkbook(fis);
    //creating a Sheet object to retrieve the object  
    HSSFSheet sheet = wb.getSheetAt(0);
    //evaluating cell type   
    FormulaEvaluator formulaEvaluator = wb.getCreationHelper().createFormulaEvaluator();
    System.out.println("The given file is");
    for (Row row: sheet)
    //iteration over row using for each loop  
    {
      for (Cell cell: row) //iteration over cell using for each loop  
      {
        switch (formulaEvaluator.evaluateInCell(cell).getCellType()) {
        case NUMERIC:
          //field that represents numeric cell type  
          //getting the value of the cell as a number  
          System.out.print(cell.getNumericCellValue() + "\t");
          break;
        case STRING:
          //field that represents string cell type  
          //getting the value of the cell as a string  
          System.out.print(cell.getStringCellValue() + "\t");
          break;
        }
      }
      System.out.println();
    }
  }
}
