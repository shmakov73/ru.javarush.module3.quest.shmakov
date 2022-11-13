package ru.javarush.controller;

import ru.javarush.model.Quest;
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

    Quest quest;

    @Override
    public void init(){
        quest = new Quest();
        quest.addQuestionsToList();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String answer = request.getParameter("answer");


        if (quest.isNoAnswer(answer) != null){
            RequestDispatcher dispatcher = request.getRequestDispatcher("/lostPage.jsp");
            request.setAttribute("defeatPhrase", quest.isNoAnswer(answer));
            dispatcher.forward(request, response);
        }
        else if (quest.isWinAnswer(answer) != null){
            RequestDispatcher dispatcher = request.getRequestDispatcher("/winPage.jsp");
            request.setAttribute("winPhrase", quest.isWinAnswer(answer));
            dispatcher.forward(request, response);
        }
        else {
            Question newQuestion = quest.getNewQuestion(answer);
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
