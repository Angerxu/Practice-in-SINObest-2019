package servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author XuAn
 * @date 2019/8/7
 */
public class MyServlet2 extends HttpServlet {
    /**
     * 构造方法
     */
    public MyServlet2() {
        System.out.println("Creating MyServlet2.");
    }

    /**
     * init()方法，初始化。
     * @throws ServletException Servlet异常
     */
    @Override
    public void init() throws ServletException {
        System.out.println("Initializing MyServlet2.");
    }
    /**
     * doGET(),响应GET请求。
     * @param request request
     * @param response response
     * @throws ServletException Servlet异常
     * @throws IOException IO异常
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("Using Get() method.");
        PrintWriter out = response.getWriter();
        response.setContentType("text/html;charset=utf-8");
        out.println("<br/><i><b>Hello, Servlet2!</i></b>");
    }

    /**
     * doPost(),响应POST请求。
     * @param request request
     * @param response response
     * @throws ServletException Servlet异常
     * @throws IOException IO异常
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("Using Post() method.");
        PrintWriter out = response.getWriter();
        response.setContentType("text/html;charset=utf-8");
        out.println("<br/><i><b>Hello, Servlet2!</i></b>");
    }

    @Override
    public void destroy() {
        System.out.println("Destroying MyServlet2.");
    }

}
