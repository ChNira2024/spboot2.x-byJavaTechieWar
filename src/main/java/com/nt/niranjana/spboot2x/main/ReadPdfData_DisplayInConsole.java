package com.nt.niranjana.spboot2x.main;
import java.io.File;
import java.io.FileInputStream;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class ReadPdfData_DisplayInConsole {
	public static void main(String[] args)throws  Exception {
		File file = new File("C:\\Users\\Sreenivas Bandaru\\Downloads\\Sisu\\Sample files\\TableDataWithRows.pdf");
		FileInputStream fis = new FileInputStream(file);
		PDDocument document =PDDocument.load(fis);
	   System.out.println("Total page count in pdf:"+document.getPages().getCount());
		
	//To fetch data from pdf, we create PDfTextStripper class and use getText() method for read the data from given pdf file
		PDFTextStripper dataStripper = new PDFTextStripper();
		String str=dataStripper.getText(document);
		System.out.println("PDF Extracted Data:"+str);
			document.close();
			 fis.close();
		}//close main method	 
}
