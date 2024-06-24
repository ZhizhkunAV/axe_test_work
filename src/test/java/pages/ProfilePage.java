package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class ProfilePage {
    private SelenideElement elementProfile = $(".s__GbiR6nyWpRvfj6X4o71s"),
            textAboutPrice = $(".s__zwNEG6Giz0QZgdTiiWBX");


    @Step("Check if the text 'Subscribe to Aviasailes newsletter' is available")
    public ProfilePage checkTextElement(String value) {
        elementProfile.shouldBe(text(value));

        return this;
    }

    @Step("Check the text")
    public ProfilePage checkUnsuccessTextElement(String value) {
        elementProfile.shouldNot(text(value));

        return this;
    }

    @Step("Checking for text 'Доступ к поддержке и подпискам на цены' part of the screen 'Ваш профиль'")
    public ProfilePage checkTextAboutPrice() {
        textAboutPrice.shouldBe(text("Доступ к поддержке и подпискам на цены"));

        return this;
    }
}