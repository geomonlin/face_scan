package com.linzesi.facecan.face.bfacebase64;

import com.linzesi.facecan.face.base64.ImageToBase64Convert;
import com.linzesi.facecan.face.bface.SetBFaceRecognition;
import org.json.JSONObject;

public class SetBFaceRecognitionBase64 {
    private String base64;
    private String uid = "";
    private String userInfo = "";
    private String groupId = "";
    private String imagePath = "";

    public SetBFaceRecognitionBase64(String base64, String uid, String userInfo, String groupId, String imagePath) {
        super();
        this.base64 = base64;
        this.uid = uid;
        this.userInfo = userInfo;
        this.groupId = groupId;
        this.imagePath = imagePath;
        ImageToBase64Convert.getImageFilePath(base64,imagePath);
    }

    /**
     * 得到采集结果
     *
     * @return org.json.JSONObject
     * @param: []
     * @author lichenyi
     * @date 2018/7/17/017 22:20
     */
    public JSONObject setBFaceBase64() {
        JSONObject jsonDate = null;
        if (ImageToBase64Convert.getImageFilePath(this.base64, this.imagePath)) {
            SetBFaceRecognition sim = new SetBFaceRecognition(uid, userInfo, groupId, imagePath);
            jsonDate = sim.setBFace();
        } else {
            jsonDate = null;
        }
        return jsonDate;
    }

}
