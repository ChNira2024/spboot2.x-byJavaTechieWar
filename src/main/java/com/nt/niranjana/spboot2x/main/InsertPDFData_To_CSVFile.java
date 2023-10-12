package com.nt.niranjana.spboot2x.main;  //jars: commons-logging:1.2.jar, fontbox-2.0.23.jar,pdfbox-2.0.23.jar
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.PDFTextStripperByArea;
public class InsertPDFData_To_CSVFile 
{
	@SuppressWarnings("resource")
	public static void main(String args[]) throws IOException 
	{
		try
		{
			PDDocument document = PDDocument.load(new File("C:\\Users\\Sreenivas Bandaru\\Downloads\\Sisu\\Sample files\\TableDataWithRows.pdf"));// here TableDataWithRows.pdf is the name of pdf file which we want to read....
			document.getClass();
			if (!document.isEncrypted())
			{
				PDFTextStripperByArea stripper = new PDFTextStripperByArea();
				stripper.setSortByPosition(true);
				PDFTextStripper Tstripper = new PDFTextStripper();
				String str = Tstripper.getText(document);
				System.out.println("Pdf Extracted data:"+str);
			//write data into CSV file(If there is no file then here automatically .csv file will be created
			PrintWriter writer = new PrintWriter("C:\\Users\\Sreenivas Bandaru\\Downloads\\Sisu\\Sample files\\FileUpload\\insertPdfDataToCSV.csv");
			writer.write(str);
			writer.close();
		}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}			
	}
}