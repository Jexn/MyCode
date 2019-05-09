import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class RegisterServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        String clientToken = req.getParameter("clientToken");
        HttpSession session = req.getSession();
        String servletToken = (String) session.getAttribute("servletToken");
        session.removeAttribute("servletToken");
        String checkCode = (String) session.getAttribute("checkCode");

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String userCode = req.getParameter("checkCode");

        System.out.println("clientToken = " + clientToken);
        System.out.println("servletToken = " + servletToken);

        if (clientToken!= null && servletToken != null && clientToken.equals(servletToken)){
            if (!checkCode.equals(userCode)){
                System.out.println("checkCode = " + checkCode);
                System.out.println("userCode = " + userCode);
                System.out.println("验证码错误");
                resp.getWriter().write("验证码错误");
            }else {
                System.out.println("用户：" + username + "，密码：" + password);
                System.out.println("checkCode = " + checkCode);
                System.out.println("userCode = " + userCode);
                session.setAttribute("isLogin",true);
                resp.sendRedirect(req.getContextPath()+"/succeed.jsp");
            }
        }else {
            resp.getWriter().write("提交失败!");
        }
    }
}
