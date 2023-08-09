package com.Numitry.in.util;

import java.io.IOException;
import java.nio.file.FileSystems;

import com.Numitry.in.entity.Student;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

public class QRCodeGenerator {
	
	public static void generateQRCode(Student student) throws WriterException, IOException
	{
		String qrCodePath = "G:\\realme Praful\\";
		String qrCodeName= qrCodePath + student.getName()+student.getId()+"-QRCODE.png";
		
		var qrCodeWriter = new QRCodeWriter();
		BitMatrix bitMatrix = qrCodeWriter.encode("Id:"+student.getId()+"\n"+
												  "name"+student.getName()+"\n"+
												  "email"+student.getEmail()+"\n"+
												  "mobile"+student.getMobile(),BarcodeFormat.QR_CODE,400,400);
			
			java.nio.file.Path path= FileSystems.getDefault().getPath(qrCodeName);
			
			MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);
			
		}

}
