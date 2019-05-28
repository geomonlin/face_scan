package com.linzesi.facecan.face.base64;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.*;

public class ImageToBase64Convert {


    /**
     * 传入本地图片地址，返回base64位的图片地址（将本地图片转为base64位图像）
     *
     * @return java.lang.String
     * @param: [imgFilePath]
     * @author lichenyi
     * @date 2018/7/17/017 22:08
     */
    public static String getImageBase64(String imgFilePath) {
        byte[] data = null;
        try {
            InputStream in = new FileInputStream(imgFilePath);
            data = new byte[in.available()];
            in.read(data);
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        BASE64Encoder encoder = new BASE64Encoder();
        return encoder.encode(data);
    }

    /**
     * 传入base64位图像地址和本地路径，将base64位图像转为本地图片，返回转换结果
     *
     * @return boolean
     * @param: [base64, imgFilePath]
     * @author lichenyi
     * @date 2018/7/17/017 22:08
     */
    public static boolean getImageFilePath(String base64, String imgFilePath) {
        if (base64 == null)
            return false;
        BASE64Decoder decoder = new BASE64Decoder();
        try {
            byte[] bytes = decoder.decodeBuffer(base64);
            for (int i = 0; i < bytes.length; ++i) {
                if (bytes[i] < 0) {
                    bytes[i] += 256;
                }
            }
            OutputStream out = new FileOutputStream(imgFilePath);
            out.write(bytes);
            out.flush();
            out.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
