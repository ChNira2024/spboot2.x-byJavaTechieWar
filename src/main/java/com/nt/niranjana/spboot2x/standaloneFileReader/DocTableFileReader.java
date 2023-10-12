package com.nt.niranjana.spboot2x.standaloneFileReader; //jar: poi-ooxml-5.2.2.jar         Not working

import java.io.File;
import java.io.FileInputStream;
import java.util.List;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;  
public class DocTableFileReader {  
    public static void main(String[] args)throws Exception {  
        	  File file = new File("C:\\Users\\Sreenivas Bandaru\\Downloads\\Sisu\\Sample files\\New folder\\DocTableSample.doc");{
      		FileInputStream fis = new FileInputStream(file);
      		XWPFDocument doc = new XWPFDocument(fis);
      		List<XWPFTable> tables = doc.getTables();
      	
      		for (XWPFTable table : tables) {
      			for (XWPFTableRow row : table.getRows()) {
      				for (XWPFTableCell cell : row.getTableCells()) {
      					System.out.println(cell.getText());
      					String sFieldValue = cell.getText();
      					if (sFieldValue.matches("Whatever you want to match with the string") || sFieldValue.matches("Approved")) {
      						System.out.println("The match as per the Document is True");
      					}
//      					System.out.println("\t");
      				}
      				System.out.println(" ");
      			}
      		}  
       }  
    }
}  


