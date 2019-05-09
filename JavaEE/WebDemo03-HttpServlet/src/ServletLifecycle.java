import javax.servlet.*;
import java.io.IOException;

public class ServletLifecycle implements Servlet {
    public ServletLifecycle() {
        System.out.println("ServletLifecycle对象创建。。。");
    }

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("init()初始化");
        // System.out.println(servletConfig.getServletName());
        // System.out.println(servletConfig.getInitParameter("username"));
        // System.out.println(servletConfig.getInitParameter("password"));
        // System.out.println(servletConfig.getInitParameterNames());
        // System.out.println(servletConfig.getServletContext());

    //    获取上下文对象信息
        ServletContext context = servletConfig.getServletContext();
        System.out.println("context = " + context);
        System.out.println("项目名信息：context.getContextPath() = " + context.getContextPath());
        System.out.println("真实路径："+context.getRealPath("web.xml"));
    }

    @Override
    public ServletConfig getServletConfig() {
        System.out.println("getServletConfig调用");
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("service调用");
    }

    @Override
    public String getServletInfo() {
        System.out.println("getServletInfo调用");
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("destroy方法销毁。。。");
    }
}
