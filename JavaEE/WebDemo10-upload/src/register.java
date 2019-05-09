import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class register extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        // ServletInputStream inputStream = req.getInputStream();
        DiskFileItemFactory itemFactory = new DiskFileItemFactory();
        ServletFileUpload fileUpload = new ServletFileUpload(itemFactory);
        // 设置文件上传大小
        fileUpload.setFileSizeMax(1024 * 1024);

        ServletContext context = getServletContext();
        String realPath = context.getRealPath("File");
        System.out.println("realPath = " + realPath);
        File file = new File(realPath);
        if (!file.exists()) {
            file.mkdirs();
        }
        try {
            List<FileItem> list = fileUpload.parseRequest(req);
            for (FileItem item : list) {
                // System.out.println("item.getFieldName() = " + item.getFieldName());
                // System.out.println("item.getName() = " + item.getName());
                // System.out.println("item.getSize() = " + item.getSize());
                // System.out.println("item.getString() = " + item.getString());
                // System.out.println("item.getContentType() = " + item.getContentType());
                // System.out.println("item.isFormField() = " + item.isFormField());
                if (item.isFormField()) {
                    System.out.println(item.getString());
                } else {
                    // 注意此时需要写绝对路径，否则文件会存入tomcat的bin目录文件夹下
                    try {
                        item.write(new File(file, item.getName()));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }
            }
        } catch (FileUploadBase.FileSizeLimitExceededException e) {
            System.out.println("接受到异常");
            resp.getWriter().write("文件大小不能超过1MB");
        } catch (FileUploadException ex){
            ex.printStackTrace();
        }
    }
}
