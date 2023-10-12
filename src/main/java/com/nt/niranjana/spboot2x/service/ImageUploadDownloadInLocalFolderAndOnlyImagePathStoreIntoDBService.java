package com.nt.niranjana.spboot2x.service;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public interface ImageUploadDownloadInLocalFolderAndOnlyImagePathStoreIntoDBService 
{

	public String uploadImageToLocalFolderOnly(MultipartFile file) throws IOException;
	public String uploadImageToLocalFolderAndOnlyImagePathStoreIntoDB(MultipartFile file) throws IOException;
	public byte[] downloadImageFromLocalFolderAndOnlyImagePathStoreIntoDB(String fileName) throws IOException;
	

}

