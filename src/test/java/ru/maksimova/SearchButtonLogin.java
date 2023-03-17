package ru.maksimova;



import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Selectors.byText;
import static java.lang.Thread.sleep;


public class SearchButtonLogin {
    @DisplayName("Проверка работы сайта smetter.ru")
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;
    }
    @BeforeEach
    void beforeEach () {
    Selenide.open("https://smetter.ru/");
}


   @Test
   @Tag("Critical")
    void searchButtonLog() {
        Selenide.$("a[href='https://app.smetter.ru']").shouldHave(Condition.text("Войти"));
    }

    @Test
    void


}


