package com.srx.web.utils;

import java.io.IOException;

import org.primefaces.model.UploadedFile;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.S3Object;

public class FileUploadUtil {

	private static String bucketName = "repuestos-aws-bucket";
	private static String keyName;
	private static String accessKey = "AKIAJQSCYAIXABESBV7Q";
	private static String secretKey = "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";

	public static void addNewPicture(UploadedFile uploadedFile) {
		System.out.println(com.fasterxml.jackson.databind.ObjectMapper.class.getProtectionDomain().getCodeSource().getLocation());
		AWSCredentials credentials = new BasicAWSCredentials(accessKey, secretKey);
        AmazonS3 s3client = new AmazonS3Client(credentials);
        
        try {
            System.out.println("Uploading a new object to S3 from a file\n");
            keyName = "images/" + uploadedFile.getFileName();
            S3Object s3Object = new S3Object();  
            ObjectMetadata omd = new ObjectMetadata();  
            omd.setContentType(uploadedFile.getContentType());  
            omd.setContentLength(uploadedFile.getSize());  
            omd.setHeader("filename", uploadedFile.getFileName());  
            s3Object.setObjectContent(uploadedFile.getInputstream());  

            s3client.putObject(new PutObjectRequest(
            		                 bucketName, keyName, uploadedFile.getInputstream(), omd).withCannedAcl(CannedAccessControlList.PublicRead));
            System.out.println("Uploading a new object to S3 from a file\n");
            s3Object.close();
         } catch (AmazonServiceException ase) {
            System.out.println("Caught an AmazonServiceException, which " +
            		"means your request made it " +
                    "to Amazon S3, but was rejected with an error response" +
                    " for some reason.");
            System.out.println("Error Message:    " + ase.getMessage());
            System.out.println("HTTP Status Code: " + ase.getStatusCode());
            System.out.println("AWS Error Code:   " + ase.getErrorCode());
            System.out.println("Error Type:       " + ase.getErrorType());
            System.out.println("Request ID:       " + ase.getRequestId());
        } catch (AmazonClientException ace) {
            System.out.println("Caught an AmazonClientException, which " +
            		"means the client encountered " +
                    "an internal error while trying to " +
                    "communicate with S3, " +
                    "such as not being able to access the network.");
            System.out.println("Error Message: " + ace.getMessage());
        } catch (IOException ioe) {
            System.out.println("Caught an IOException, which ");
            System.out.println("Error Message: " + ioe.getMessage());    	
        }

	}

	public static String getBucketName() {
		return bucketName;
	}

	public static void setBucketName(String bucketName) {
		FileUploadUtil.bucketName = bucketName;
	}

	public String getKeyName() {
		return keyName;
	}

	public void setKeyName(String keyName) {
		this.keyName = keyName;
	}

	public static String getAccessKey() {
		return accessKey;
	}

	public static void setAccessKey(String accessKey) {
		FileUploadUtil.accessKey = accessKey;
	}

	public static String getSecretKey() {
		return secretKey;
	}

	public static void setSecretKey(String secretKey) {
		FileUploadUtil.secretKey = secretKey;
	}


}
