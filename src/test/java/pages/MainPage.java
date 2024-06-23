package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
public class MainPage {

    private SelenideElement boxOstrovok = $(".s__BGUqp9s2kxbNEnDjdIYc"),
            buttonProfile = $(".selene-form").$$("li").findBy(text("Профиль")),
            buttonNow = $(".selene-form").$$("li").findBy(text("Короче"));

    @Step("Open the start page of the website")
    public MainPage openPage() {
        open("");

        return this;
    }

    @Step("Go to page 'Профиль'")
    public MainPage clickButtonProfile() {
        buttonProfile.click();

        return this;
    }

    @Step("Go to page 'Короче'")
    public MainPage clickButtonNow() {
        buttonNow.click();

        return this;
    }
    @Step("Click the checkbox - 'Открыть Ostrovok.ru в новой вкладке'")
    public MainPage clickBoxOstrovok() {
        boxOstrovok.click();

        return this;
    }

    @Step("Check that the checkbox is enabled")
    public MainPage enabledBoxOstrovok() {
        boxOstrovok.shouldBe(enabled);

        return this;
    }
}