import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @program: DisposeAjax
 * @description: btn01 Ajax请求处理
 * @author: Cube
 * @create: 2019-05-07 09:45
 **/
@WebServlet(value = "/btn01")
public class DisposeAjax extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        System.out.println(username+":"+password+"访问");
        resp.getWriter().write(username+",欢迎登录");
    }
}
