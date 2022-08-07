package github;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class SelenideCheckJUnit5Test {

    @BeforeAll
    static void configure() {
        Configuration.baseUrl = "https://github.com";
    }

    @Test
    void shouldHaveJUnit5Assertions() {
        //Open Selenide
        open("/selenide/selenide");
        //Open Wiki
        $("#wiki-tab").click();
        //Found SoftAssertions
        $("#wiki-pages-filter").setValue("SoftAssertions");
        $(".Layout-sidebar").shouldHave(text("SoftAssertions"));
        //Open SoftAssertions
        $("[data-filterable-for='wiki-pages-filter']").click();
        //Found JUnit5
        $(".markdown-body").shouldHave(text("Using JUnit5 extend test class"));
    }
}
