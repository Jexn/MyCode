import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @program: getSession
 * @description: 获取Session
 * @author: Cube
 * @create: 2019-05-05 11:03
 **/
public class getSession extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        // 得到Session对象内容
        HttpSession session = req.getSession();
        String name = (String) session.getAttribute("name");
        PrintWriter out = resp.getWriter();
        out.write("你的姓名："+name);
    }
}
