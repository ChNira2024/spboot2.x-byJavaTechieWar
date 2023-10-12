package com.nt.niranjana.spboot2x.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nt.niranjana.spboot2x.entity.FileUploadEntity;

@Repository
public interface MultipartFileUploadIntoDBRepo extends JpaRepository<FileUploadEntity, Integer> 
{

	
}
