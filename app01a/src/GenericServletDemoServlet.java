import javax.servlet.*;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * <pre>
 * 功    能: $comment$
 * 涉及版本:
 * 创 建 者: Neo
 * 日    期: 2018年04月22日  10:29:47
 * Q    Q: 1784286916
 * </pre>
 */
@WebServlet(name = "GenericServletDemoServlet",
        urlPatterns = {"/generic"},
        initParams = {
                @WebInitParam(name = "username", value = "neo"),
                @WebInitParam(name = "password", value = "123456")
        }
)
/***
* GenericServletDemoServlet已经实现了，int(), getServletConfig(), getServletInfo(), destroy()
 */
public class GenericServletDemoServlet extends GenericServlet{
        @Override
        public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
                ServletConfig servletConfig = getServletConfig();
                String username = servletConfig.getInitParameter("username");
                String password = servletConfig.getInitParameter("password");

                servletResponse.setContentType("html/text");
                PrintWriter out = servletResponse.getWriter();
                out.print("<html><body>");
                out.print("username:"+username);
                out.print("</br>password:"+password);
                out.print("</body></html>");
        }
}
