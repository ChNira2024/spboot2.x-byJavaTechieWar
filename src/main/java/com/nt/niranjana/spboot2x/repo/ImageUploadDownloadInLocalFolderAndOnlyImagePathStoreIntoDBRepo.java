package com.nt.niranjana.spboot2x.repo;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.niranjana.spboot2x.entity.FileData;

public interface ImageUploadDownloadInLocalFolderAndOnlyImagePathStoreIntoDBRepo extends JpaRepository<FileData,Long> 
{


	Optional<FileData> findByName(String fileName);
}