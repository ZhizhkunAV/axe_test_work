package tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Owner;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import pages.MainPage;
import pages.NowPage;
import pages.ProfilePage;
import pages.SettingsPage;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

@DisplayName("A test suite for testing the site aviasales")
@Owner("ZhizhkunAV")
public class CaseTests extends TestBase {
    public MainPage mainpage = new MainPage();
    public SettingsPage settingspage = new SettingsPage();
    public NowPage nowpage = new NowPage();
    public ProfilePage profilepage = new ProfilePage();


    @DisplayName("Presence of text at the 'Subscribe to Aviasails newsletter' checkbox")
    @Tags({
            @Tag("critical"),
            @Tag("ALL")
    })

    @Test
    void haveSalesTicketsTest() {

        step("Open the start page of the website", () -> {
            mainpage.openPage();
        });
        step("Go to the 'Profile' page", () -> {
            mainpage.clickButtonProfile();
        });
        step("Check if the text 'Subscribe to Aviasails newsletter' is available", () -> {
            settingspage.checkTextElement("Подписаться на рассылку Авиасейлс");
        });
    }

    @DisplayName("Button name - 'Список мест (10)'")
    @Tags({
            @Tag("critical"),
            @Tag("ALL")
    })
    @Test
    void havePlaceTextTest() {

        step("Open the start page of the website", () -> {
            mainpage.openPage();
        });
        step("Go to page 'Короче'", () -> {
            mainpage.clickButtonNow();
        });
        step("Opening a page 'Можно без визы'", () -> {
            nowpage.clickNowVisa();
        });
        step("City selection", () -> {
            nowpage.choiseFindCity();
        });
        step("Selecting part of the screen 'Местные блюда'", () -> {
            nowpage.choiseLocalDish();
        });
        step("Checking the button name - 'Список мест (10)'", () -> {
            nowpage.checkButtonOfLocalDish("Список мест (10)");
        });
    }

    @DisplayName("In the 'Travels in Russia' selection, there is a city called 'Kalinigrd'.")
    @Tags({
            @Tag("minor"),
            @Tag("ALL")
    })
    @Test
    void haveTextAboutRussianCityTest() {

        step("Open the start page of the website", () -> {
            mainpage.openPage();
        });
        step("Go to page 'Короче'", () -> {
            mainpage.clickButtonNow();
        });
        step("Go to page 'Путешествия по России'", () -> {
            nowpage.clickButtonRusTravaling();
        });
        step("Checking if the city is on the list - 'Kalinigrd'", () -> {
            nowpage.clickButtonRusTravaling("Калининград");
        });
    }

    @DisplayName("Наличие текста 'Доступ к поддержке и подпискам на цены' в плашке 'Ваш профиль'")
    @Tags({
            @Tag("minor"),
            @Tag("ALL")
    })
    @Test
    void haveTextInProfileTest() {

        step("Open the start page of the website", () -> {
            mainpage.openPage();
        });
        step("Go to page 'Профиль'", () -> {
            mainpage.clickButtonProfile();
        });
        step("Checking for text 'Доступ к поддержке и подпискам на цены' part of the screen 'Ваш профиль'", () -> {
            profilepage.checkTextAboutPrice();
        });
    }

    @DisplayName("Clickability of checkbox - 'Open Ostrovok.ru in a new tab' on the main page")
    @Tags({
            @Tag("minor"),
            @Tag("ALL")
    })
    @Test
    void choiceOstrovokTest() {

        step("Open the start page of the website", () -> {
            mainpage.openPage();
        });
        step("Deselect the checkbox - 'Открыть Ostrovok.ru в новой вкладке'", () -> {
            mainpage.clickBoxOstrovok();
        });
        step("Place a selection in the checkbox - 'Открыть Ostrovok.ru в новой вкладке'", () -> {
            mainpage.clickBoxOstrovok();
        });
        step("Check that the checkbox is enabled", () -> {
            mainpage.enabledBoxOstrovok();
        });
    }


    @ValueSource(strings = {
            "Авиабилеты",
            "Отели",
            "Короче",
            "Подписка",
            "Профиль"
    })
    @ParameterizedTest(name = "Проверка наличия текста - {0} на сайте  GitHub")
    @Tags({
            @Tag("WEB"),
            @Tag("BLOCKER")
    })
    @DisplayName("ParameterizedTest для использования одного значения - ValueSource")
    @Test
    void parametricText(String searchQuery) {
        SelenideLogger.addListener("allure", new AllureSelenide());

        open("/");
        $(".selene-form").$$("li").findBy(text(searchQuery)).shouldBe(enabled);
    }
}