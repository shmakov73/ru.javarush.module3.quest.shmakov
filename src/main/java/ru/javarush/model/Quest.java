package ru.javarush.model;

import java.util.HashMap;

public class Quest {
    private final HashMap<String, Question> questions = new HashMap<>();

    private final Question question = new Question(
            "Ты потерял память. Принять вызов НЛО?",
            "Принять вызов?",
            "Отклонить вызов",
            "Ты отклонил вызов. Поражение.");
    private final Question question1 = new Question(
            "Ты принял вызов. Поднимаешься на мостик к капитану?",
            "Подняться на мостик",
            "Отказаться подниматься на мостик.",
            "Ты не пошёл на переговоры. Поражение.");
    private final Question question2 = new Question(
            "Ты поднялся на мостик. Ты кто?",
            "Рассказать о себе правду",
            "Солгать о себе.",
            "Твою ложь разоблачили. Поражение.");

    private final String lastQuestion = "Рассказать о себе правду";
    private final String winPhrase = "Тебя вернули домой. Победа!";

    private final String startWord = "start";



    private void addQuestionsToList() {
        questions.put(startWord, question);
        questions.put(question.getYesAnswer(), question1);
        questions.put(question1.getYesAnswer(), question2);
    }

    public HashMap<String, Question> getQuestions() {
        addQuestionsToList();
        return questions;
    }

    public String getLastQuestion() {
        return lastQuestion;
    }

    public String getStartWord() {
        return startWord;
    }

    public String getWinPhrase() {
        return winPhrase;
    }
}