package com.nt.niranjana.spboot2x.controller;


import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.nt.niranjana.spboot2x.response.UploadImageIntoDBResponse;
import com.nt.niranjana.spboot2x.service.ImageUploadDownloadIntoDBService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/image")
public class ImageUploadDownloadInDBController 
{

	@Autowired
	private ImageUploadDownloadIntoDBService imageUploadDownloadIntoDBService;

	@PostMapping(value="/uploadImageIntoDB",consumes = {"application/json","application/xml"},produces = {"application/json","application/xml"})
	@ApiOperation(value="uploadImageIntoDB",notes = "upload image into database")
	public ResponseEntity<UploadImageIntoDBResponse> uploadImageIntoDB(@RequestParam("image")MultipartFile image) throws IOException 
	{
		String fileName = null;
		try 
		{
			 fileName = imageUploadDownloadIntoDBService.uploadImageIntoDB(image);
		}
		catch(IOException e)
		{
			e.printStackTrace();
			return new ResponseEntity<>(new UploadImageIntoDBResponse(null,"Image is not uploaded due to some error"),HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(new UploadImageIntoDBResponse(fileName,"Image uploaded Successfully"),HttpStatus.OK);
		//return ResponseEntity.status(HttpStatus.OK).body(uploadImage);
	}

	@GetMapping(value="downloadImageFromDB/{fileName}",produces = {"application/json","application/xml"})
	@ApiOperation(value="downloadImageFromDB",notes = "download image from database")
	public ResponseEntity<?> downloadImageFromDB(@PathVariable String fileName)
	{
		byte[] imageData=imageUploadDownloadIntoDBService.downloadImageFromDB(fileName);
		return ResponseEntity.status(HttpStatus.OK)
				.contentType(MediaType.valueOf("image/png"))
				.body(imageData);

	}
}