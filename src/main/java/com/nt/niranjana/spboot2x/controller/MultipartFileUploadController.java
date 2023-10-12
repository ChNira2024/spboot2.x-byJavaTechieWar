package com.nt.niranjana.spboot2x.controller;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.nt.niranjana.spboot2x.entity.FileUploadEntity;
import com.nt.niranjana.spboot2x.service.MultipartFileUploadIntoDBService;

import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping("/multipartfile")
public class MultipartFileUploadController 
{

	@Autowired
	private MultipartFileUploadIntoDBService service;
	
	
	@PostMapping(value="/uploadMultipleFileIntoDB",produces = {"application/json","application/xml"})
	@ApiOperation(value="uploadMultipleFile",notes = "This endpoint helps to store multiplefile at a time into db")
	public String uploadMultipleFile(@RequestParam("files") List<MultipartFile> file,
			@RequestParam("accountNumber") String accountNumber,@RequestParam("destination") String destination) throws IOException
	{
		 //read Content which is coming from POSTMAN
			System.out.println("Account Number is :"+accountNumber);
			System.out.println("Destination is :"+destination);
			for(MultipartFile fileList : file)
			{
				System.out.println("All files are :"+fileList.getOriginalFilename());    //we get all the files here
				List<InputStream> result = new ArrayList<>();
				String line;
				BufferedReader br;
				InputStream is = fileList.getInputStream();
				br = new BufferedReader(new InputStreamReader(is));
				while ((line = br.readLine()) != null) 
				{
					result.add(is);
				}
			File fileUploadLocation = new File("C:\\Users\\Sreenivas Bandaru\\Downloads\\Eidiko\\New folder");
			fileUploadLocation.getAbsolutePath();		
			//Now prepare Entity class object
			 FileUploadEntity info1=new FileUploadEntity();
			 info1.setAccountNumber(accountNumber);
			 info1.setDestination(destination);
			 info1.setFilePath(fileUploadLocation.getAbsolutePath().replace('\\','/') +"/"  +fileList.getOriginalFilename());
		
			 service.FileUploadInDB(info1);
			 }//for-loop close
			
		 return "uploaded";
	}//method close
}//class clsoe