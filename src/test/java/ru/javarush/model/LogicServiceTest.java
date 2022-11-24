package ru.javarush.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LogicServiceTest {

    private LogicService logicService;

    @BeforeEach
    public void setUp(){
        this.logicService = new LogicService(new Quest());
    }

    @Test
    void getNewQuestionTest_Should_NotNull_Return() {
        assertThat(logicService.getNewQuestion("start")).isNotNull();
        assertThat(logicService.getNewQuestion("Принять вызов?")).isNotNull();
        assertThat(logicService.getNewQuestion("Подняться на мостик")).isNotNull();

        assertThat(logicService.getNewQuestion(null).getYesAnswer()).isEqualTo("Принять вызов?");
        assertThat(logicService.getNewQuestion("start").getYesAnswer()).isEqualTo("Принять вызов?");
        assertThat(logicService.getNewQuestion("Принять вызов?").getYesAnswer()).isEqualTo("Подняться на мостик");
        assertThat(logicService.getNewQuestion("Подняться на мостик").getYesAnswer()).isEqualTo("Рассказать о себе правду");
    }

    @Test
    void isNoAnswerTest_Should_NotNull_Return() {
        assertThat(logicService.isNoAnswer("Отклонить вызов")).isNotNull();
        assertThat(logicService.isNoAnswer("Отказаться подниматься на мостик.")).isNotNull();
        assertThat(logicService.isNoAnswer("Солгать о себе.")).isNotNull();

        assertThat(logicService.isNoAnswer("Отклонить вызов")).isEqualTo("Ты отклонил вызов. Поражение.");
        assertThat(logicService.isNoAnswer("Отказаться подниматься на мостик.")).isEqualTo("Ты не пошёл на переговоры. Поражение.");
        assertThat(logicService.isNoAnswer("Солгать о себе.")).isEqualTo("Твою ложь разоблачили. Поражение.");
    }

    @Test
    void isWinAnswerTest_Should_NotNull_Return() {
        assertThat(logicService.isWinAnswer("Рассказать о себе правду")).isNotNull();

        assertThat(logicService.isWinAnswer("Рассказать о себе правду")).isEqualTo("Тебя вернули домой. Победа!");
    }

    @Test
    void getNewQuestionTest_Should_Return_Null(){
        assertThat(logicService.getNewQuestion("любой другой текст")).isNull();
    }

    @Test
    void isNoAnswerTest_Should_Return_Null(){
        assertThat(logicService.isNoAnswer("любой другой текст")).isNull();
    }

    @Test
    void isWinAnswerTest_Should_Return_Null(){
        assertThat(logicService.isWinAnswer("любой другой текст")).isNull();
    }

}