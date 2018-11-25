package com.lesson.boot.mvc.servlet.natives.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author zhengshijun
 * @version created on 2018/11/25.
 */
@WebServlet(
        urlPatterns = "/async",
        asyncSupported=true
)
public class AsyncServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PrintWriter printWriter = resp.getWriter();
        printWriter.write(this.getClass().getSimpleName());
        printWriter.flush();
    }
}
