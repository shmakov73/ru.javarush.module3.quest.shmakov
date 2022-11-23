package ru.javarush.model;

import java.util.HashMap;

public class LogicService {


    private final Quest quest = new Quest();
    private final HashMap<String, Question> questions = quest.getQuestions();

    public Question getNewQuestion(String answer){
        if (answer == null){
            answer = quest.getStartWord();
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
            if (answer.equals(quest.getLastQuestion())) {
                isWin = quest.getWinPhrase();
            }
        }
        return isWin;
    }

}
