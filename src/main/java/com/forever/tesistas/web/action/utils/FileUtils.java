package com.forever.tesistas.web.action.utils;

import java.io.File;

import org.apache.log4j.Logger;

public class FileUtils {

	private static final Logger logger = Logger.getLogger(FileUtils.class);

	
	public static boolean deleteFile(String path) {
		logger.info("deleteFile()");
		try {
			File fileTemp = new File(path);
			if (fileTemp.exists()) {
				return fileTemp.delete();
			}
		} catch (Exception e) {
			// if any error occurs
			e.printStackTrace();
		}
		return false;
	}
}
