package com.nt.niranjana.spboot2x.main; //jars: commons-logging:1.2.jar, fontbox-2.0.23.jar,pdfbox-2.0.23.jar
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class ExtractPDFData_InsertInto_CSVFile {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		PDDocument document = PDDocument.load(new File("C:\\Users\\Sreenivas Bandaru\\Downloads\\Sisu\\Sample files\\TableDataWithRows.pdf"));
		PDFTextStripper Tstripper = new PDFTextStripper();
		String str = Tstripper.getText(document);
		System.out.println("PDF Extracted data:"+str);
		BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Sreenivas Bandaru\\Downloads\\Sisu\\Sample files\\TableDataWithRows.pdf"));
		String line="";
		StringBuffer sb = new StringBuffer();
		while ((line=br.readLine())!=null) 
		{					
			System.out.println(line.trim());
			sb.append(line);			
		}
		String str1 = sb.toString();
		//copied pdf data into CSV file
		FileWriter writer = new FileWriter("C:\\Users\\Sreenivas Bandaru\\Downloads\\Sisu\\Sample files\\FileUpload\\insertPdfDataToCSV2.csv");
		writer.write(str);
		writer.close();
		br.close();
		
	}
}
