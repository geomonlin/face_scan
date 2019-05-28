package com.linzesi.facecan.bface.controller;

import com.linzesi.facecan.face.bfacebase64.GetBFaceRecognitionBase64;
import com.linzesi.facecan.face.bfacebase64.SetBFaceRecognitionBase64;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.UUID;


@Controller
@RequestMapping("/bface/face")
public class BFaceController {

    /**
     * 传入人脸图片，返回人脸匹配信息
     *
     * @return java.lang.String
     * @param: [base, request]
     * @author lichenyi
     * @date 2018/7/17/017 22:04
     */
    @RequestMapping("getBFace.baidu")
    @ResponseBody
    public String getRenlian(String base, HttpServletRequest request) {
        System.err.println("=========进入");
        UUID imgName = UUID.randomUUID();
        String basePath = this.base64SubString(base);
        GetBFaceRecognitionBase64 getBFaceRecognitionBase64 = new GetBFaceRecognitionBase64(basePath, "face", "1",
                "F://upload"+File.separator + imgName + ".jpg");
        System.out.println("人脸路径"+ "F:\\upload"+File.separator + imgName + ".jpg");
        return getBFaceRecognitionBase64.getBFaceBase64().toString();
    }

    /**
     * 得到人脸图片录入人脸。返回录入结结果
     *
     * @return java.lang.String
     * @param: [base, uid, userInfo, request]
     * @author lichenyi
     * @date 2018/7/17/017 22:05
     */
    @PostMapping("setBFace.baidu")
    @ResponseBody
    public String setRenlian(String base, String uid, String userInfo, HttpServletRequest request) {
        UUID imgName = UUID.randomUUID();
        String basePath = this.base64SubString(base);
        SetBFaceRecognitionBase64 setBFaceRecognitionBase64 = new SetBFaceRecognitionBase64(basePath, uid, userInfo, "face",
               "F://upload"+File.separator + imgName + ".jpg");
        return setBFaceRecognitionBase64.setBFaceBase64().toString();
    }

    /**
     * 将得到的base64位图像地址截取返回截取后的图像地址
     *
     * @return java.lang.String
     * @param: [base]
     * @author lichenyi
     * @date 2018/7/17/017 22:23
     */
    public String base64SubString(String base) {
        return base.substring(22);
    }

    /**
     * 图像存入本地的路径
     *
     * @return java.lang.String
     * @param: [request, imgName]
     * @author lichenyi
     * @date 2018/7/17/017 22:27
     */
    public String getImagePath(HttpServletRequest request, UUID imgName) {
        return request.getSession().getServletContext().getRealPath("/upload") + File.separator + imgName + ".jpg";
    }


}
