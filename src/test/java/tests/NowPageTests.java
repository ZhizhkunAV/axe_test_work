package tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.MainPage;
import pages.NowPage;

@Epic("UI tests")
@Owner("Andrey Zhizhkun")
@Feature("Checking the functionality of the nowpage")
public class NowPageTests extends TestBase {
    public MainPage mainpage = new MainPage();
    public NowPage nowpage = new NowPage();
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Button name - 'Список мест (10)'")
    @Tag("all")
    @Test
    void havePlaceTextTest() {
        mainpage.openPage()
                .clickButtonNow();
        nowpage.clickNowVisa()
                .choiseFindCity()
                .choiseLocalDish()
                .checkButtonOfLocalDish("Список мест (10)");
    }
    @Severity(SeverityLevel.MINOR)
    @Tag("all")
    @DisplayName("In the 'Travels in Russia' selection, there is a city called 'Kalinigrd'.")
    @Test
    void haveTextAboutRussianCityTest() {
        mainpage.openPage()
                .clickButtonNow();
        nowpage.clickButtonRusTravaling("Калининград");
    }
}