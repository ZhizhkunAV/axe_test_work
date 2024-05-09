package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class NowPage {

    private SelenideElement nowVisa = $(".s__E9Tbhhl8hEybC5rmIJrs").$$("li").findBy(text("Можно без визы")),
                            ;


    public NowPage clickNowVisa() {
        nowVisa.click();

        return this;
    }



    $(".s__VLPIHQnQeyzCMiHfqsUf").$$("li").findBy(text("Стамбул")).click();
}
