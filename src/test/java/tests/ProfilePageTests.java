package tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.MainPage;
import pages.ProfilePage;


public class ProfilePageTests extends TestBase {

    public MainPage mainpage = new MainPage();
    public ProfilePage settingspage = new ProfilePage();
    public ProfilePage profilepage = new ProfilePage();


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
    @DisplayName("Presence of text at the 'Subscribe to Aviasales newsletter' checkbox")
    @Tag("all")
    @Test
    void haveSalesTicketsTest() {
        mainpage.openPage()
                .clickButtonProfile();
        settingspage.checkTextElement("Подписаться на рассылку Авиасейлс");
    }


    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Checking for incorrect text - 'Открыть Ostrovok.ru в новой вкладке'")
    @Tag("all")
    @Test
    void notHaveOstrovokButtonTest() {
        mainpage.openPage()
                .clickButtonProfile();
        profilepage.checkUnsuccessTextElement("Открыть Ostrovok.ru в новой вкладке");
    }
}