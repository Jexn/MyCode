package com.cube.Upload;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;

/**
 * @author Cube
 * @className FileUploadController
 * @description 文件上传
 * @date 2019-05-12 16:58
 */
@Controller
public class FileUploadController {

    @RequestMapping("/upload01")
    public ModelAndView upload(MultipartFile photo, HttpSession session) {
        ModelAndView modelAndView = new ModelAndView();
        String path = session.getServletContext().getRealPath("/File");
        fileUpload(modelAndView,photo,path);
        modelAndView.setViewName("forward:/Upload.jsp");
        return modelAndView;
    }

    // 上传多个文件
    @RequestMapping("/upload02")
    public ModelAndView multiUpload(MultipartFile[] photos, HttpSession session) {
        ModelAndView modelAndView = new ModelAndView();
        String path = session.getServletContext().getRealPath("/File");
        for (MultipartFile photo : photos) {
            fileUpload(modelAndView,photo,path);
        }
        return modelAndView;
    }

    private static void fileUpload(ModelAndView modelAndView, MultipartFile photo, String path) {
        if (!photo.isEmpty()) {
            // 获取文件上传的名称
            String fileName = photo.getOriginalFilename();
            System.out.println(path);
            // 限制文件上传类型
            if ("image/png".equals(photo.getContentType())) {
                File file = new File(path, fileName);
                try {
                    photo.transferTo(file);
                    modelAndView.addObject("msg", "文件上传成功");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                modelAndView.addObject("msg", "请选择png格式图片上传");
            }
        } else {
            modelAndView.addObject("msg", "你没有上传文件");
        }
    }
}
