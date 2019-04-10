package net.kzn.onlineshopping.util;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

public class FileUploadUtility {

	private static final String ABS_PATH = "//home//apatle//Eclipse_Workspaces//OnlineShopping//online-shopping//onlineshopping//src//main//webapp//assets//images//";
	private static String REAL_PATH = "";
	
	private static final Logger logger = LoggerFactory.getLogger(FileUploadUtility.class);
	
	public static void uploadFile(HttpServletRequest httpServletRequest, MultipartFile file, String code) {

		logger.info("Real path of images: " + REAL_PATH);
		
		//Get the real path
		REAL_PATH = httpServletRequest.getSession().getServletContext().getRealPath("/assets/images/");
		
		//To make sure the directory exists before perform write operation
		if (! new File(ABS_PATH).exists()) {
			new File(ABS_PATH).mkdir();
		}
		
		if (! new File(REAL_PATH).exists()) {
			new File(REAL_PATH).mkdir();
		}
		
		try {
			//Server upload 
			file.transferTo(new File(REAL_PATH + code + ".jpg"));
			
			//Project Directory upload
			file.transferTo(new File(ABS_PATH + code + ".jpg"));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
		
	
}
