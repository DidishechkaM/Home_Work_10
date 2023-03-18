package ru.maksimova;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static com.codeborne.selenide.Selenide.$;

public class ParamTestАorSmetter {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;
    }
    @BeforeEach
    void beforeEach() {
        Selenide.open("https://smetter.ru");
    }

    @AfterEach
    void afterEach() {
        Selenide.$("#profileDropdown").click();
        $("a[href='/logout']").click();
    }
    @ParameterizedTest(name = "В  результате для email TEST_DATA [0]  и паролем TEST_DATA [1] должен отображатьс текст TEST_DATA [2]")

    @Tag("CRITICAL")
    @CsvSource(value = {
            "dasha@yandex.ru|         parol|      Добро пожаловать ",
            "klava112@yandex.ru|      123456|    Добро пожаловать"
    }, delimiter = '|')
    void SuccessfulAuthorization(String testData, String testDataPassword, String expectedText) {
        $("a[href='https://app.smetter.ru']").click();
        $("[data-id='authorization-email']").setValue(testData);
        $("#login-password").setValue(testDataPassword);
        $("[data-id='register-button']").click();
        $(".card-body").shouldHave(Condition.text(expectedText));

    }

}

