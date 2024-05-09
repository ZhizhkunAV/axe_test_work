package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class NowPage {

    private SelenideElement nowVisa = $(".s__E9Tbhhl8hEybC5rmIJrs").$$("li").findBy(text("Можно без визы")),
                            findCity = $(".s__VLPIHQnQeyzCMiHfqsUf").$$("li").findBy(text("Стамбул")),
                            localDish = $(byText("Местные блюда")),
                            pageOfLocalDish = $("#travel-map-layer-selector-2240"),
                            rusTravaling = $(".s__E9Tbhhl8hEybC5rmIJrs").$$("li").findBy(text("Путешествия по России")),
                            listOfCity = $(".s__xox66OPZpu0km1VJV6rZ").$(".s__VLPIHQnQeyzCMiHfqsUf");


    public NowPage clickNowVisa() {
        nowVisa.click();

        return this;
    }

    public NowPage choiseFindCity() {
        findCity.click();

        return this;
    }

    public NowPage choiseLocalDish() {
        localDish.click();

        return this;
    }

    public NowPage checkButtonOfLocalDish(String value) {
        pageOfLocalDish.shouldBe(text(value));;

        return this;
    }

    public NowPage clickButtonRusTravaling() {
        rusTravaling.click();

        return this;
    }

    public NowPage clickButtonRusTravaling(String value) {
        listOfCity.shouldBe(text(value));

        return this;
    }

}


