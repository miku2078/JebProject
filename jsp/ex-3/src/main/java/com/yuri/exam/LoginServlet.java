package com.yuri.exam;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Arrays;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String stu_number = request.getParameter("stu_number");
        String stu_name = request.getParameter("stu_name");
        System.out.println(stu_name + " " + stu_number);
        String file_name = "success.html";
        if(!stu_number.equals("092214100")) {
            file_name = "failure.html";
        }
        String file_path = getServletContext().getRealPath(file_name), html = null;
        BufferedReader reader = new BufferedReader(new FileReader(file_path));
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        while((html = reader.readLine()) != null) {
            writer.write(html);
        }
        reader.close();
    }
}
