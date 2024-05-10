package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MainPage {

    private SelenideElement fromCity = $("#avia_form_origin-input"),
            whereCity = $("#avia_form_destination-input"),
            boxOstrovok = $(".s__BGUqp9s2kxbNEnDjdIYc"),
            buttonFound = $("s__Yzjov8gtTIwlOo3oK8L3"),
            buttonProfile = $(".selene-form").$$("li").findBy(text("Профиль")),
            buttonNow = $(".selene-form").$$("li").findBy(text("Короче"));

    public MainPage openPage() {
        open("");

        return this;
    }
    public MainPage clickBoxOstrovok() {
        boxOstrovok.click();

        return this;
    }

    public MainPage clickButtonProfile() {
        buttonProfile.click();

        return this;
    }

    public MainPage clickButtonNow() {
        buttonNow.click();

        return this;
    }



}