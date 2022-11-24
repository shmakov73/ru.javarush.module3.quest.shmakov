package ru.javarush.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "AddUserServlet", value = "/AddUserServlet")
public class AddUserServlet extends HttpServlet {
    private static final Logger logger = LoggerFactory.getLogger(AddUserServlet.class);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/html;charset=UTF-8");

        HttpSession session = request.getSession();


        Object userName = request.getParameter("name");
        if (userName == null){
            int gameCount = (int) session.getAttribute("gameCount");
            session.setAttribute("gameCount", gameCount + 1);

        }else {

        session.setAttribute("userName", userName);
        logger.info("added new user: {}", userName);
            session.setAttribute("gameCount", 0);
            session.setAttribute("winCount", 0);
        }

        String remoteAddr = request.getRemoteAddr();

        session.setAttribute("IPAddress", remoteAddr);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/QuestServlet");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            logger.error(e.toString());
        }

    }
}
