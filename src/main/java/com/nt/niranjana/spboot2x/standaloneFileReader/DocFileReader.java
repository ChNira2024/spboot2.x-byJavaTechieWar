package com.nt.niranjana.spboot2x.standaloneFileReader;  //jar: poi-5.2.2.jar, poi-scratchpad-5.2.2.jar, commons-io.2.11.0.jar     //working fine
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hwpf.HWPFDocument;

public class DocFileReader {
	
	public static void main(String args[]) throws IOException {
		try {
		FileInputStream fistream = new FileInputStream("C:\\Users\\Sreenivas Bandaru\\Downloads\\Sisu\\Sample files\\file-sample_500kB.doc");
		HWPFDocument document = new HWPFDocument(fistream);
		System.out.println("Length of docment is :"+ document.characterLength());
		System.out.println("DOC content: "+document.getText());
		System.out.println("DOC content: "+document.getDocumentText());
		}
		catch(FileNotFoundException fe)
		{
			fe.printStackTrace();
			System.out.println("Check file location properly..");
		}
	}
}