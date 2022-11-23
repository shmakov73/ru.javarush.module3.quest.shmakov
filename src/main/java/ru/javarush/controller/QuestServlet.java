package ru.javarush.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.javarush.model.LogicService;
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

    private static final Logger logger = LoggerFactory.getLogger(QuestServlet.class);
    LogicService logicService;

    @Override
    public void init(){
        logicService = new LogicService();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getSession().setAttribute("answer", request.getParameter("answer"));
        String answer = (String) request.getSession().getAttribute("answer");

        if (answer != null && !answer.equals("start")){
            logger.info("User {} answers a question \"{}\"", request.getSession().getAttribute("userName"), answer);
        }

        if (logicService.isNoAnswer(answer) != null){
            RequestDispatcher dispatcher = request.getRequestDispatcher("/lostPage.jsp");
            request.setAttribute("defeatPhrase", logicService.isNoAnswer(answer));
            dispatcher.forward(request, response);
            logger.info("User {} lost", request.getSession().getAttribute("userName"));

        }
        else if (logicService.isWinAnswer(answer) != null){
            RequestDispatcher dispatcher = request.getRequestDispatcher("/winPage.jsp");
            request.getSession().setAttribute("winCount", (int)(request.getSession().getAttribute("winCount")) + 1);
            request.setAttribute("winPhrase", logicService.isWinAnswer(answer));
            dispatcher.forward(request, response);
            logger.info("User {} won", request.getSession().getAttribute("userName"));
        }
        else {
            Question newQuestion = logicService.getNewQuestion(answer);
            request.getSession().setAttribute("question", newQuestion.getQuestion());
            request.setAttribute("defeatMessage", newQuestion.getDefeatMessage());

            if (Math.random() > 0.5){
                request.getSession().setAttribute("answer1", newQuestion.getYesAnswer());
                request.getSession().setAttribute("answer2", newQuestion.getNoAnswer());
            }
            else {
                request.getSession().setAttribute("answer2", newQuestion.getYesAnswer());
                request.getSession().setAttribute("answer1", newQuestion.getNoAnswer());
            }

            RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
            dispatcher.forward(request, response);
        }
    }
}
