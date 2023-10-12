package com.nt.niranjana.spboot2x.standaloneFileReader;  //jars: commons-logging:1.2.jar, fontbox-2.0.23.jar,pdfbox-2.0.23.jar   //working fine

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class PdfFileReader {
	public static void readPDFAndDisplayInConsole() throws IOException 
	{
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
	}
	public static void main(String[] args) throws IOException {
		PdfFileReader.readPDFAndDisplayInConsole();
	}
}
