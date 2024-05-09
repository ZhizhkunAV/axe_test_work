package tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Owner;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.MainPage;
import pages.NowPage;
import pages.ProfilePage;
import pages.SettingsPage;

import static io.qameta.allure.Allure.step;

@DisplayName("Тест-сьют на aviasales")
public class CaseTests extends TestBase {
    public MainPage mainpage = new MainPage();
    public SettingsPage settingspage = new SettingsPage();
    public NowPage nowpage = new NowPage();
    public ProfilePage profilepage = new ProfilePage();


    @DisplayName("Наличие текста у чекбокса 'Подписаться на рассылку Авиасейлс'")
    @Tag("critical")
    @Owner("Andrey")
    @Test
    void haveSalesTicketsTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открыть стартовую страницу сайта", () -> {
            mainpage.openPage();
        });
        step("Переход на страницу 'Профиль'", () -> {
            mainpage.clickButtonProfile();
        });
        step("Проверка наличия текста 'Подписаться на рассылку Авиасейлс'", () -> {
            settingspage.checkTextElement("Подписаться на рассылку Авиасейлс");
        });
    }

    @DisplayName("Название кнопки - 'Список мест (10)'")
    @Tag("critical")
    @Owner("Andrey")
    @Test
    void havePlaceTextTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открыть стартовую страницу сайта", () -> {
            mainpage.openPage();
        });
        step("Переход на страницу 'Короче'", () -> {
            mainpage.clickButtonNow();
        });
        step("Открытие страницы 'Можно без визы'", () -> {
            nowpage.clickNowVisa();
        });
        step("Выбор города", () -> {
            nowpage.choiseFindCity();
        });
        step("Выбор плашки 'Местные блюда'", () -> {
            nowpage.choiseLocalDish();
        });
        step("Проверка названия кнопки - 'Список мест (10)'", () -> {
            nowpage.checkButtonOfLocalDish("Список мест (10)");
        });
    }

    @DisplayName("В выборе 'Путешествия по России' есть город 'Калинигрд'")
    @Tag("minor")
    @Owner("Andrey")
    @Test
    void haveTextAboutRussianCityTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открыть стартовую страницу сайта", () -> {
            mainpage.openPage();
        });
        step("Переход на страницу 'Короче'", () -> {
            mainpage.clickButtonNow();
        });
        step("Переход на страницу 'Путешествия по России'", () -> {
            nowpage.clickButtonRusTravaling();
        });
        step("Проверка наличия города в списке - 'Калиниград'", () -> {
            nowpage.clickButtonRusTravaling("Калининград");
        });
    }

    @DisplayName("Наличие текста 'Доступ к поддержке и подпискам на цены' в плашке 'Ваш профиль'")
    @Tag("minor")
    @Owner("Andrey")
    @Test
    void haveTextInProfileTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открыть стартовую страницу сайта", () -> {
            mainpage.openPage();
        });
        step("Переход на страницу 'Профиль'", () -> {
            mainpage.clickButtonProfile();
        });
        step("Проверка наличия текста 'Доступ к поддержке и подпискам на цены' в плашке 'Ваш профиль'", () -> {
            profilepage.checkTextAboutPrice();
        });
    }

    @DisplayName("Снять и проставить отметку выбора - 'Открыть Ostrovok.ru в новой вкладке' на главной странице")
    @Tag("minor")
    @Owner("Andrey")
    @Test
    void choiceOstrovokTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открыть стартовую страницу сайта", () -> {
            mainpage.openPage();
        });
        step("Снять выбора в чекбоксе - 'Открыть Ostrovok.ru в новой вкладке'", () -> {
            mainpage.clickBoxOstrovok();
        });
        step("Проставить выбор в чекбоксе - 'Открыть Ostrovok.ru в новой вкладке'", () -> {
            mainpage.clickBoxOstrovok();
        });
        step("Снять выбора в чекбоксе - 'Открыть Ostrovok.ru в новой вкладке'", () -> {
            mainpage.clickBoxOstrovok();
        });
    }
}