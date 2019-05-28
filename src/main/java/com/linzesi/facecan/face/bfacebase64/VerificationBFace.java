package com.linzesi.facecan.face.bfacebase64;

import com.baidu.aip.face.AipFace;
import org.json.JSONObject;

import java.util.HashMap;

public class VerificationBFace {
    public static final String APP_ID = "16269934";
    public static final String API_KEY = "QaZFR7GgvyC5eXtjLGqy6paC";
    public static final String SECRET_KEY = "BRG4KVwe1fivh1g4IipnXu0Q5axK0tEE";
    private String uid;
    private String groupId;


    public VerificationBFace(String uid, String groupId) {
        super();
        this.uid = uid;
        this.groupId = groupId;
    }

    /**
     * 检测人脸是否存在
     *
     * @return org.json.JSONObject
     * @param: []
     * @author lichenyi
     * @date 2018/7/17/017 22:41
     */
    public JSONObject getBFaceVerification() {

        AipFace client = new AipFace(APP_ID, API_KEY, SECRET_KEY);
        HashMap<String, String> options = new HashMap<String, String>();
        options.put("group_id", this.groupId);
        String groupId = "face";

        return client.getUser(this.uid,groupId, options);
    }

}
