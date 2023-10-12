package com.nt.niranjana.spboot2x.standaloneFileReader;  //Jars:-   pdfbox-app-2.0.4, fontbox-2.0.11, commons-logging 1.2  (Successfully)

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.ImageType;
import org.apache.pdfbox.rendering.PDFRenderer;
import org.apache.pdfbox.tools.imageio.ImageIOUtil;

/*
 * 
 <!-- https://mvnrepository.com/artifact/org.apache.pdfbox/pdfbox-tools -->
		<dependency>
			<groupId>org.apache.pdfbox</groupId>
			<artifactId>pdfbox-tools</artifactId>
			<version>2.0.0-RC1</version>
		</dependency>
 */

public class FileConversion_PDF_To_Image 
{
	public static  void pdfToImage(String pdfpath)throws IOException
	{
	//To read pDF file
	PDDocument doc = PDDocument.load(new File(pdfpath));

	//To render each page into page
	PDFRenderer pdfRenderer = new PDFRenderer(doc);
	
	for(int page=0; page<doc.getNumberOfPages();  ++page)
	{
	//Create image first
	BufferedImage bim = pdfRenderer.renderImageWithDPI(page, 300,ImageType.RGB);
	//write the image into detsinaation file
	String fileName = "C:\\Users\\Administrator\\Downloads\\Eidiko\\FileConversion\\Images\\pdfToimage.png";
ImageIOUtil.writeImage(bim,fileName,300);

	}
	//After visiting all pages of pdf file, just close the document object..
	doc.close();
	}
	public static void main(String[] args) throws IOException 
	{
		pdfToImage("C:\\Users\\Administrator\\Downloads\\Eidiko\\FileConversion\\dummy.pdf");
	System.out.println("done");
	}

}


