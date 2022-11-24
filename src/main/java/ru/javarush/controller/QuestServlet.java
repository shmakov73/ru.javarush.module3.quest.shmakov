package ru.javarush.controller;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "QuestServlet", value = "/QuestServlet")
public class QuestServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) {

    }
}
