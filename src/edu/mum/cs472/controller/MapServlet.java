package edu.mum.cs472.controller;

import edu.mum.cs472.util.FormatParameter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Asme on 11/23/2016.
 */
@WebServlet(name = "MapServlet",urlPatterns = {"/map"})
public class MapServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String headerName = request.getHeader("x-requested-with");
        request.setAttribute("trends", FormatParameter.getTweets(request,this));
        if(headerName==null){
            request.setAttribute("currentPageContent", "_map.jsp");
            request.getRequestDispatcher("home.jsp").forward(request, response);
        }else{
            request.getRequestDispatcher("_ajaxtrends.jsp").forward(request, response);

        }

    }
}
