//package com.eidiko.niranjana.StandaloneReader;  //jars: tika-core:1.28.4.jar, tika-parser:1.28.4.jar       //No output came
//
//import java.io.File;
//import java.io.FileInputStream;
//
////Importing Apache POI classes
//import org.apache.tika.metadata.Metadata;
//import org.apache.tika.parser.ParseContext;
//import org.apache.tika.parser.pdf.PDFParser;
//import org.apache.tika.sax.BodyContentHandler;
//
////Class
//public class PdfFileReader2 {
//
//	// Main driver method
//	public static void main(String[] args) throws Exception
//	{
//
//		// Create a content handler
//		BodyContentHandler contenthandler
//			= new BodyContentHandler();
//
//		// Create a file in local directory
//		File f = new File("C:\\Users\\Sreenivas Bandaru\\Downloads\\Sisu\\Eidiko\\TableDataWithRows.pdf");
//
//		// Create a file input stream
//		// on specified path with the created file
//		FileInputStream fstream = new FileInputStream(f);
//
//		// Create an object of type Metadata to use
//		Metadata data = new Metadata();
//
//		// Create a context parser for the pdf document
//		ParseContext context = new ParseContext();
//
//		// PDF document can be parsed using the PDFparser
//		// class
//		PDFParser pdfparser = new PDFParser();
//
//		// Method parse invoked on PDFParser class
//		pdfparser.parse(fstream, contenthandler, data,
//						context);
//
//		// Printing the contents of the pdf document
//		// using toString() method in java
//		System.out.println("Extracting contents :"
//						+ contenthandler.toString());
//	}
//}
package com.nt.niranjana.spboot2x.standaloneFileReader;




