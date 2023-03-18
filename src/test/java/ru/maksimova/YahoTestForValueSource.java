package ru.maksimova;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.Selenide.*;

@DisplayName("Проверка работы сайта YAHOO.com")
public class YahoTestForValueSource {
    @BeforeEach
    void openSite() {
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = false;
        open("https://www.yahoo.com/");

    }

    @ValueSource (strings = {
            "JAVA", "Atlassian"
    })
    @ParameterizedTest(name = "Проверка числа результатов поиска по тексту на сайте YAHOO.com {0}")
    @Tag("BLOCKER")

    void  searhResultForYahoo( String TestData) {
        $("#ybar-search-box-container").click();
        $("input[type='text']").setValue(TestData).pressEnter();
        $$("div.dd.algo").shouldHave(CollectionCondition.sizeGreaterThanOrEqual(5));


    }
}