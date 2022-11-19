package cn.tongji.study.util;

import cn.tongji.study.config.BaiduAiConfig;

import org.json.JSONObject;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @Author : 王晨
 * @Date : Created in 23:49 2022/11/15
 */
public class BaiDuAiCheck {
    public static JSONObject checkImg(MultipartFile file) throws IOException {
        // 参数为本地图片路径
//        JSONObject response = BaiDuAiConfig.client.imageCensorUserDefined(imgPath, EImgType.FILE, null);
//        System.out.println(response.toString());

        // 参数为url
//        String url = "http://testurl";
//        response = client.imageCensorUserDefined(url, EImgType.URL, null);
//        System.out.println(response.toString());

        // 参数为本地图片文件二进制数组
        byte[] files = FileCopyUtils.copyToByteArray(file.getInputStream());
        JSONObject response = BaiduAiConfig.client.imageCensorUserDefined(files, null);
        System.out.println(response);
        return response;
    }

    /**
     *@Author: ZongMao on 2020/3/28 13:14
     *文本审核功能
     *@return
     */
    public static JSONObject checkText(String text){
        // 参数为输入文本
        JSONObject response = BaiduAiConfig.client.textCensorUserDefined(text);
        return response;
    }
}
