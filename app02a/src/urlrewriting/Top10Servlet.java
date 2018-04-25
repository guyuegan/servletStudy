package urlrewriting;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

/**
 * <pre>
 * 功    能: $comment$
 * 涉及版本:
 * 创 建 者: Neo
 * 日    期: 2018年04月23日  10:42:40
 * Q    Q: 1784286916
 * </pre>
 */
@WebServlet(name = "Top10Servlet",
        urlPatterns = {"/top10"},
        initParams = {
                @WebInitParam(name = "london", value = "浪漫摩天轮,大本钟,白金汉宫,大英博物馆,温莎古堡,海德公园,伦敦塔桥,伦敦塔,圣保罗大教堂,莎士比亚环球剧院"),
                @WebInitParam(name = "paris", value = "亚历山大三世桥,巴黎迪士尼乐园,蒙帕纳斯大厦,蓬皮杜国家文化艺术中心,蒙马特高地,圣心大教堂,奥赛博物馆,协和广场,塞纳河,香榭丽舍大街")
        }
)
public class Top10Servlet extends HttpServlet {

    private List<String> londonAttractionLs;
    private List<String> parisAttractionLs;

    @Override
    public void init(ServletConfig config) throws ServletException {
        String[] londonAttractionArr = config.getInitParameter("london").split(",");
        String[] parisAttractionArr = config.getInitParameter("paris").split(",");
        londonAttractionLs = Arrays.asList(londonAttractionArr);
        parisAttractionLs = Arrays.asList(parisAttractionArr);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String city = req.getParameter("city");
        if (city != null && ("london".equals(city) || "paris".equals(city))) {
            showAttractions(req, resp, city);
        } else {
            showMainPage(req, resp);
        }
    }

    private void showMainPage(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.print("<html><body>");
        out.print("please select a city:");
        out.print("</br><a href='?city=london'>london</a>");
        out.print("</br><a href='?city=paris'>paris</a>");
        out.print("</body></html>");
    }

    private void showAttractions(HttpServletRequest req, HttpServletResponse resp, String city)
            throws ServletException, IOException {
        int page = 1;
        if (req.getParameter("page") != null) {
            page = Integer.parseInt(req.getParameter("page"));
        }
        if (page > 2 || page < 0) {
            page = 1;
        }
        List<String> attractionLs = null;
        if ("london".equals(city)) {
            attractionLs = londonAttractionLs;
        } else if ("paris".equals(city)) {
            attractionLs = parisAttractionLs;
        }
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();
        out.print("<html><body>");
        out.print("<a href='top10'>Select City</a></br>");
        out.print("Page" + page + "</br>");
        int startIndex = 5 * (page - 1);
        for (int i = startIndex; i < startIndex+5; i++) {
            out.print(attractionLs.get(i) + "</br>");
        }
        out.print("<a href='?city=" + city + "&page=1'>Page 1</a> &nbsp;&nbsp; " +
                "<a href='?city=" + city + "&page=2'>Page 2</a>");
        out.print("</body></html>");
    }
}
