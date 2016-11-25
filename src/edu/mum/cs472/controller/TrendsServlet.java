package edu.mum.cs472.controller;

import edu.mum.cs472.model.Tweets;
import edu.mum.cs472.util.FormatParameter;
import edu.mum.cs472.util.TwitterCall;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

/**
 * Created by Asme on 11/23/2016.
 */
@WebServlet(name = "TrendsServlet",urlPatterns = {"/trends"})
public class TrendsServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String headerName = request.getHeader("x-requested-with");
        request.setAttribute("trends", FormatParameter.getTweets(request,this));
        if(headerName==null){
            request.setAttribute("currentPageContent", "_trends.jsp");
            request.getRequestDispatcher("home.jsp").forward(request, response);
        }else{
            request.getRequestDispatcher("_ajaxtrends.jsp").forward(request, response);

        }

    }

}


