package com.forever.tesistas.web.action.utils;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.interceptor.ServletRequestAware;
import com.opensymphony.xwork2.ActionSupport;

public class ImageAction extends ActionSupport implements ServletRequestAware {

	private static final long serialVersionUID = 1L;

	public static final String IMAGE_PATH = "/home/bertex/image/";

	byte[] imageInByte = null;
	String imageId;

	private HttpServletRequest servletRequest;

	public String getImageId() {
		return imageId;
	}

	public void setImageId(String imageId) {
		this.imageId = imageId;
	}

	public ImageAction() {
		System.out.println("ImageAction");
	}

	public String execute() {
		return SUCCESS;
	}

	public byte[] getCustomImageInBytes() {

		System.out.println("imageId" + imageId);

		BufferedImage originalImage;
		try {
			originalImage = ImageIO.read(getImageFile(this.imageId));
			// convert BufferedImage to byte array
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ImageIO.write(originalImage, "jpg", baos);
			baos.flush();
			imageInByte = baos.toByteArray();
			baos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return imageInByte;
	}

	private File getImageFile(String imageId) {
		File file = new File(imageId);
		System.out.println(file.toString());
		return file;
	}

	public String getCustomContentType() {
		return "image/jpeg";
	}

	public String getCustomContentDisposition() {
		return "anyname.jpg";
	}

	public void setServletRequest(HttpServletRequest request) {
		this.servletRequest = request;

	}

}