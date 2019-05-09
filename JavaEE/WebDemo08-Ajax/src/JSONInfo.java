import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JSONInfo extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("username");
        String password = req.getParameter("password");

        if ("root".equals(name) && "root".equals(password)){
            System.out.println("已到达服务器");
            String jsonStr = "{\"name\":\"root\",\"info\":\"admin\"}";
            resp.getWriter().write(jsonStr);
        }else {
            resp.getWriter().write("用户信息错误");
        }
    }
}
