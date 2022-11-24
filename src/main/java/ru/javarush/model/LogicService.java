package ru.javarush.model;

public class LogicService {

    private final Quest quest;
    public LogicService(Quest quest){
        this.quest = quest;
    }

    public Question getNewQuestion(String answer){
        if (answer == null){
            answer = quest.getStartWord();
        }
        return quest.getQuestions().get(answer);
    }

    public String isNoAnswer(String answer){
        String isFinal = null;
        if (answer != null) {
            for (Question value : quest.getQuestions().values()) {
                if (answer.equals(value.getNoAnswer())) {
                    isFinal = value.getDefeatMessage();
                }
            }
        }
        return isFinal;
    }

    public String isWinAnswer(String answer){
        String isWin = null;
        if (answer != null && answer.equals(quest.getLastQuestion())) {
                isWin = quest.getWinPhrase();
        }
        return isWin;
    }

}
