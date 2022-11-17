package ru.javarush.controller;

import ru.javarush.model.Logic;
import ru.javarush.model.Question;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "QuestServlet", value = "/QuestServlet")
public class QuestServlet extends HttpServlet {

    Logic logic;

    @Override
    public void init(){
        logic = new Logic();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String answer = request.getParameter("answer");


        if (logic.isNoAnswer(answer) != null){
            RequestDispatcher dispatcher = request.getRequestDispatcher("/lostPage.jsp");
            request.setAttribute("defeatPhrase", logic.isNoAnswer(answer));
            dispatcher.forward(request, response);
        }
        else if (logic.isWinAnswer(answer) != null){
            RequestDispatcher dispatcher = request.getRequestDispatcher("/winPage.jsp");
            request.setAttribute("winPhrase", logic.isWinAnswer(answer));
            dispatcher.forward(request, response);
        }
        else {
            Question newQuestion = logic.getNewQuestion(answer);
            request.setAttribute("question", newQuestion.getQuestion());
            request.setAttribute("defeatMessage", newQuestion.getDefeatMessage());

            if (Math.random() > 0.5){
                request.setAttribute("answer1", newQuestion.getYesAnswer());
                request.setAttribute("answer2", newQuestion.getNoAnswer());
            }
            else {
                request.setAttribute("answer2", newQuestion.getYesAnswer());
                request.setAttribute("answer1", newQuestion.getNoAnswer());
            }

            RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
            dispatcher.forward(request, response);
        }
    }
}
