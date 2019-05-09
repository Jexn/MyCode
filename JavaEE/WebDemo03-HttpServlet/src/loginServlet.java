import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class loginServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("username");
        String password = req.getParameter("password");
        System.out.println(name);
        System.out.println(password);

        if ("root".equals(name) && "root".equals(password)){
            resp.sendRedirect("succeed.html");
        }else {
            resp.sendRedirect("login.html");
        }
    }
}
