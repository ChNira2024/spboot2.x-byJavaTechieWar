package com.nt.niranjana.spboot2x.standaloneFileReader;  //working fine

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
//Java program to illustrate reading data from file
//using nio.File
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
public class ReadTextFileIntoList
{
public static List<String> readFileInList(String fileName)
{

	List<String> lines = Collections.emptyList();
	try
	{
	lines =
	Files.readAllLines(Paths.get(fileName), StandardCharsets.UTF_8);
	}

	catch (IOException e)
	{

	// do something
	e.printStackTrace();
	}
	return lines;
}
public static void main(String[] args)
{
	List l = readFileInList("C:\\Users\\Sreenivas Bandaru\\Downloads\\Sisu\\Sample files\\data.txt");

	Iterator<String> itr = l.iterator();
	while (itr.hasNext())
	System.out.println(itr.next());
}
}

