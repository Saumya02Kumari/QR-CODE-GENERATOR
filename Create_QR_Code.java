package com.project.com;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter; 
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

public class Create_QR_Code {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
        try {
        	System.out.print("Enter data to encode in QR Code: ");
            String qrCodeData = scanner.nextLine();
            System.out.print("Enter file path to save QR Code (with fileName.png)");
            String filePath = scanner.nextLine();
            String charset = "UTF-8"; // or "ISO-8859-1"
            Map < EncodeHintType, ErrorCorrectionLevel > hintMap = new HashMap < EncodeHintType, ErrorCorrectionLevel > ();
            hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
            BitMatrix matrix = new MultiFormatWriter().encode(
                new String(qrCodeData.getBytes(charset), charset),
                BarcodeFormat.QR_CODE, 200, 200, hintMap);
            MatrixToImageWriter.writeToFile(matrix, filePath.substring(filePath
                .lastIndexOf('.') + 1), new File(filePath));
            System.out.println("QR Code image created successfully!");
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            scanner.close();
        }
    }
}
