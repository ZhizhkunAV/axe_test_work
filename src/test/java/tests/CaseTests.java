package tests;

import com.codeborne.selenide.Configuration;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;


import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

@DisplayName("Тест-сьют на aviasales")
public class CaseTests {
    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://www.aviasales.ru/";
        Configuration.browserSize = "1366x768";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;
        Configuration.timeout = 10000;
    }

    @DisplayName("Поиск самых дешевых билетов")
    @Tag("critical")
    @Owner("Andrey")
    @Test
    void haveSalesTicketsTest() {

        open("");

        $("#avia_form_origin-input").setValue("Москва").clear();
        $("#avia_form_origin-input").setValue("Москва");
        $("#avia_form_destination-input").setValue("Станбул");
        $(".s__BGUqp9s2kxbNEnDjdIYc").click();
        $(".s__Yzjov8gtTIwlOo3oK8L3").click();
        $(".s__YB6igidOsfwsMrxg2Yke").shouldBe(text("Самые дешёвые билеты"));
    }

    @DisplayName("Название кнопки - 'Список мест (10)'")
    @Tag("critical")
    @Owner("Andrey")
    @Test
    void havePlaceTextTest() {

        open("");

        $(".selene-form").$$("li").findBy(text("Короче")).click();
        $(".s__E9Tbhhl8hEybC5rmIJrs").$$("li").findBy(text("Можно без визы")).click();
        $(".s__VLPIHQnQeyzCMiHfqsUf").$$("li").findBy(text("Стамбул")).click();
        $(byText("Местные блюда")).click();
        $("#travel-map-layer-selector-2240").shouldBe(text("Список мест (10)"));
    }

    @DisplayName("В выборе 'Путешествия по России' есть город 'Калинигрд'")
    @Tag("minor")
    @Owner("Andrey")
    @Test
    void haveTextAboutRussianCityTest() {

        open("");

        $(".selene-form").$$("li").findBy(text("Короче")).click();
        $(".s__E9Tbhhl8hEybC5rmIJrs").$$("li").findBy(text("Путешествия по России")).click();
        $(".s__xox66OPZpu0km1VJV6rZ").$(".s__VLPIHQnQeyzCMiHfqsUf").shouldBe(text("Калининград"));
    }

    @DisplayName("Наличие текста 'Доступ к поддержке и подпискам на цены' в плашке 'Ваш профиль'")
    @Tag("minor")
    @Owner("Andrey")
    @Test
    void haveTextInProfileTest() {

        open("");

        $(".selene-form").$$("li").findBy(text("Профиль")).click();
        $(".s__zwNEG6Giz0QZgdTiiWBX").shouldBe(text("Доступ к поддержке и подпискам на цены"));

    }

    @DisplayName("Снять и проставить отметку выбора - 'Открыть Ostrovok.ru в новой вкладке' на главной странице")
    @Tag("minor")
    @Owner("Andrey")
    @Test
    void choiceOstrovokTest() {

        open("");

        $(".s__BGUqp9s2kxbNEnDjdIYc").click();
        $(".s__BGUqp9s2kxbNEnDjdIYc").click();
    }
}
