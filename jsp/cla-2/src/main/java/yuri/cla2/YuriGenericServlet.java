package yuri.cla2;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;

import java.io.IOException;

@WebServlet("/prime")
public class YuriGenericServlet extends GenericServlet {
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        int sum = 0;
        for(int i = 0; i <= 100; i++) {
            sum += prime(i) ? i : 0;
        }
        System.out.println("sum -> " + sum);
    }

    boolean prime(int n) {
        for(int i = 2; i <= n / 2; i++) {
            if(n % i == 0) {
                return false;
            }
        }
        return n >= 2;
    }
}
