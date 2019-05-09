package Services;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @program: clearShoppingCart
 * @description: 清空购物车
 * @author: Cube
 * @create: 2019-05-05 16:47
 **/
public class clearShoppingCart extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        HttpSession session = req.getSession();
        session.removeAttribute("shoppingCart");
        PrintWriter out = resp.getWriter();
        resp.setHeader("refresh","3;url='/ShoppingCart/index.jsp'");
        out.println("购物已清空,3秒后自动跳转到商品展示页");

    }
}
