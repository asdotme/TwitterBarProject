package edu.mum.cs472.controller;

import edu.mum.cs472.model.Tweets;
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
@WebServlet(name = "TrendsServlet")
public class TrendsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String headerName = request.getHeader("x-requested-with");


        request.setAttribute("trends", this.getTweets(request));

        if(headerName==null){
            System.out.println("non ajx request");
            request.setAttribute("currentPageContent", "_trends.jsp");
            request.getRequestDispatcher("layout.jsp").forward(request, response);
        }else{
            System.out.println("ajax request");
            request.getRequestDispatcher("_ajaxtrends.jsp").forward(request, response);

        }

    }

    private List<Tweets> getTweets(HttpServletRequest request) {
        String lat = request.getParameter("lat");
        String lon = request.getParameter("lon");
        String radius = getServletConfig().getInitParameter("radius");
        String radiusUnit = getServletConfig().getInitParameter("radiusUnit");
        if (lat == null && lon == null) {
            return new ArrayList<>();
        }

        double latNum = Double.parseDouble(lat);
        double lonNum = Double.parseDouble(lon);
        double radiusNum = Double.parseDouble(radius);

//        request.setAttribute("trends", TwitterCall.getTrendsByGeoLocation(latNum, lonNum, radiusNum, radiusUnit));
        return TwitterCall.getTrendsByGeoLocation(latNum, lonNum, radiusNum, radiusUnit);

    }
}


