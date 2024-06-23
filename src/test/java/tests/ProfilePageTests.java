package tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import pages.MainPage;
import pages.ProfilePage;
@Epic("UI tests")
@Owner("Andrey Zhizhkun")
@Feature("Checking the functionality of the profile page")
@Tag("ui")
public class ProfilePageTests extends TestBase {

    public MainPage mainpage = new MainPage();
    public ProfilePage settingspage = new ProfilePage();
    public ProfilePage profilepage = new ProfilePage();
    @Severity(SeverityLevel.CRITICAL)
    @Tags({
            @Tag("critical"),
            @Tag("ALL")
    })
    @DisplayName("Presence of text at the 'Subscribe to Aviasails newsletter' checkbox")
    @Test
    void haveSalesTicketsTest() {
        mainpage.openPage()
                .clickButtonProfile();
        settingspage.checkTextElement("Подписаться на рассылку Авиасейлс");
    }

    @Severity(SeverityLevel.MINOR)
    @DisplayName("Availability of text 'Доступ к поддержке и подпискам на цены' on the 'Your Profile' page")
    @Tags({
            @Tag("minor"),
            @Tag("ALL")
    })
    @Test
    void haveTextInProfileTest() {
        mainpage.openPage()
                .clickButtonProfile();
        profilepage.checkTextAboutPrice();
    }


    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Checking for incorrect text - 'Открыть Ostrovok.ru в новой вкладке'")
    @Tags({
            @Tag("critical"),
            @Tag("ALL")
    })
    @Test
    void haveSalesTicketsqTest() {
        mainpage.openPage()
                .clickButtonProfile();
        profilepage.checkUnsuccesTextElement("Открыть Ostrovok.ru в новой вкладке");
    }
}