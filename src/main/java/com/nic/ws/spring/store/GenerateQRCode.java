package com.nic.ws.spring.store;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Hashtable;

import javax.imageio.ImageIO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;


public class GenerateQRCode {
	private static final Logger logger = LoggerFactory.getLogger(GenerateQRCode.class);
	public static final String IRP_JSON_BASE_PATH = PropStore.KEYS("prop.irp_json_base_path");

	public static void  generate(String purpose, String sub_path,String fileName,String qrCodeText) throws WriterException, IOException {
		String filePath="";
		if(purpose.equals("ROOT")) {
			filePath = IRP_JSON_BASE_PATH+"\\IRP_JSON\\"+sub_path+"\\IRN\\"+fileName+"\\"+fileName+".png";
		}else {
			filePath = IRP_JSON_BASE_PATH+"\\TEMP\\IRP_JSON\\"+sub_path+"\\IRN\\"+fileName+"\\"+fileName+".png";
		}
		int size = 125;
		String fileType = "png";
		File qrFile = new File(filePath);
		createQRImage(qrFile, qrCodeText, size, fileType);
		logger.info("QR DONE --"+fileName);
	}

	private static void createQRImage(File qrFile, String qrCodeText, int size, String fileType)
			throws WriterException, IOException {
		// Create the ByteMatrix for the QR-Code that encodes the given String
		Hashtable<EncodeHintType, ErrorCorrectionLevel> hintMap = new Hashtable<EncodeHintType, ErrorCorrectionLevel>();
		hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
		QRCodeWriter qrCodeWriter = new QRCodeWriter();
		BitMatrix byteMatrix = qrCodeWriter.encode(qrCodeText, BarcodeFormat.QR_CODE, size, size, hintMap);
		// Make the BufferedImage that are to hold the QRCode
		int matrixWidth = byteMatrix.getWidth();
		BufferedImage image = new BufferedImage(matrixWidth, matrixWidth, BufferedImage.TYPE_INT_RGB);
		image.createGraphics();

		Graphics2D graphics = (Graphics2D) image.getGraphics();
		graphics.setColor(Color.WHITE);
		graphics.fillRect(0, 0, matrixWidth, matrixWidth);
		// Paint and save the image using the ByteMatrix
		graphics.setColor(Color.BLACK);

		for (int i = 0; i < matrixWidth; i++) {
			for (int j = 0; j < matrixWidth; j++) {
				if (byteMatrix.get(i, j)) {
					graphics.fillRect(i, j, 1, 1);
				}
			}
		}
		ImageIO.write(image, fileType, qrFile);
	}

}