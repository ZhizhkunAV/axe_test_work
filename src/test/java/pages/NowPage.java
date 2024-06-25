package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class NowPage {
    private SelenideElement nowVisa = $(".s__E9Tbhhl8hEybC5rmIJrs").$$("li").findBy(text("Можно без визы")),
            findCity = $(".s__VLPIHQnQeyzCMiHfqsUf").$$("li").findBy(text("Стамбул")),
            localDish = $(byText("Местные блюда")),
            pageOfLocalDish = $("#travel-map-layer-selector-2240"),
            listOfCity = $(".s__xox66OPZpu0km1VJV6rZ").$(".s__VLPIHQnQeyzCMiHfqsUf");

    @Step("Opening a page 'Можно без визы'")
    public NowPage clickNowVisa() {
        nowVisa.click();

        return this;
    }

    @Step("City selection")
    public NowPage choiseFindCity() {
        findCity.click();

        return this;
    }
    @Step("Selecting part of the screen 'Местные блюда'")
    public NowPage choiseLocalDish() {
        localDish.click();

        return this;
    }

    @Step("Checking the button name - 'Список мест (10)'")
    public NowPage checkButtonOfLocalDish(String value) {
        pageOfLocalDish.shouldBe(text(value));

        return this;
    }

    @Step("Checking if the city is on the list - 'Kaliningrad'")
    public NowPage clickButtonRusTraveling(String value) {
        listOfCity.shouldBe(text(value));

        return this;
    }

}