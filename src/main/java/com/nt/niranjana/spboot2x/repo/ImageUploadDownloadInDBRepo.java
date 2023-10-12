package com.nt.niranjana.spboot2x.repo;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.niranjana.spboot2x.entity.ImageData;

public interface ImageUploadDownloadInDBRepo extends JpaRepository<ImageData,Long> 
{


    Optional<ImageData> findByName(String fileName);
}