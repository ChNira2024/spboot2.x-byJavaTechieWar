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

import com.nt.niranjana.spboot2x.service.ImageUploadDownloadInLocalFolderAndOnlyImagePathStoreIntoDBService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/image")
public class ImageUploadDownloadInLocalFolderAndOnlyImagePathStoreIntoDBController 
{

	@Autowired
	private ImageUploadDownloadInLocalFolderAndOnlyImagePathStoreIntoDBService service;
	
	@PostMapping(value="/uploadImageIntoLocalFolder",consumes = {"application/json","application/xml"},produces = {"application/json","application/xml"})
	@ApiOperation(value="uploadImageIntoLocalFolderOnly",notes = "upload image into local folder")
	public ResponseEntity<?> uploadImageIntoLocalFolderOnly(@RequestParam("image")MultipartFile file) throws IOException 
	{
		String uploadImage = service.uploadImageToLocalFolderOnly(file);
		return ResponseEntity.status(HttpStatus.OK)
				.body(uploadImage);
	}

	@PostMapping(value="/uploadImageIntoLocal",consumes = {"application/json","application/xml"},produces = {"application/json","application/xml"})
	@ApiOperation(value="uploadImageIntoLocalFolderAndOnlyImagePathStoreInDB",notes = "upload image into local folder and image path store into db")
	public ResponseEntity<?> uploadImageIntoLocalFolderAndOnlyImagePathStoreInDB(@RequestParam("image")MultipartFile file) throws IOException 
	{
		String uploadImage = service.uploadImageToLocalFolderAndOnlyImagePathStoreIntoDB(file);
		return ResponseEntity.status(HttpStatus.OK)
				.body(uploadImage);
	}

	@GetMapping(value="downloadImageFromLocal/{fileName}",produces = {"application/json","application/xml"})
	@ApiOperation(value="downloadImageFromLocalFolderAndOnlyImagePathStoreInDB",notes = "download image from local folder")
	public ResponseEntity<?> downloadImageFromLocalFolderAndOnlyImagePathStoreInDB(@PathVariable String fileName) throws IOException
	{
		byte[] imageData=service.downloadImageFromLocalFolderAndOnlyImagePathStoreIntoDB(fileName);
		return ResponseEntity.status(HttpStatus.OK)
				.contentType(MediaType.valueOf("image/png"))
				.body(imageData);

	}
}