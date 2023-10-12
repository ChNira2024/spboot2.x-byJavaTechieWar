package com.nt.niranjana.spboot2x.standaloneFileReader;

import java.awt.image.BufferedImage;   //1.......Take JPG file path from URL and try to convert it to png, bmp, gif and stored in Local Drive
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

import javax.imageio.ImageIO;

public class FileConversionClass_LOCALJPG_To_PNG_BMP_GIFF_TIFF
{
	public static void main(String[] args) 
	{

		try {
			//Here we collect the location of jpg location from Local Drive
			File fileLocation = new File("C:\\Users\\Sreenivas Bandaru\\Downloads\\Sisu\\Sample files\\FileConversion\\Images\\success.jpg");
			//Read the URL using read method which is static method and returns BufferedImage
				BufferedImage image = ImageIO.read(fileLocation);
				String fileNameIs = fileLocation.getName();
				System.out.println("File name is: "+fileNameIs);
			//After reading, we must write that file to somewhere destination by using write() method which has 3-param like (ImageIO image, image format, Destination)
				ImageIO.write(image, "png", new File("C:\\Users\\Sreenivas Bandaru\\Downloads\\Sisu\\Sample files\\FileConversion\\ConvertedImages\\success.png"));
				ImageIO.write(image, "bmp", new File("C:\\Users\\Sreenivas Bandaru\\Downloads\\Sisu\\Sample files\\FileConversion\\ConvertedImages\\success.bmp"));
				ImageIO.write(image, "tiff", new File("C:\\Users\\Sreenivas Bandaru\\Downloads\\Sisu\\Sample files\\FileConversion\\ConvertedImages\\success.tiff"));
				//ImageIO.write(image, "pdf", new File("C:\\Users\\Sreenivas Bandaru\\Downloads\\Sisu\\Sample files\\FileConversion\\ConvertedImages\\success.pdf"));
			}
		catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("File Conversion Happend...");
	}

}
