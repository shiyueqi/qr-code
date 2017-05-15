package com.unionpay.algorithm;

import com.google.zxing.*;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * date: 2017/05/15 12:11.
 * author: Yueqi Shi
 */
public class QrCodeEncode {

    public static boolean encodeQrCode(String contents, String filePath) {
        return encodeQrCode(contents, filePath, Constants.FILE_FORMAT, Constants.WIDTH, Constants.HEIGHT, Constants.QR_VERSION);
    }

    public static boolean encodeQrCode(String contents, String filePath, String fileFormat) {
        return encodeQrCode(contents, filePath, fileFormat, Constants.WIDTH, Constants.HEIGHT, Constants.QR_VERSION);
    }

    public static boolean encodeQrCode(String contents, String filePath, int qrVersion) {
        return encodeQrCode(contents, filePath, Constants.FILE_FORMAT, Constants.WIDTH, Constants.HEIGHT, qrVersion);
    }

    public static boolean encodeQrCode(String contents, String filePath, int width, int height) {
        return encodeQrCode(contents, filePath, Constants.FILE_FORMAT, width, height, Constants.QR_VERSION);
    }

    public static boolean encodeQrCode(String contents, String filePath, int width, int height, int qrVersion) {
        return encodeQrCode(contents, filePath, Constants.FILE_FORMAT, width, height, qrVersion);
    }

    public static boolean encodeQrCode(String contents, String filePath, String fileFormat, int width, int height) {
        return encodeQrCode(contents, filePath, fileFormat, width, height, Constants.QR_VERSION);
    }

    public static boolean encodeQrCode(String contents, String filePath, String fileFormat
            , int width, int height, int qrVersion) {

        if (width <= 0 || height <= 0) {
            return Boolean.FALSE;
        }

        Map<EncodeHintType, String> hints= new HashMap<EncodeHintType, String>();
        hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
        hints.put(EncodeHintType.QR_VERSION, String.valueOf(qrVersion));
        BitMatrix bitMatrix = null;
        try {
            bitMatrix = new MultiFormatWriter().encode(contents, BarcodeFormat.QR_CODE
                    , width, height, hints);
            File outputFile = new File(filePath);
            MatrixToImageWriter.writeToPath(bitMatrix, fileFormat, outputFile.toPath());

            return Boolean.TRUE;
        } catch (WriterException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return Boolean.FALSE;
    }

}
