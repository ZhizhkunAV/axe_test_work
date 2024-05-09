package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Owner;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.MainPage;
import pages.NowPage;
import pages.ProfilePage;
import pages.SettingsPage;


import static com.codeborne.selenide.Selenide.*;

@DisplayName("Тест-сьют на aviasales")
public class CaseTests extends TestBase {
    public MainPage mainpage = new MainPage();
    public SettingsPage settingspage = new SettingsPage();
    public NowPage nowpage = new NowPage();
    public ProfilePage profilepage = new ProfilePage();

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://www.aviasales.ru/";
        Configuration.browserSize = "1366x768";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;
        Configuration.timeout = 10000;
    }

    @DisplayName("Наличие текста у чекбокса 'Подписаться на рассылку Авиасейлс'")
    @Tag("critical")
    @Owner("Andrey")
    @Test
    void haveSalesTicketsTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        mainpage.openPage()
                .clickButtonProfile();
        settingspage.checkTextElement("Подписаться на рассылку Авиасейлс");
    }

    @DisplayName("Название кнопки - 'Список мест (10)'")
    @Tag("critical")
    @Owner("Andrey")
    @Test
    void havePlaceTextTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        mainpage.openPage()
                .clickButtonNow();
        nowpage.clickNowVisa()
                .choiseFindCity()
                .choiseLocalDish()
                .checkButtonOfLocalDish("Список мест (10)");
    }

    @DisplayName("В выборе 'Путешествия по России' есть город 'Калинигрд'")
    @Tag("minor")
    @Owner("Andrey")
    @Test
    void haveTextAboutRussianCityTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        open("");

        mainpage.openPage()
                .clickButtonNow();
        nowpage.clickButtonRusTravaling()
                .clickButtonRusTravaling("Калининград");
    }

    @DisplayName("Наличие текста 'Доступ к поддержке и подпискам на цены' в плашке 'Ваш профиль'")
    @Tag("minor")
    @Owner("Andrey")
    @Test
    void haveTextInProfileTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        mainpage.openPage()
                .clickButtonProfile();
        profilepage.checkTextAboutPrice();

    }

    @DisplayName("Снять и проставить отметку выбора - 'Открыть Ostrovok.ru в новой вкладке' на главной странице")
    @Tag("minor")
    @Owner("Andrey")
    @Test
    void choiceOstrovokTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        mainpage.openPage()
                .clickBoxOstrovok()
                .clickBoxOstrovok()
                .clickBoxOstrovok();
    }
}