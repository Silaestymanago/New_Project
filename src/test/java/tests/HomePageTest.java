package tests;


import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import page_obgects.HomePage;
import page_obgects.ProductPage;
import utils.listeners.ListenersTest;


@Listeners({ListenersTest.class})

public class HomePageTest {
    private HomePage homePage = new HomePage();


    @Test(description = "TC-002")
    @Description("Check that the data entry correctly  in the fields in the registration form")
    public void registrationOnTheWebsite() {
        homePage.openHomePage();
        homePage.clickOnTheButtonEntranceToTheOffice();
        homePage.clickOnTheButtonCreateAccount();

        String firstName = "Elina";
        homePage.enterFirstNameInTheFirstNameField(firstName);
        Assert.assertEquals(firstName, "Elina");

        String lastName = "Popova";
        homePage.enterLastnameInTheLastNameField(lastName);
        Assert.assertEquals(lastName, "Popova");

        String phoneNumber = "661253017";
        homePage.enterPhoneNumberInThePhoneField(phoneNumber);
        Assert.assertEquals(phoneNumber, "661253017");

        String email = "lesa87547@gmail.com";
        homePage.enterEmailInEmailField(email);
        Assert.assertEquals(email, "lesa87547@gmail.com");

        String password = "29pohadekperedsnom";
        homePage.enterPasswordInPasswordField(password);
        Assert.assertEquals(password, "29pohadekperedsnom");


    }
    @Test(description = "TC-003 ")
    @Description("Login to the office using the wrong email")
    public void loginUsedTheWrongEmail() {
        homePage.openHomePage();
        homePage.clickOnTheButtonEntranceToTheOffice();
        String email = "lavanda@gmail.com";
        homePage.enterEmail(email);
        String actualErrorMessage = homePage.getErrorMessage();
        Assert.assertEquals(actualErrorMessage, "Акаунт не знайдено");


    }
    @Test(description = "TC-004")
    @Description("Verify that the site logotype   TABURETKA.UA is TABURETKA.UA")
    public void logotype() {
        homePage.openHomePage();
        String getLogotype = homePage.logotype();
        Assert.assertEquals(getLogotype, "TABURETKA.UA");


    }

    @Test(description = "TC-005")
    @Description("Verify that the page is translate into Russian")
    public void translatePage() {
        homePage.openHomePage();
        homePage.buttonUpholsteredFurniture();
        ProductPage productPage = new ProductPage();
        productPage.buttonRU();
        productPage.translateIntoRU();
        String getTitleIntoRU = productPage.translateIntoRU();
        Assert.assertEquals(getTitleIntoRU, "Мягкая мебель");

    }

    @Test(description = "TC-006")
    @Description("Determine the location of the user")
    public void locationUser() {
        int selectedCity = 6;
        String nameCity = "Боярка";
        homePage.openHomePage();
        homePage.clickOnThePopup();
        homePage.chooseCity(selectedCity);
        String actualCity = homePage.selectedCity();
        Assert.assertEquals(actualCity, nameCity);


    }
}


