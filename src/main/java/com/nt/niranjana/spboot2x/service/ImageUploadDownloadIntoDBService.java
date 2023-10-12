package com.nt.niranjana.spboot2x.service;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public interface ImageUploadDownloadIntoDBService 
{

	public String uploadImageIntoDB(MultipartFile file) throws IOException;
	public byte[] downloadImageFromDB(String fileName);

}

