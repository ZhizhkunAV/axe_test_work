package tests;

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

public class ParamTest extends TestBase {
    public MainPage mainpage = new MainPage();

    @ValueSource(strings = {
            "Авиабилеты",
            "Отели",
            "Короче",
            "Профиль"
    })
    @ParameterizedTest(name = "Checking for text - {0} on the site aviasales")
    @Tags({
            @Tag("WEB"),
            @Tag("BLOCKER")
    })
    @DisplayName("ParameterizedTest to use a single value - ValueSource")
    @Test
    void thisTestWhithParam(String searchQuery) {

        step("Open the start page of the website", () -> {
            mainpage.openPage();
        });
        step("Check that the checkbox is enabled", () -> {
            $(".selene-form").$$("li").findBy(text(searchQuery)).shouldBe(enabled);
        });
    }
}
