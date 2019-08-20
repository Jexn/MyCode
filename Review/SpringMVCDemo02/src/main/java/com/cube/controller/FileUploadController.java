package com.cube.controller;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

/**
 * TODO：
 * author：Cube
 * create：2019-06-28 10:52
 */
@Controller
@RequestMapping("/fileUpload")
public class FileUploadController {

    @RequestMapping("file01")
    public String fileUpload01(HttpServletRequest request) throws Exception {
        System.out.println("文件上传");

        //文件上传位置
        String path = request.getSession().getServletContext().getRealPath("/uploads/");
        System.out.println(path);
        File file = new File(path);
        if (!file.exists()) {
            file.mkdirs();
        }

        // 解析request对象，获取上传文件项
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);

        // 解析request
        List<FileItem> items = upload.parseRequest(request);
        for (FileItem item : items) {
            //判断是否是上传文件项
            if (item.isFormField()) {
                // 普通表单
                System.out.println("普通表单");
            } else {
                // 获取上传文件的名称
                String fileName = item.getName();
                String uuid = UUID.randomUUID().toString().replace("-", "");
                fileName = uuid + "_" + fileName;
                // 上传文件写入
                item.write(new File(path, fileName));
                // 删除临时文件
                item.delete();
            }
        }
        return "success";
    }

    @RequestMapping("file02")
    public String fileUpload02(HttpServletRequest request, MultipartFile photo) throws IOException {
        System.out.println("SpringMVC文件时上传");
        String path = request.getSession().getServletContext().getRealPath("/uploads/");
        File file = new File(path);
        if (!file.exists()){
            file.mkdirs();
        }

        String fileName = photo.getOriginalFilename();
        String uuid = UUID.randomUUID().toString().replace("-", "");
        fileName = uuid + "-" + fileName;
        photo.transferTo(new File(path,fileName));
        return "success";
    }
}
