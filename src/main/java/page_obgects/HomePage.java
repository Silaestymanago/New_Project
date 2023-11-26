package page_obgects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.*;


public class HomePage {

    public void openHomePage() {

        Configuration.headless = true; // Увімкнути режим хедлес браузера
        open("https://www.taburetka.ua/");
    }

    @Step("TC-001;Step_1.Click on cabinets_button")
    public void clickOnCabinetsButton() {
        $x("//a[contains(text(),'Шафи')]").click();
    }

    @Step("TC-002,Step_1.Click on the entrance to the office button")
    public void clickOnTheButtonEntranceToTheOffice() {
        $("[class='not-auth']").click();

    }


    @Step("TC-002,Step_2.Click on the entrance to the office_button")
    public void clickOnTheButtonCreateAccount() {
        $("[class='modal-for-favorites fancybox-content']").shouldBe(Condition.visible);
        $("[class='button']").click();
    }

    @Step("TC-002,Step_3.Enter the first name in the firstName_field")
    public void enterFirstNameInTheFirstNameField(String firstName) {
        $("[class='account register']").shouldBe(Condition.visible);
        $x("//input[@placeholder=\"Ваше ім'я\"]").click();
        $x("//input[@placeholder=\"Ваше ім'я\"]").sendKeys(firstName);


    }

    @Step("TC-002,Step_4.Enter the last_name in the lastName_field")
    public void enterLastnameInTheLastNameField(String lastName) {
        $x("//input[@placeholder=\"Ваше прізвище\"]").click();
        $x("//input[@placeholder=\"Ваше прізвище\"]").sendKeys(lastName);


    }

    @Step("TC-002,Step_5.Enter phone number in the phone_field")
    public void enterPhoneNumberInThePhoneField(String phoneNumber) {
        $x("//input[@placeholder=\"_ _ _ _ _ _ _ _ _\"]").click();
        $x("//input[@placeholder=\"_ _ _ _ _ _ _ _ _\"]").sendKeys(phoneNumber);

    }

    @Step("TC-002,Step_6.Enter the email in the email_field")
    public void enterEmailInEmailField(String email) {
        $x("//input[@placeholder=\"Ваша електронна пошта\"]").click();
        $x("//input[@placeholder=\"Ваша електронна пошта\"]").sendKeys(email);
    }

    @Step("TC-002,Step_7.Enter the password in the password_field")
    public void enterPasswordInPasswordField(String password) {
        $x("//input[@placeholder=\"6 або більше символів\"]").click();
        $x("//input[@placeholder=\"6 або більше символів\"]").sendKeys(password);
    }

    @Step("TC-003,Step_2.Enter an wrong email")
    public void enterEmail(String email) {
        $("[class ='input']").shouldBe(Condition.visible);
        $("[class ='input']").click();
        $("[class ='input']").sendKeys(email);
        $("[class ='input']").sendKeys(Keys.ENTER);
    }

    @Step("TC-003,Step_3.Message that the account is not found")
    public String getErrorMessage() {
        $("[class ='error']").shouldBe(Condition.visible);
        return $("[class ='error']").getText();

    }

    @Step("TC-004,Step_1.Verify that the site logotype  TABURETKA.UA is TABURETKA.UA")
    public String logotype() {
        return $("[class='self-brand']").getText();

    }

    @Step("TC-005,Step_1.Click on the button М'які меблі")
    public void buttonUpholsteredFurniture() {
        $("[class='sort-cat']").shouldBe(Condition.visible);
        $("[class='category47']").click();
    }

    @Step("TC-006.Step_1:Click on the popup \"Чи правильно ми визначили Ваше місто: Київ?\"")
    public void clickOnThePopup() {
        $("[class='button ajax']").click();

    }

    @Step("TC-006.Step_2: Choose a city and click on the name city")
    public void chooseCity(int namesCityIndex) {
        $("[class='modal fancybox-content']").shouldBe(Condition.visible);
        $$("[class='geoip-choose-item']").get(namesCityIndex - 1).click();
        $("[class='modal fancybox-content']").shouldNotBe(Condition.visible);
    }

    @Step("TC-006.Step_3:Check that the selected city matches the title of the locator.")
    public String selectedCity() {
        return $("[class='ajax geoip-city']").getText();

    }


    @Step("TC-007.Step_2:Click button Умови продажу ")
    public void clickButtonTermsOfSale() {
        Selenide.executeJavaScript("window.scrollBy(0, 1200)");
        $$x("//a[contains(text(),'Умови продажу')]").get(0).click();

    }

    @Step("TC-008.Step_1:Search the search field and click and enter product name")
    public void searchProductBYWord(String searchWord) {
        $x("//input[@type=\"text\"]").click();
        $x("//input[@type=\"text\"]").sendKeys(searchWord);
        $x("//input[@type=\"text\"]").sendKeys(Keys.ENTER);

    }

    @Step("TC-009.Step_1:Click on the button \"Доставка\"")
    public void buttonDelivery() {
        $$x("//a[@href=\"/i29-dostavka-i-oplata\"]").get(0).click();
    }

    @Step("TC-010.Step_1:Click on the button\"Контакти\"")
    public void contactsButton() {
        $("[class='icons20px contacts']").click();


    }


    @Step("TC-011,Step_1.Click on the button\"Кухні\"")
    public void buttonKitchen() {
        $("[class='button geoip-confirm-ok']").shouldNotBe(Condition.visible);
        $x("//span[contains(text(),'Кухні')]").click();


    }

    @Step("TC-014,Step_1;Click on the button \"Dining tables\"")
    public void buttonDiningTables() {
        $x("//a[@href=\"/30-stoly-obidni\"]").click();
    }

    @Step("TC-018.Step_1:Product search by word through the search field")
    public void searchProductByFiefSearch(String searchWord) {
        $x("//input[@type=\"text\"]").click();
        $x("//input[@type=\"text\"]").sendKeys(searchWord);
        $x("//input[@type=\"text\"]").sendKeys(Keys.ENTER);

    }

    @Step("TC_019.Step_1;Click on the button 'Ліжко'")
    public void buttonBed() {
        $("[class='category605']").click();
    }


    @Step("TC-020;Step_1;Click on the button ' Статті'")
    public void buttonArticles() {
        Selenide.executeJavaScript("window.scrollBy(0, 1800)");
        $x("//a[@style=\"display: block;\"]").click();
    }
}



