package com.ldx.utils;

import cn.hutool.core.io.FileUtil;
import cn.hutool.extra.qrcode.QrCodeUtil;
import cn.hutool.extra.qrcode.QrConfig;
import com.google.zxing.qrcode.QRCodeReader;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import java.io.File;

public class CreateQRCode {
    public static void main(String[] args) {
        // 设置二维码的宽和高都是300像素
        QrConfig config  = new QrConfig(300,300);
        config.setErrorCorrection(ErrorCorrectionLevel.H);
        // 设置编剧,即二维码和背景之间的边距
        config.setMargin(1);
        // 设置二维码中的Log图片
        config.setImg("C:\\Users\\ldx\\Desktop\\个人简历.jpg");
        // 生成指定Url对应的二维码到文件,宽和高都是300像素
        File file = FileUtil.file("qrCode.jpg");
        QrCodeUtil.generate("https://www.baidu.com",config,file);
    }
}
