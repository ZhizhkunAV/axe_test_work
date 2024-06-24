package tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.MainPage;
import pages.NowPage;
import pages.ProfilePage;

@Epic("UI tests")
@Owner("Andrey Zhizhkun")
@Feature("Checking the functionality of the nowpage")
public class NowPageTests extends TestBase {
    public MainPage mainpage = new MainPage();
    public NowPage nowpage = new NowPage();

    public ProfilePage settingspage = new ProfilePage();
    public ProfilePage profilepage = new ProfilePage();
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







    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Availability of text 'Доступ к поддержке и подпискам на цены' on the 'Your Profile' page")
    @Tag("all")
    @Test
    void haveTextInProfileTest() {
        mainpage.openPage()
                .clickButtonProfile();
        profilepage.checkTextAboutPrice();
    }


    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Presence of text at the 'Subscribe to Aviasails newsletter' checkbox")
    @Tag("all")
    @Test
    void haveSalesTicketseTest() {
        mainpage.openPage()
                .clickButtonProfile();
        settingspage.checkTextElement("Подписаться на рассылку Авиасейлс");
    }


    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Checking for incorrect text - 'Открыть Ostrovok.ru в новой вкладке'")
    @Tag("all")
    @Test
    void haveSalesTicketsqTest() {
        mainpage.openPage()
                .clickButtonProfile();
        profilepage.checkUnsuccesTextElement("Открыть Ostrovok.ru в новой вкладке");
    }
}