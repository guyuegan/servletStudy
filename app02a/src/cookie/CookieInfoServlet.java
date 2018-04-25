package cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
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
 * 日    期: 2018年04月25日  13:14:54
 * Q    Q: 1784286916
 * </pre>
 */
@WebServlet(name = "CookieInfoServlet",
        urlPatterns = {"/cookieInfo"})
public class CookieInfoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookieArr = req.getCookies();
        StringBuilder style = new StringBuilder().append(".title{");
        for (Cookie c : cookieArr) {
            String name = c.getName();
            String value = c.getValue();
            if ("titleFontSize".equals(name)) {
                style.append("font-size:" + value + ";");
            } else if ("titleFontWeight".equals(name)) {
                style.append("font-weight:" + value + ";");
            } else if ("titleFontStyle".equals(name)) {
                style.append("font-style:" + value + ";");
            }
        }
        style.append("}");

        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();
        out.print("<html><head><style>");
        out.print(style.toString());
        out.print("</style></head><body>");
        out.print("<div class='title'> Session management with cookies: </div>");

        out.print("<div>");
        if (cookieArr == null){
            out.print("No cookie in this Http response");
        }else{
            out.print("Cookie in this Http response");
            for (Cookie c : cookieArr){
                out.print("<br/>"+c.getName()+" : "+c.getValue());
            }
        }
        out.print("</div></body></html>");
    }
}
