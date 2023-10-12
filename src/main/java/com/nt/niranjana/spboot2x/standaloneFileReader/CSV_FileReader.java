package com.nt.niranjana.spboot2x.standaloneFileReader;   //working fine

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

/*
 * 
 <!-- https://mvnrepository.com/artifact/com.opencsv/opencsv -->
		<dependency>
			<groupId>com.opencsv</groupId>
			<artifactId>opencsv</artifactId>
			<version>4.6</version>
		</dependency>
 */

public class CSV_FileReader {
  //Approach 1: read CSV file from user using scanner class and with using Loops(insert Hardcore text file)
	public static  void ReadCSVFile()
	{
		try {
			Scanner scn = new  Scanner(new File("C:\\Users\\Sreenivas Bandaru\\Downloads\\Sisu\\Sample files\\Employees.csv"));
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
		System.out.println("..................");
	}
	
	//Approach 2: read CSV file from user using scanner class and WITHOUT using Loops(insert Hardcore text file)
	public static  void ReadCSVFile1()
	{
		try {
				File file = new File("C:\\Users\\Sreenivas Bandaru\\Downloads\\Sisu\\Sample files\\Employees.csv");
			    Scanner sc = new Scanner(file);
			    sc.useDelimiter("\\Z");
			    System.out.println("Text file datas are: "+sc.next());
			}
		catch(FileNotFoundException fe)
		{
				fe.printStackTrace();
		}
		System.out.println("..................");
	}
	
	//Approach 3: read CSV file from user using  BufferedReader class (insert Hardcore text file)
		public static  void ReadCSVFile2() throws IOException
		{
			try {
					File file = new File("C:\\Users\\Sreenivas Bandaru\\Downloads\\Sisu\\Sample files\\Employees.csv");
					BufferedReader br= new BufferedReader(new FileReader(file));
		           String st;
		           while ((st = br.readLine()) != null)
		            System.out.println("Text file content are: "+st);
		      }
			catch(FileNotFoundException fe)
			{
					fe.printStackTrace();
			}
			System.out.println("..................");
		}
		//Approach 4: read CSV file from user using  FileReader class (insert Hardcore text file)
				public static  void ReadCSVFile3() throws IOException 
				{
					try {
						FileReader fr = new FileReader("C:\\Users\\Sreenivas Bandaru\\Downloads\\Sisu\\Sample files\\Employees.csv");					 
					    int i;
					     while ((i = fr.read()) != -1)
					     {
					            System.out.print((char)i);
					    }
					     String newline = System.lineSeparator();
							System.out.println(""+newline+"");
				      }
					catch(FileNotFoundException fe)
					{
							fe.printStackTrace();
					}
					
				}
		//Approach 5: read CSV file using public String[] split(String regex) (inset hardcorre text file)
				
				public static  void ReadCSVFile4() throws IOException 
				{
					String line = "";  
					String splitBy = ","; 
				try   
				{  
					File file = new File("C:\\Users\\Sreenivas Bandaru\\Downloads\\Sisu\\Sample files\\Employees.csv");
				//parsing a CSV file into BufferedReader class constructor  
				BufferedReader br = new BufferedReader(new FileReader(file));  
				while ((line = br.readLine()) != null)   //returns a Boolean value  
				{  
				String[] employee = line.split(splitBy);    // use comma as separator  
				System.out.println("Employee [First Name=" + employee[0] + ", Last Name=" + employee[1] + ", Designation=" + employee[2] + ", Contact=" + employee[3] + ", Salary= " + employee[4] + ", City= " + employee[5] +"]");
				}  
				System.out.print("\n"); //gap one line with one space
				}   
				catch (IOException e)   
				{  
				e.printStackTrace();  
				}
				} 
		//Approach 6: read CSV file using public CSVReader(Reader reader) (inset hardcorre text file)
				public static  void ReadCSVFile5() throws IOException   
				{
					CSVReader reader = null;  
					try  
					{  
						File file = new File("C:\\Users\\Sreenivas Bandaru\\Downloads\\Sisu\\Sample files\\Employees.csv");
						reader = new CSVReader(new FileReader(file));  
						String [] nextLine;  
						//reads one line at a time  
						while ((nextLine = reader.readNext()) != null)  //jar: opencsv-3.8.jar
						{  
							for(String token : nextLine)  
							{  
								System.out.print(token);  
							}  
							System.out.print("\n");
						} 
						
					}  
					catch (Exception e)   
					{  
						e.printStackTrace();  
					}  
				}
		//Approach 6: read CSV file using public CSVReaderBuilder(Reader reader) (inset hardcorre text file)
				public static  void ReadCSVFile6() throws IOException   
				{
					try {
				
					File file = new File("C:\\Users\\Sreenivas Bandaru\\Downloads\\Sisu\\Sample files\\Employees.csv");
				 FileReader filereader = new FileReader(file);
				  
			        // create csvReader object and skip first Line
			        CSVReader csvReader = new CSVReaderBuilder(filereader) .withSkipLines(1) .build(); //It will skip the header
			        List<String[]> allData = csvReader.readAll();
			        // print Data
			        for (String[] row : allData) {
			            for (String cell : row) {
			                System.out.print(cell);
			            }
			            System.out.println();
			        }
					}
			    catch (Exception e) {
			        e.printStackTrace();
			    }
				}
	public static void main(String[] args) throws IOException {
		//CSV_FileReader.ReadCSVFile();
		//CSV_FileReader.ReadCSVFile1();
		//CSV_FileReader.ReadCSVFile2();
		//CSV_FileReader.ReadCSVFile3();
		CSV_FileReader.ReadCSVFile4();
		//CSV_FileReader.ReadCSVFile5();
		//CSV_FileReader.ReadCSVFile6();
	}
}
