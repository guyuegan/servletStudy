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
 * 日    期: 2018年04月25日  09:42:18
 * Q    Q: 1784286916
 * </pre>
 */
@WebServlet(name = "PreferenceServlet",
        urlPatterns = {"/preference"})
public class PreferenceServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/preference.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String titleFontSize = req.getParameter("titleFontSize");
        String[] titleStyleAndWeights = req.getParameterValues("titleStyleAndWeight");
        String maxRecords = req.getParameter("maxRecords");
        resp.addCookie(new Cookie("titleFontSize", titleFontSize));
        resp.addCookie(new Cookie("maxRecords", maxRecords));

        //delete cookies: titleFontWeight,titleFontStyle
        //by adding cookie with the maxAge=0
        Cookie titleFontWeight = new Cookie("titleFontWeight", "");
        titleFontWeight.setMaxAge(0);
        resp.addCookie(titleFontWeight);

        Cookie titleFontStyle = new Cookie("titleFontStyle", "");
        titleFontStyle.setMaxAge(0);
        resp.addCookie(titleFontStyle);

        if (titleStyleAndWeights != null){
            for (String style : titleStyleAndWeights){
                if ("italic".equals(style)){
                    resp.addCookie(new Cookie("titleFontStyle", "italic"));
                } else if ("bold".equals(style)){
                    resp.addCookie(new Cookie("titleFontWeight", "bold"));
                }
            }
        }

        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();
        out.print("<html><body>");
        out.print("<p>your preference has been set</p>");
        out.print("<br/>表中最大记录："+maxRecords);
        out.print("<br/>标题大小："+titleFontSize);
        out.print("<br/>标题样式和粗细：");
        //titleStyleAndWeights will be null
        //if none of options was selected
        if (titleStyleAndWeights != null){
            out.print("<ul>");
            for (String style : titleStyleAndWeights){
                out.print("<li>"+style+"</li>");
            }
            out.print("</ul>");
        }
        out.print("</body></html>");
    }


}
