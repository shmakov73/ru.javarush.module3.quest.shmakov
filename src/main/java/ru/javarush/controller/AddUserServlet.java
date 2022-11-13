package ru.javarush.controller;


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

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        HttpSession session = request.getSession();


        Object userName = request.getParameter("name");
        if (userName == null){
            userName = session.getAttribute("name");
            int gameCount = (int) session.getAttribute("gameCount");
            session.setAttribute("gameCount", gameCount + 1);

        }else {

        session.setAttribute("userName", userName);
            session.setAttribute("gameCount", 0);
        }

        String remoteAddr = request.getRemoteAddr();

        session.setAttribute("IPAddress", remoteAddr);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/QuestServlet");
        dispatcher.forward(request, response);

    }
}
