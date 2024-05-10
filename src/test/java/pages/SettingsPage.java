package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class SettingsPage {

    private SelenideElement elementProfile = $(".s__GbiR6nyWpRvfj6X4o71s");


    public SettingsPage checkTextElement(String value) {
        elementProfile.shouldBe(text(value));

        return this;
    }


}
