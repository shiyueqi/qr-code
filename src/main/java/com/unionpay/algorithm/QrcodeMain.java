package com.unionpay.algorithm;

/**
 * date: 2017/05/15 12:00.
 * author: Yueqi Shi
 */
public class QrcodeMain {

    public static void main(String[] args) {
        //XX可自行替换人名
        String contentsPre = "TO XX: \n";

        //使用微信识别时，打印心形
        String contents = contentsPre + Heart.simpleWeChatHeart("*");

        //IDEA控制台打印心形
        //String contents = contentsPre + Heart.simpleHeart("*");

        //保存二维码图片路径
        String filePath = "F:/qr-code.png";

        QrCodeEncode.encodeQrCode(contents, filePath, 400, 400, 11);

        String res = QrCodeDecode.decodeQrCode(filePath);
        System.out.println(res);
    }
}
