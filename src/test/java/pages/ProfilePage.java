package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class ProfilePage {
    private SelenideElement textAboutPrice = $(".s__zwNEG6Giz0QZgdTiiWBX"),
     textAboutPofile = $(".profile_layout");



    public ProfilePage checkTextAboutPrice() {
        textAboutPrice.shouldBe(text("Доступ к поддержке и подпискам на цены"));

        return this;
    }

    public ProfilePage checkTextAboutProfile() {
        textAboutPofile.shouldBe(text("Профиль"));

        return this;
    }
}