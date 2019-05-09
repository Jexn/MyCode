import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @program: Login
 * @description: 登录页面
 * @author: Cube
 * @create: 2019-05-05 09:53
 **/
public class Login extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        String name = null;
        String password = null;

        PrintWriter out = resp.getWriter();
        Cookie[] cookies = req.getCookies();

        // 已经登录过了
        for (int i = 0; cookies != null && i < cookies.length; i++) {
            if ("username".equals(cookies[i].getName())) {
                name = cookies[i].getValue();
                out.write("欢迎，" + name);
            }
        }

        // 来自网页的登录
        if (name == null) {
            name = req.getParameter("username");
            password = req.getParameter("password");
            if ("root".equals(name) && "root".equals(password)) {
                Cookie cookie = new Cookie("username", name);
                cookie.setMaxAge(60 * 60 * 24 * 10);
                resp.addCookie(cookie);
                out.println("登录成功," + name);
            } else {
                resp.sendRedirect(req.getContextPath() + "/index.jsp");
            }
        }


    }
}
