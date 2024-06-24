package tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import pages.MainPage;
import pages.NowPage;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;

@Epic("UI tests")
@Owner("Andrey Zhizhkun")
@Feature("Checking the functionality of the nowpage")
@DisplayName("Testing NowPage functionality")
public class NowPageTests extends TestBase {
    public MainPage mainpage = new MainPage();
    public NowPage nowpage = new NowPage();

    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Button name - 'Список мест (10)'")
    @Tag("all")
    @Test
    void havePlaceTextTest() {
        mainpage.openPage()
                .clickButtonNow();
        nowpage.clickNowVisa()
                .choiseFindCity()
                .choiseLocalDish()
                .checkButtonOfLocalDish("Список мест (10)");
    }

    @Severity(SeverityLevel.MINOR)
    @Tag("all")
    @DisplayName("In the 'Travels in Russia' selection, there is a city called 'Kaliningrad'.")
    @Test
    void haveTextAboutRussianCityTest() {
        mainpage.openPage()
                .clickButtonNow();
        nowpage.clickButtonRusTraveling("Калининград");
    }


    @Severity(SeverityLevel.CRITICAL)
    @Tag("all")
    @ValueSource(strings = {
            "Можно без визы",
            "Путешествия по России",
            "Дети заценят",
            "Море и пляжи"
    })
    @ParameterizedTest(name = "Checking for text - {0} on NowPage")
    @DisplayName("Checking the names of buttons on the page NowPage")
    void toolBarTest(String searchQuery) {

        step("Open the start page of the website", () -> {
            mainpage.openPage();
        });
        step("Click button Now", () -> {
            mainpage.clickButtonNow();
        });
        step("Check that the checkbox is enabled", () -> {
            $(".s__E9Tbhhl8hEybC5rmIJrs").$$("li").findBy(text(searchQuery)).shouldBe(enabled);
        });
    }
}