package com.tpms.utils;

import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class UploadUtils {
    //封装上传操作的方法
    public static String upload(Part part) {
        //1、获取文件名
        String filename = part.getSubmittedFileName();
        filename = UUID.randomUUID() + filename;
        //2、将Part中的内容写入新文件中保存
        String dirPath = "D:/eduSource";//存放文件的文件夹
        File file = new File(dirPath);
        if (!file.exists()) {//不存在
            file.mkdirs();//创建
        }
        try {
            part.write(dirPath + "/" + filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return filename;
    }
}
