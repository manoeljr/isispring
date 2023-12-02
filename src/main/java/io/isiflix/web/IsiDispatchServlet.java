package io.isiflix.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class IsiDispatchServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        if (request.getRequestURL().toString().endsWith("/favicon.ico")) {
            return;
        }
        System.out.println("URL = " + request.getRequestURL().toString());
        System.out.println("URL = " + request.getMethod());

        PrintWriter out = new PrintWriter(response.getWriter());
        out.println("Hello World from IsiSpring");
        out.close();
    }
}
