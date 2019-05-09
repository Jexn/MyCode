import com.sun.deploy.net.HttpResponse;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DefineFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        Boolean isLogin = (Boolean) request.getSession().getAttribute("isLogin");
        if (isLogin != null && isLogin) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            System.out.println("用户信息有误");
            response.sendRedirect(request.getContextPath() + "/register.jsp");
        }
    }

    @Override
    public void destroy() {

    }
}
