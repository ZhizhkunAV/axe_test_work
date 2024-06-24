package tests;


import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import pages.MainPage;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;


@Epic("UI tests")
@Owner("Andrey Zhizhkun")
@Feature("Checking the functionality of the main page")
@DisplayName("A test suite for testing the site aviasales")
public class MainPageTests extends TestBase {
    public MainPage mainpage = new MainPage();

    @Severity(SeverityLevel.MINOR)
    @DisplayName("Clickability of checkbox - 'Open Ostrovok.ru in a new tab' on the main page")
    @Tag("ALL")
    @Test
    void choiceOstrovokTest() {
        mainpage.openPage()
                .clickBoxOstrovok()
                .clickBoxOstrovok()
                .enabledBoxOstrovok();
    }

    @Severity(SeverityLevel.CRITICAL)
    @Tag("ALL")
    @ValueSource(strings = {
            "Авиабилеты",
            "Отели",
            "Короче",
            "Профиль"
    })
    @ParameterizedTest(name = "Checking for text - {0} on the site aviasales")
    @DisplayName("ParameterizedTest to use a single value - ValueSource")
    void toolBarTest(String searchQuery) {

        step("Open the start page of the website", () -> {
            mainpage.openPage();
        });
        step("Check that the checkbox is enabled", () -> {
            $(".selene-form").$$("li").findBy(text(searchQuery)).shouldBe(enabled);
        });
    }
}