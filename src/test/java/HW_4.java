package github;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class HW_4 {
    @BeforeAll
    static void beforeAll() {
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
//        Configuration.holdBrowserOpen = true;
    }

    @Test
    void test() {

        // Откройте страницу Selenide в Github
        open("https://github.com/selenide/selenide");
        // Перейдите в раздел Wiki проекта
        $("#wiki-tab").click();
        // Убедитесь, что в списке страниц (Pages) есть страница SoftAssertions
        $("#wiki-body").shouldHave(text("Soft assertions"));
        // Откройте страницу SoftAssertions
        $("#wiki-body").$(byText("Soft assertions")).click();
        // Проверьте что внутри есть пример кода для JUnit5
        $("#wiki-body").shouldHave(text("Using JUnit5 extend test class:"));
    }
}
