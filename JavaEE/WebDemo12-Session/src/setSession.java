import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @program: setSession
 * @description: 设置Session
 * @author: Cube
 * @create: 2019-05-05 11:01
 **/
public class setSession extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        String name = req.getParameter("name");
        // 创建一个Session对象
        HttpSession session = req.getSession();
        session.setAttribute("name",name);
        PrintWriter out = resp.getWriter();
        out.write(name+"，首次登录");
    }
}
