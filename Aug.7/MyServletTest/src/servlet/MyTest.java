package servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author XuAn
 * @date 2019/8/7
 */
public class MyTest extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*request中的重定向方法，再使用request的getContextPath()方法得到项目根目录路径。返回test.jsp所在路径*/
        /*response.sendRedirect(request.getContextPath() + "/test.jsp");*/

        /*服务器内部跳转，第一个斜杠表示根目录。*/
        request.getRequestDispatcher("/test.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
