package com.example.demo.test.util;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;

public class ImageCutUtil {
	/**
	 * 剪切点x坐标
	 */
	private int x;

	/**
	 * 剪切点y坐标
	 */
	private int y;

	/**
	 * 剪切点宽度
	 */
	private int width;

	/**
	 * 剪切点高度
	 */
	private int height;

	public ImageCutUtil() {

	}

	public ImageCutUtil(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	/**
	 * 返回包含所有当前已注册 ImageReader 的 Iterator，这些 ImageReader 声称能够解码指定格式。
	 * 参数：formatName - 包含非正式格式名称 .（例如 "jpeg" 或 "tiff"）等 。
	 * 
	 * @param postFix
	 *            文件的后缀名
	 * @return
	 */
	private Iterator<ImageReader> getImageReadersByFormatName(String postFix) {
		if (postFix.compareToIgnoreCase("jpeg") == 0 || 0 == postFix.compareToIgnoreCase("jpg"))
			return ImageIO.getImageReadersByFormatName("jpg");
		else if (postFix.compareToIgnoreCase("png") == 0)
			return ImageIO.getImageReadersByFormatName("png");
		else
			return ImageIO.getImageReadersByFormatName("jpg");
	}

	public OutputStream cutImage(InputStream cutIs, String imageType) {
		ByteArrayOutputStream outStream = new ByteArrayOutputStream();
		ImageInputStream imageStream = null;
		Iterator<ImageReader> readers = getImageReadersByFormatName(imageType);
		ImageReader reader = readers.next();
		try {
			imageStream = ImageIO.createImageInputStream(cutIs);
			reader.setInput(imageStream, true);
			ImageReadParam param = reader.getDefaultReadParam();
			Rectangle rect = new Rectangle(x, y, width, height);
			param.setSourceRegion(rect);
			BufferedImage bi = reader.read(0, param);
			ImageIO.write(bi, imageType, outStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return outStream;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

}
