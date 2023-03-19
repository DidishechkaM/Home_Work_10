package ru.maksimova;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.codeborne.selenide.Selenide.$;

public class StreamForSiteGame {

    static Stream<Arguments> StreamForSiteGames() {
        return Stream.of(Arguments.of("Max Payne"), Arguments.of("Arx Fatalis")

        );
    }

    @MethodSource
    @Tag("BLOKER")
    @ParameterizedTest(name = "Поиск по запросу {0} отображет текст {0} на странице")
    public void StreamForSiteGames(String testData) {
        Selenide.open("https://www.old-games.ru/");
        $("#quicksearchgame").setValue(testData).pressEnter();
        $(".main-content").shouldHave(Condition.text(testData));
    }
}