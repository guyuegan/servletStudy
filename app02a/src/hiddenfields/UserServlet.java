package hiddenfields;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 * 功    能: $comment$
 * 涉及版本:
 * 创 建 者: Neo
 * 日    期: 2018年04月24日  09:53:08
 * Q    Q: 1784286916
 * </pre>
 */

/***
 * not thread safe, for illustration purpose only
 */
@WebServlet(name = "UserServlet",
        urlPatterns = {"/showUser", "/editUser", "/updateUser"}
)
public class UserServlet extends HttpServlet {
    List<User> userList = new ArrayList<>();

    /***
     * Servlet只初始化一次，init()中更改后，需要重启
     */
    @Override
    public void init(ServletConfig config) throws ServletException {
        User user = new User();
        user.setId(1);
        user.setName("海绵宝宝");
        user.setAge(3);
        user.setAddress("澳大利亚海滩");
        userList.add(user);
        User user02 = new User();
        user02.setId(2);
        user02.setName("天线宝宝");
        user02.setAge(6);
        user02.setAddress("内蒙古大草原");
        userList.add(user02);
    }

    private void showUserList(HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();
        out.print("<html><body>");
        // 为什么<a href='editUser
        // 能从 http://localhost:8080/app02a/showUser
        // 跳到 http://localhost:8080/app02a/editUser?id=
        // 但<a href='/editUser 【加上/，上下文不见了】
        // 跳到 http://localhost:8080/editUser?id=
        for (User u : userList) {
            out.print(u.getName() + "[" + u.getAddress() + "]" + "&nbsp;&nbsp;<a href='editUser?id=" + u.getId() + "'>修改</a></br>");
        }
        out.print("</body></html>");
    }

    private void sendEditUserForm(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Integer id = Integer.parseInt(req.getParameter("id"));
        for (User u : userList) {
            if (u.getId() == id) {
                resp.setContentType("text/html;charset=utf-8");
                PrintWriter out = resp.getWriter();
                out.print("");
                out.print("<html><head><meta charset='UTF-8'></head><body>");
                out.print("<form action = 'updateUser' method = 'post' >");
                out.print("<input type = 'hidden' name = 'id' value = '" + id + "'/>");
                out.print("用户名：<input type = 'text' name = 'name' value = '" + u.getName() + "' readonly />");
                out.print("年龄：<input type = 'text' name = 'age' value = '" + u.getAge() + "'/>");
                out.print("地址：<input type = 'text' name = 'address' value = '" + u.getAddress() + "'/>");
                out.print("<input type = 'submit' value = '确定'/>");
                out.print("</form >");
                out.print("<html><body>");
                break;
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        String url = req.getRequestURL().toString();
        if (uri.endsWith("showUser")) {
            showUserList(resp);
        }
        if (uri.endsWith("editUser")) {
            sendEditUserForm(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("utf-8");
        Integer id = Integer.parseInt(req.getParameter("id"));
        Integer age = Integer.parseInt(req.getParameter("age"));
        String address = req.getParameter("address");
        for(User u : userList){
            //foreach循环可以修改元素，但不可以修改列表
            //https://www.jianshu.com/p/724f763fd242
            if (id == u.getId()){
               u.setAge(age);
               u.setAddress(address);
               break;
            }
        }
        resp.sendRedirect("showUser");
    }

}
