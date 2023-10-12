package com.nt.niranjana.spboot2x.response;

public class UploadImageIntoDBResponse
{
	
	private String fileName;
	private String message;
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public UploadImageIntoDBResponse(String fileName, String message) {
		super();
		this.fileName = fileName;
		this.message = message;
	}
	public UploadImageIntoDBResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "UploadImageIntoDBResponse [fileName=" + fileName + ", message=" + message + "]";
	}
	
	

}
