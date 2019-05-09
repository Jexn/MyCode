import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;

/**
 * @program: FileUpload
 * @description: Servlet3.0之后文件上传
 * @author: Cube
 * @create: 2019-05-06 20:57
 **/
@WebServlet("/upload")
@MultipartConfig
public class FileUpload extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = this.getServletContext().getRealPath("/upload");
        System.out.println(path);

        File file = new File(path);
        if (!file.exists()){
            file.mkdirs();
        }

        String name = req.getParameter("username");
        System.out.println(name);
        Part part = req.getPart("photo");

        String filename = part.getSubmittedFileName();
        part.write(path+"/"+filename);
    }
}
