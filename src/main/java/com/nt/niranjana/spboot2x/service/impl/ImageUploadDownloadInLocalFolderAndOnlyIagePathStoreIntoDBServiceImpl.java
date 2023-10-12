package com.nt.niranjana.spboot2x.service.impl;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.nt.niranjana.spboot2x.entity.FileData;
import com.nt.niranjana.spboot2x.repo.ImageUploadDownloadInLocalFolderAndOnlyImagePathStoreIntoDBRepo;
import com.nt.niranjana.spboot2x.service.ImageUploadDownloadInLocalFolderAndOnlyImagePathStoreIntoDBService;

@Service
public class ImageUploadDownloadInLocalFolderAndOnlyIagePathStoreIntoDBServiceImpl implements ImageUploadDownloadInLocalFolderAndOnlyImagePathStoreIntoDBService 
{
	    @Autowired
	    private ImageUploadDownloadInLocalFolderAndOnlyImagePathStoreIntoDBRepo localFolderAndDBRepo;
	    
	    @Override
		public String uploadImageToLocalFolderOnly(MultipartFile file) throws IOException  
	    {
	    	//String FOLDER_PATH="C:\\sts\\Niranjana\\spbootVersion2.x-byjavatechie\\src\\main\\resources\\static\\image\\";  //working fine
	    	
	    	/** instead of using above manual path, use server side below given path(31line,32line) so that another develpoer will not get path issue  **/
	    	
	    	//String FOLDER_PATH = new ClassPathResource("/static/image").getFile().getAbsolutePath(); //not working:file not showing in project structure
	    	String FOLDER_PATH = new File("src/main/resources/static/image/").getAbsolutePath();//working fine
	    	
	    	Files.copy(file.getInputStream(),Paths.get(FOLDER_PATH+File.separator+file.getOriginalFilename()),StandardCopyOption.REPLACE_EXISTING);
	    	
	        return "file uploaded into local folder successfully  : " ;    
	    }
	    
//------------------------------------------------------------------------------------------------------------------	   
	    
	    //private final String FOLDER_PATH="C:\\sts\\Niranjana\\spbootVersion2.x-byjavatechie\\src\\main\\resources\\static\\image\\"; //working fine
	    /** instead of using above manual path, use server side below given path(47line,48line) so that another develpoer will not get path issue  **/
    	
	    @Override
		public String uploadImageToLocalFolderAndOnlyImagePathStoreIntoDB(MultipartFile file) throws IOException 
	    {
	    	//String FOLDER_PATH = new ClassPathResource("/static/image").getFile().getAbsolutePath(); //not working:file not showing in project structure
	    	String FOLDER_PATH = new File("src\\main\\resources\\static\\image\\").getAbsolutePath();//working fine
	    	String filePath=FOLDER_PATH+"\\"+file.getOriginalFilename();	  
	    	file.transferTo(new File(filePath));

	        FileData fileData=localFolderAndDBRepo.save(FileData.builder().name(file.getOriginalFilename()).type(file.getContentType()).filePath(filePath).build());
	        System.out.println("Details of the file and file path stored in DB: "+fileData);
	        
	        if (fileData != null) 
	        {
	            return "file uploaded successfully in Local folder  : " + filePath;
	        }
	        else
	        {
	        	return null;
	        }   	        
	    }

	    @Override
		public byte[] downloadImageFromLocalFolderAndOnlyImagePathStoreIntoDB(String fileName) throws IOException
	    {
	    	Optional<FileData> fileData = localFolderAndDBRepo.findByName(fileName);
	        String filePath=fileData.get().getFilePath();
	        byte[] images = Files.readAllBytes(new File(filePath).toPath());
	        return images;
	    }

}
