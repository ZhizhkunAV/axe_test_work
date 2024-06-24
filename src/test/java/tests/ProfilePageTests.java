package tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.MainPage;
import pages.ProfilePage;

@Epic("UI tests")
@Owner("Andrey Zhizhkun")
@Feature("Checking the functionality of the profile page")
public class ProfilePageTests extends TestBase {

    public MainPage mainpage = new MainPage();
    public ProfilePage settingspage = new ProfilePage();
    public ProfilePage profilepage = new ProfilePage();




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