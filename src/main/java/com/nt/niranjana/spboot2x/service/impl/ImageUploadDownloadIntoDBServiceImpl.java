package com.nt.niranjana.spboot2x.service.impl;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.nt.niranjana.spboot2x.entity.ImageData;
import com.nt.niranjana.spboot2x.repo.ImageUploadDownloadInDBRepo;
import com.nt.niranjana.spboot2x.service.ImageUploadDownloadIntoDBService;
import com.nt.niranjana.spboot2x.util.ImageUtils;

@Service
public class ImageUploadDownloadIntoDBServiceImpl implements ImageUploadDownloadIntoDBService 
{
	    @Autowired
	    private ImageUploadDownloadInDBRepo imageUploadDownloadInDBRepo;

	    @Override
		public String uploadImageIntoDB(MultipartFile file) throws IOException 
	    {

	        ImageData imageData = imageUploadDownloadInDBRepo.save(ImageData.builder()
	                .name(file.getOriginalFilename())
	                .type(file.getContentType())
	                .imageData(ImageUtils.compressImage(file.getBytes())).build());
	        if (imageData != null) 
	        {
	            return "image uploaded successfully : " + file.getOriginalFilename();
	        }
	        else
	        {
	        	return null;
	        }
	    }

	    @Override
		public byte[] downloadImageFromDB(String fileName)
	    {
	        Optional<ImageData> dbImageData = imageUploadDownloadInDBRepo.findByName(fileName);
	        byte[] images=ImageUtils.decompressImage(dbImageData.get().getImageData());
	        return images;
	    }

}
