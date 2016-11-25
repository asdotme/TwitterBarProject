package edu.mum.cs472.util;

import edu.mum.cs472.model.Tweets;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Asme on 11/24/2016.
 */
public class FormatParameter {
    public static List<Tweets> getTweets(HttpServletRequest request, HttpServlet servlet) {
        String lat = request.getParameter("lat");
        String lon = request.getParameter("lon");
        String count=servlet.getServletContext().getInitParameter("maxNumOfTrends");
        String radius = servlet.getServletContext().getInitParameter("radius");
        String radiusUnit = servlet.getServletContext().getInitParameter("radiusUnit");
        if (lat == null && lon == null) {
            return new ArrayList<>();
        }

        double latNum = Double.parseDouble(lat);
        double lonNum = Double.parseDouble(lon);
        double radiusNum = Double.parseDouble(radius);
        int countNum=Integer.parseInt(count);

//        request.setAttribute("trends", TwitterCall.getTrendsByGeoLocation(latNum, lonNum, radiusNum, radiusUnit));
        return TwitterCall.getTrendsByGeoLocation(latNum, lonNum, radiusNum, radiusUnit,countNum);

    }

}
