package com.linzesi.facecan.face.bface;

import com.baidu.aip.face.AipFace;
import org.json.JSONObject;

import java.util.HashMap;

/**
 * 采集人脸
 *
 * @author lichenyi
 * @param:
 * @return
 * @date 2018/7/17/017 22:12
 */
public class SetBFaceRecognition {
    public static final String APP_ID = "16269934";
    public static final String API_KEY = "QaZFR7GgvyC5eXtjLGqy6paC";
    public static final String SECRET_KEY = "BRG4KVwe1fivh1g4IipnXu0Q5axK0tEE";
    private String uid = ""; //用户ID
    private String userInfo = "";//用户信息
    private String groupId = "";//分组信息
    private String imagePath = "";//图片地址（本地路径）

    public SetBFaceRecognition(String uid, String userInfo, String groupId, String imagePath) {
        this.uid = uid;
        this.userInfo = userInfo;
        this.groupId = groupId;
        this.imagePath = imagePath;
    }

    /**
     * 采集人脸
     *
     * @return org.json.JSONObject
     * @param: []
     * @author lichenyi
     * @date 2018/7/17/017 22:16
     */
    public JSONObject setBFace() {
        AipFace client = new AipFace(APP_ID, API_KEY, SECRET_KEY);
        HashMap<String, String> options = new HashMap<String, String>();
        options.put("action_type", "replace");
        return client.addUser(this.uid, this.userInfo, this.groupId, this.imagePath, options);
    }

}
