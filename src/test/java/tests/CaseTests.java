package tests;

import com.codeborne.selenide.Configuration;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;


import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class CaseTests {
    @BeforeAll
    static void beforeAll(){
        Configuration.baseUrl ="https://www.aviasales.ru/";
        Configuration.browserSize = "1366x768";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;
    }

    @DisplayName("Название кнопки - Список мест (10)")
    @Tag("Critical")
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

    @Test
    void haveTextAboutDishTest() {

        open("");

        $(".footer").$("#airlines").$(".accordion__labelfind").click();

    }
}
