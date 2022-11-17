package ru.javarush.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LogicTest {

    private Logic logic;

    @BeforeEach
    public void setUp(){
        this.logic = new Logic();
    }
    @Test
    void getNewQuestionTest_Should_NotNull_Return() {
        assertThat(logic.getNewQuestion("start")).isNotNull();
        assertThat(logic.getNewQuestion("Принять вызов?")).isNotNull();
        assertThat(logic.getNewQuestion("Подняться на мостик")).isNotNull();

        assertThat(logic.getNewQuestion("start").getYesAnswer()).isEqualTo("Принять вызов?");
        assertThat(logic.getNewQuestion("Принять вызов?").getYesAnswer()).isEqualTo("Подняться на мостик");
        assertThat(logic.getNewQuestion("Подняться на мостик").getYesAnswer()).isEqualTo("Рассказать о себе правду");
    }

    @Test
    void isNoAnswerTest_Should_NotNull_Return() {
        assertThat(logic.isNoAnswer("Отклонить вызов")).isNotNull();
        assertThat(logic.isNoAnswer("Отказаться подниматься на мостик.")).isNotNull();
        assertThat(logic.isNoAnswer("Солгать о себе.")).isNotNull();

        assertThat(logic.isNoAnswer("Отклонить вызов")).isEqualTo("Ты отклонил вызов. Поражение.");
        assertThat(logic.isNoAnswer("Отказаться подниматься на мостик.")).isEqualTo("Ты не пошёл на переговоры. Поражение.");
        assertThat(logic.isNoAnswer("Солгать о себе.")).isEqualTo("Твою ложь разоблачили. Поражение.");
    }

    @Test
    void isWinAnswerTest_Should_NotNull_Return() {
        assertThat("Рассказать о себе правду").isNotNull();

        assertThat(logic.isWinAnswer("Рассказать о себе правду")).isEqualTo("Тебя вернули домой. Победа!");
    }

    @Test
    void getNewQuestionTest_Should_Return_Null(){
        assertThat(logic.getNewQuestion("любой другой текст")).isNull();
    }

    @Test
    void isNoAnswerTest_Should_Return_Null(){
        assertThat(logic.isNoAnswer("любой другой текст")).isNull();
    }

    @Test
    void isWinAnswerTest_Should_Return_Null(){
        assertThat(logic.isWinAnswer("любой другой текст")).isNull();
    }
}