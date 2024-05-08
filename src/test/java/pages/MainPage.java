package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MainPage {

    private SelenideElement fromCity = $("#avia_form_origin-input"),
            whereCity = $("#avia_form_destination-input"),
            boxOstrovok = $(".s__BGUqp9s2kxbNEnDjdIYc"),
            buttonFound = $("s__Yzjov8gtTIwlOo3oK8L3");

    public MainPage openPage() {
        open("");

        return this;
    }
    public MainPage clickBoxOstrovok() {
        boxOstrovok.click();

        return this;
    }



}
