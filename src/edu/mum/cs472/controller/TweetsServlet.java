package edu.mum.cs472.controller;

import edu.mum.cs472.model.Tweets;
import edu.mum.cs472.util.TwitterCall;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Created by Asme on 11/21/2016.
 */
@WebServlet(name = "TweetsServlet", urlPatterns = {"/tweets"})
public class TweetsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String queryType = this.getActiveQueryType(request);

        int maxNumOfTweets = Integer.parseInt(getServletContext().getInitParameter("maxNumOfTweets"));

        //Fetch data from twitter
        List<Tweets> result = TwitterCall.getJsonStringFromTwitter(maxNumOfTweets, queryType);
        request.setAttribute("tweets", result);

        request.setAttribute("currentPageContent", "_tweets.jsp");
        request.getRequestDispatcher("layout.jsp").forward(request, response);
    }

    public String getActiveQueryType(HttpServletRequest request) {
        String queryType = request.getParameter("q");
        if (queryType == null) {
            if (request.getSession().getAttribute("queryType") == null) {
                queryType = getServletContext().getInitParameter("defaultTweets");
            } else {
                queryType = request.getSession().getAttribute("queryType").toString();
            }
        }
        request.getSession().setAttribute("queryType", queryType);
        return queryType;
    }
}
