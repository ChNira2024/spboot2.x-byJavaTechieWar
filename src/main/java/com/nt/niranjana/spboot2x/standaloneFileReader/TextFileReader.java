package com.nt.niranjana.spboot2x.standaloneFileReader;   //working fine

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class TextFileReader {
  //Approach 1: read file from user using scanner class and with using Loops(insert Hardcore text file)
	public static  void ReadTextFile()
	{
		try {
			Scanner scn = new  Scanner(new File("C:\\Users\\Sreenivas Bandaru\\Downloads\\Sisu\\Sample files\\data.txt"));
			while(scn.hasNextLine())
			{
				System.out.println("Text file datas are: "+scn.nextLine());
				//System.out.println("Text file datas are: "+scn.next());//if we execute this line then if any space came betwn text then it will go to next line 
			}	
		}
		catch(FileNotFoundException fe)
		{
			fe.printStackTrace();
		}
	}
	
	//Approach 2: read file from user using scanner class and WITHOUT using Loops(insert Hardcore text file)
	public static  void ReadTextFile1()
	{
		try {
				File file = new File("C:\\Users\\Sreenivas Bandaru\\Downloads\\Sisu\\Sample files\\data.txt");
			    Scanner sc = new Scanner(file);
			    sc.useDelimiter("\\Z");
			    System.out.println("Text file datas are: "+sc.next());
			}
		catch(FileNotFoundException fe)
		{
				fe.printStackTrace();
		}
	}
	
	//Approach 3: read file from user using  BufferedReader class (insert Hardcore text file)
		public static  void ReadTextFile2() throws IOException
		{
			try {
					File file = new File("C:\\Users\\Sreenivas Bandaru\\Downloads\\Sisu\\Sample files\\data.txt");
					BufferedReader br= new BufferedReader(new FileReader(file));
		           String st;
		           while ((st = br.readLine()) != null)
		            System.out.println("Text file content are: "+st);
		      }
			catch(FileNotFoundException fe)
			{
					fe.printStackTrace();
			}
		}
		//Approach 4: read file from user using  FileReader class (insert Hardcore text file)
				public static  void ReadTextFile3() throws IOException 
				{
					try {
						FileReader fr = new FileReader("C:\\Users\\Sreenivas Bandaru\\Downloads\\Sisu\\Sample files\\data.txt");					 
					    int i;
					     while ((i = fr.read()) != -1)
					     {
					            System.out.print((char)i);
					    }
				      }
					catch(FileNotFoundException fe)
					{
							fe.printStackTrace();
					}
				}
	public static void main(String[] args) throws IOException {
		//TextFileReader.ReadTextFile();
		//TextFileReader.ReadTextFile1();
		//TextFileReader.ReadTextFile2();
		TextFileReader.ReadTextFile3();
	}
}
