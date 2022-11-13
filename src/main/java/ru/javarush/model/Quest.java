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

    public void addQuestionsToList(){
        questions.put("start", question);
        questions.put(question.getYesAnswer(), question1);
        questions.put(question1.getYesAnswer(), question2);
}

    public HashMap<String, Question> getQuestions() {
        return questions;
    }

    public Question getNewQuestion(String answer){
        if (answer == null){
            answer = "start";
        }
        return questions.get(answer);
    }

    public String isNoAnswer(String answer){
        String isFinal = null;
        if (answer != null) {
            for (Question value : questions.values()) {
                if (answer.equals(value.getNoAnswer())) {
                    isFinal = value.getDefeatMessage();
                }
            }
        }
        return isFinal;
    }

    public String isWinAnswer(String answer){
        String isWin = null;
        if (answer != null) {
            if (answer.equals(lastQuestion)) {
                isWin = winPhrase;
            }
        }
        return isWin;
    }

}
