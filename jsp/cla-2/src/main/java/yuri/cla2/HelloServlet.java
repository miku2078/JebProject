package yuri.cla2;

import jakarta.servlet.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet" , initParams = {
        @WebInitParam(name = "sname", value = "廖华勇"),
        @WebInitParam(name = "sno", value = "092221208")
})
public class HelloServlet implements Servlet {
    private ServletConfig config;
    @Override
    public void init(ServletConfig servletConfig) {
        config = servletConfig;
    }
    @Override
    public ServletConfig getServletConfig() {
        return config;
    }
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) {
        String sname = config.getInitParameter("sname");
        String sno = config.getInitParameter("sno");

        System.out.printf("sname -> %s\nsno -> %s\n", sname, sno);
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}