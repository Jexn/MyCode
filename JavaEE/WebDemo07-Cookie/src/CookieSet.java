import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CookieSet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        Cookie[] cookies = req.getCookies();
        if (cookies != null){
            System.out.println("当前用户：");
            for (Cookie cookie : cookies) {
                System.out.println(cookie.getName());
                System.out.println(cookie.getValue());
            }
        }else {
            Cookie cookie = new Cookie("username","root");
            cookie.setMaxAge(60);
            resp.addCookie(cookie);
        }
        resp.sendRedirect(req.getContextPath()+"/index.jsp");
    }
}
