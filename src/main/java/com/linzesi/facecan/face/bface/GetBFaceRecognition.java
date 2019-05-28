package com.linzesi.facecan.face.bface;

import com.baidu.aip.face.AipFace;
import com.linzesi.facecan.face.base64.ImageToBase64Convert;
import org.json.JSONObject;

import javax.imageio.stream.FileImageInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

public class GetBFaceRecognition {

    public static final String APP_ID = "16269934";
    public static final String API_KEY = "QaZFR7GgvyC5eXtjLGqy6paC";
    public static final String SECRET_KEY = "BRG4KVwe1fivh1g4IipnXu0Q5axK0tEE";
    private String imagePath = "";
    private String groupId = "";
    private String contrastNum = "";

    /**
     * @param imagePath   图片地址
     * @param groupId     对比分组ID
     * @param contrastNum 对比分组个数
     */
    public GetBFaceRecognition(String imagePath, String groupId, String contrastNum) {
        super();
        this.imagePath = imagePath;
        this.groupId = groupId;
        this.contrastNum = contrastNum;
    }

    /**
     * 进入人脸识别 返回匹配相似度json
     *
     * @return
     */
    public JSONObject getBFace() {
        AipFace client = new AipFace(APP_ID, API_KEY, SECRET_KEY);

        HashMap<String, String> options = new HashMap<String, String>();
        options.put("ext_fields", "faceliveness");
        options.put("user_top_num", this.contrastNum);
        String imageType = "BASE64";
        String groupIdList = "face,2";
    // 人脸搜索
        return  client.search(ImageToBase64Convert.getImageBase64(imagePath), imageType, groupIdList, options);

    }


    /**
     * 读取本地图片并返回byte[]数组
     *
     * @param imageFilePath
     * @return
     */
    private byte[] readImageFile(String imageFilePath) {
        byte[] data = null;
        FileImageInputStream input = null;
        try {
            input = new FileImageInputStream(new File(imageFilePath));
            ByteArrayOutputStream output = new ByteArrayOutputStream();
            byte[] buf = new byte[1024];
            int numBytesRead = 0;
            while ((numBytesRead = input.read(buf)) != -1) {
                output.write(buf, 0, numBytesRead);
            }
            data = output.toByteArray();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }

}
