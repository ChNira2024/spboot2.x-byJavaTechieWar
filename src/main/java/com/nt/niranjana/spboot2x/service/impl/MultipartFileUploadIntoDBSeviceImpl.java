package com.nt.niranjana.spboot2x.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.niranjana.spboot2x.entity.FileUploadEntity;
import com.nt.niranjana.spboot2x.repo.MultipartFileUploadIntoDBRepo;
import com.nt.niranjana.spboot2x.service.MultipartFileUploadIntoDBService;

@Service
public class MultipartFileUploadIntoDBSeviceImpl implements MultipartFileUploadIntoDBService 
{

	@Autowired
	private MultipartFileUploadIntoDBRepo repo;
	@Override
	public String FileUploadInDB(FileUploadEntity fileupload) 
	{
		FileUploadEntity entity = repo.save(fileupload);
		if(fileupload!=null)
			return "file uploaded successfully ::"+fileupload.getId();
		else
		return "file uploaded successfully"; 
	}

}
