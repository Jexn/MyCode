import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: CheckName
 * @description: 检查用户名是否存在
 * @author: Cube
 * @create: 2019-05-07 10:33
 **/
@WebServlet(value = "/checkName")
public class CheckName extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<String> list = new ArrayList<>();
        list.add("root");
        list.add("username");
        list.add("admin");

        String username = req.getParameter("username");
        System.out.println(username);
        if (list.contains(username)) {
            resp.getWriter().write("true");
        } else {
            resp.getWriter().write("false");
        }
    }
}
