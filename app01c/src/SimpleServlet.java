import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * <pre>
 * 功    能: $comment$
 * 涉及版本:
 * 创 建 者: Neo
 * 日    期: 2018年04月23日  09:38:47
 * Q    Q: 1784286916
 * </pre>
 */
public class SimpleServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(req.getMethod());
        PrintWriter out = resp.getWriter();
        out.print("<html><body>");
        out.print("simple servlet");
        out.print("</body></html>");
    }
}
