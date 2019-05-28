package com.linzesi.facecan.face.bfacebase64;

import com.linzesi.facecan.face.base64.ImageToBase64Convert;
import com.linzesi.facecan.face.bface.GetBFaceRecognition;
import org.json.JSONObject;

public class GetBFaceRecognitionBase64 {

    private String base64;
    private String groupName;
    private String returnCount = "1";
    private String path;

    public GetBFaceRecognitionBase64(String base64, String groupName, String returnCount, String path) {
        this.base64 = base64;
        this.groupName = groupName;
        this.returnCount = returnCount;
        this.path = path;

    }

    /**
     * 进入人脸识别 返回匹配相似度json
     *
     * @return org.json.JSONObject
     * @param: []
     * @author lichenyi
     * @date 2018/7/17/017 22:37
     */
    public JSONObject getBFaceBase64() {
        JSONObject jsonDate = null;
        if (ImageToBase64Convert.getImageFilePath(this.base64, this.path)) {
            GetBFaceRecognition getBFaceRecognition = new GetBFaceRecognition(this.path, this.groupName, this.returnCount);
            jsonDate = getBFaceRecognition.getBFace();
            System.out.println("相应数据"+jsonDate);
        } else {
            jsonDate = null;
        }
        return jsonDate;
    }


}
