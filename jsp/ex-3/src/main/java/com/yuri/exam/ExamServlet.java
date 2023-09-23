package com.yuri.exam;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

@WebServlet("/examServlet")
public class ExamServlet extends HttpServlet {
    private HashMap<String, HashSet<String>> ans;
    private int question_size; // 题目总数
    private int question_score; // 题目总分数

    @Override
    public void init() throws ServletException {
        super.init();
        // 设置题目总分和总数
        question_score = 100;
        question_size = 4;
        ans = new HashMap<>();
        // 添加问题以及答案 答案使用逗号分割
        addAns("question_1", "option_3");
        addAns("question_2", "option_1,option_3");
        addAns("question_3", "HttpServlet");
        addAns("question_4", "option_3");
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 如果是重置就直接返回原界面
        if(request.getParameter("submit") == null) {
            String file_path = getServletContext().getRealPath("exam.html"), html;
            BufferedReader reader = new BufferedReader(new FileReader(file_path));
            response.setContentType("text/html");
            PrintWriter writer = response.getWriter();
            while ((html = reader.readLine()) != null) {
                writer.write(html);
            }
            reader.close();
        } else {
            int score = 0;
            // 获取分数并显示
            score += getScore("question_1", request.getParameterValues("question_1"));
            score += getScore("question_2", request.getParameterValues("question_2"));
            score += getScore("question_3", request.getParameterValues("question_3"));
            score += getScore("question_4", request.getParameterValues("question_4"));
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<html><body>");
            out.println("<h1>你的分数是 : " + score + "分</h1>");
            out.println("</body></html>");
        }
    }

    // 获取分数，需要数据和答案完全匹配
    int getScore(String question, String[] ans) {
        int res = 0;
        HashSet<String> set = this.ans.get(question);
        for(String s : ans) {
            if(!set.contains(s)) {
                return 0;
            }
        }
        return this.question_score / this.question_size;
    }

    // 添加答案
    void addAns(String question, String ans) {
        this.ans.put(question, new HashSet<>());
        HashSet<String> set = this.ans.get(question);
        set.addAll(Arrays.asList(ans.split(",")));
    }
}
