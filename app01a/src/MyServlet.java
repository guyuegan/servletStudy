import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * <pre>
 * 功    能: 第一章
 * 涉及版本:
 * 创 建 者: Neo
 * 日    期: 2018年04月07日  20:58:04
 * Q    Q: 1784286916
 * </pre>
 */
@WebServlet(name = "MyServlet",
            urlPatterns = {"/my"})
public class MyServlet implements Servlet{

    /***
     * transient 临时的;
     * 让transient修饰的属性在序列化时，不被序列化
     */
    private transient ServletConfig servletConfig;

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        /***
         * init 方法的执行时刻其实与 servlet 的配置有关，
         * 如果load-on-startup结点的值大于等于 0，则在 Servlet 实例化的时候执行，
         * 间隔时间由具体的值决定，值越大，则越迟执行。
         * 如果小于 0 或者没有配置，则在第一次请求的时候才同步执行 ，
         *
         * ******注意 init 方法只执行一次******
         */
        this.servletConfig = servletConfig;
    }

    @Override
    public ServletConfig getServletConfig() {
        return servletConfig;
    }

    @Override
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {

        String servletName = servletConfig.getServletName();

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.print("<html><body>" +
                    "hello from:" + servletName +
                "</body></html>");
    }

    @Override
    public String getServletInfo() {
        return "my servlet";
    }

    @Override
    public void destroy() {
        //关闭资源
    }
}
