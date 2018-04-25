import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
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
 * 日    期: 2018年04月22日  10:43:03
 * Q    Q: 1784286916
 * </pre>
 */
@WebServlet(name = "FormServlet", value = {"/form"})
public class FormServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String reqMethod = req.getMethod();
        System.out.println(reqMethod);

        //注意WEB-INF大小写
        req.getRequestDispatcher("/WEB-INF/form.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String reqMethod = req.getMethod();
        System.out.println(reqMethod);

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.print("<html><body>");
        out.print("username:"+req.getParameter("username"));
        out.print("</br>password:"+req.getParameter("password"));
        String[] instructions = req.getParameterValues("instructions");
        for (String instruction : instructions){
            out.print("</br>instruction:"+instruction);
        }
        String[] hobbies = req.getParameterValues("bobbies");
        for (String hobby : hobbies){
            out.print("</br>bobby:"+hobby);
        }
        out.print("</body></html>");
    }
}
