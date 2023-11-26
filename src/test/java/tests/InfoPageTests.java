package tests;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import page_obgects.HomePage;
import page_obgects.InfoPage;
import utils.listeners.ListenersTest;

@Listeners({ListenersTest.class})
public class InfoPageTests {
    HomePage homePage = new HomePage();
    @Test(description = "TC-007")
    @Description("Verify that the title info page\"Умови продажу на TABURETKA.UA \"is title \" Умови продажу на TABURETKA.UA\"")
    public void titleInfoPage() {
        String getTitlePage = "Умови продажу на TABURETKA.UA";
        homePage.openHomePage();
        homePage.clickButtonTermsOfSale();
        InfoPage infoPage = new InfoPage();
        String actualTitlePage = infoPage.titleInfoPage();
        Assert.assertEquals(actualTitlePage, getTitlePage);
    }
    @Test(description = "TC-009")
    @Description("Check availability of information \"Меблеві салони та пункти видачі\"")
    public void furnitureSalonsAndDeliveryPoints() {
        String expectedInfo = "Меблеві салони та пункти видачі";
        homePage.openHomePage();
        homePage.buttonDelivery();
        InfoPage infoPage = new InfoPage();
        String actualInfo = infoPage.availabilityInformation();
        Assert.assertEquals(actualInfo, expectedInfo);

    }
    @Test(description = "TC-010")
    @Description("Check that the call-center's work schedule is available on the contact page")
    public void workSchedule() {
        String expectScheduleWork ="Графік роботи call-центру:\n" +
                "з 09:00 до 20:00\n" +
                "Без вихідних\n" +
                "(24 по 27 листопада\n" +
                "з 09:00 до 22:00)";
        homePage.openHomePage();
        homePage.contactsButton();
        InfoPage infoPage = new InfoPage();
        String availableScheduleWork = infoPage.scheduleWorkCallCenter();
        Assert.assertEquals(availableScheduleWork, expectScheduleWork);

    }
    @Test(description = "TC-020")
    @Description("Verify that the button 'Статті' open the page 'Статті'")
    public void pageArticles (){
        homePage.openHomePage();
        homePage.buttonArticles();
        InfoPage infoPage = new InfoPage();
        String actualTitleInfoPage =infoPage.infoPageArticles();
        Assert.assertEquals(actualTitleInfoPage,"Статті");
    }
}

