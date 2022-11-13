package ru.javarush.model;

public class Question {

    public Question(String question, String yesAnswer, String noAnswer, String defeatMessage) {
        this.question = question;
        this.yesAnswer = yesAnswer;
        this.noAnswer = noAnswer;
        this.defeatMessage = defeatMessage;
    }
    private final String question;

    private final String yesAnswer;

    private final String noAnswer;

    private final String defeatMessage;

    public String getQuestion() {
        return question;
    }

    public String getYesAnswer() {
        return yesAnswer;
    }

    public String getNoAnswer() {
        return noAnswer;
    }

    public String getDefeatMessage() {
        return defeatMessage;
    }
}
