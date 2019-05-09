import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class PostAjax extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("username");
        int age = Integer.parseInt(req.getParameter("age"));

        if ("laowang".equals(name)){
            resp.getWriter().write("老王年龄："+age);
        }else {
            resp.getWriter().write("请求错误");
        }
    }
}
