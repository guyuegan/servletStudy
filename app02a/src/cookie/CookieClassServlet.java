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
 * 日    期: 2018年04月25日  10:56:00
 * Q    Q: 1784286916
 * </pre>
 */
@WebServlet(name = "CookieClassServlet",
        urlPatterns = {"/cookieClass"}
)
public class CookieClassServlet extends HttpServlet {
    String[] methodArr = {
            "clone", "getComment", "getDomain",
            "getMaxAge", "getName", "getPath",
            "getSecure", "getValue", "getVersion",
            "isHttpOnly", "setComment", "setDomain",
            "setHttpOnly", "setMaxAge", "setPath",
            "setSecure", "setValue", "setVersion"
    };

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookArr = req.getCookies();
        Cookie maxRecordsCookie = null;
        if (cookArr != null){
            for (Cookie c : cookArr){
                if ("maxRecords".equals(c.getName())) {
                    maxRecordsCookie = c;
                    break;
                }
            }
        }

        Integer maxRecords = 5;
        if (maxRecordsCookie != null){
            maxRecords = Integer.parseInt(maxRecordsCookie.getValue());
        }

        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();
        out.print("<html><body>");
        out.print("Here are some of methods in javax.servlet.http.Cookie:");
        out.print("<ul>");
        for (int i = 0; i < maxRecords; i++) {
            out.print("<li>"+methodArr[i]+"</li>");
        }
        out.print("</ul>");
        out.print("</body></html>");
    }
}
