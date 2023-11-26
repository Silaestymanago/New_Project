package page_obgects;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class ProductPage {
    @Step("TC-001,Step_2.Popup filter is display")
    public boolean isFilterPopupDisplay() {
        SelenideElement filterPopup = $("[class='block filters']");
        return filterPopup.is(visible);
    }

    @Step("TC-005,Step_2.Click on the button RU")
    public void buttonRU() {
        $x("//a[@hreflang='ru-ua']").click();
    }

    @Step("TC-005.Step_3.Verify that the title М'які меблі translate into Russian")
    public String translateIntoRU() {
        return $("[class='crumb-current']").getText();

    }

    @Step("TC-008.Step_2.Verify that the title product page \" передпокої\" is \" передпокої\"")
    public String titleProductPage() {
        return $("[class='crumb-current']").getText();

    }

    @Step("TC-011.Step_3:Click on the button \" Mebel-Star\"in the manufacturer section")
    public void buttonModelStar() {
        $x("//span[contains(text(),'Mebel-Star')]").click();
    }

    @Step("TC-011.Step_4:Check that the 23 models of  kitchen  are loaded on the page")
    public int countModelsKitchen() {
        ElementsCollection models = $$("[class='product-cart-title']");
        models.first().shouldBe(visible);
        return models.size();

    }

    @Step("TC-012.Step_3.Click on the button\"Модульна кухня \"Mono | Моно\"")
    public void clickButtonModel() {
        $x("//a[@href=\"/54-kuhni/modulna-kuhnya-mono-mono-12389\"]").click();

    }

    @Step("TC-014.Step_2;Check the the 22 models of dining tables are loaded on the page")
    public int CountModelsDiningTables() {
        ElementsCollection modelsDiningTables = $$("[class='product-cart-image");
        modelsDiningTables.shouldHave(CollectionCondition.sizeGreaterThanOrEqual(22)).first().shouldBe(visible);
        return modelsDiningTables.size();

    }

    @Step("TC-015.Step_2:Enter the required MIN length of the diningTable")
    public void enterRequiredMinLengthTable(String widthTable) {
        Selenide.executeJavaScript("window.scrollBy(0, 800)");
        $("[class='spoiler spec-wrapper spoiler-success spoiler-state-expanded']").shouldBe(visible);
        $("[class='filter-input']").click();
        $("[class='filter-input']").clear();
        $("[class='filter-input']").sendKeys(widthTable);
    }

    @Step("TC-015.Step_3:Enter the required MAX length of the diningTable")
    public void requiredMaxLengthTable(String lengthTable) {
        $x("//input[@id='21_max']").click();
        $x("//input[@id='21_max']").clear();
        $x("//input[@id='21_max']").sendKeys(lengthTable);
        $x("//input[@id='21_max']").sendKeys(Keys.ENTER);


    }

    @Step("TC-015.Step_4:Check that the specified length matches the loaded length of the table")
    public String specifiedLength() {
        $("[class ='caption']").shouldBe(visible);
        return $x("//div[contains(text(),'Довжина, мм: 800 - 1000')]").getText();
    }

    @Step("TC-016.Step_2;Enter the required MIN width of the table")
    public void requiredMinWidthTable(String minWidthDiningTable) {
        Selenide.executeJavaScript("window.scrollBy(0, 800)");
        $x("//input[@id='2_min']").click();
        $x("//input[@id='2_min']").clear();
        $x("//input[@id='2_min']").sendKeys(minWidthDiningTable);

    }

    @Step("TC-016.Step_3;Enter the required MAX width of the table")
    public void requiredMaxWidthTable(String maxWidthDiningTable) {
        $x("//input[@id='2_max']").click();
        $x("//input[@id='2_max']").clear();
        $x("//input[@id='2_max']").sendKeys(maxWidthDiningTable);
        $x("//input[@id='2_max']").sendKeys(Keys.ENTER);
    }

    @Step("TC-016.Step_4;Check that the specified width matches the loaded width of the table")
    public String specifiedWidth() {
        $("[class = 'caption']").shouldBe(visible);
        return $x("//div[contains(text(),'Ширина, мм: 600 - 700')]").getText();

    }

    @Step("TC-017.Step_2;Click in the section Shape on the button 'Кутова'")
    public void buttonShapeAngular() {
        $x("//span[contains(text(),'Кутова')]").click();
    }

    @Step("TC-017;Step_3;Click on the button 'Диван кутовий «Флорида DB»'")
    public void buttonSofa() {
        $("[class='uk page-category'").shouldBe(visible);
        $x("//a[@href=\"/47-myaki-mebli/dyvan-kutovyy-floryda-db-10946\"]").click();
    }

    @Step("TC-019.Step_2;Click on the button 'Ліжко 'Б'янко'")
    public void buttonBedBianco() {
        Selenide.executeJavaScript("window.scrollBy(0, 1000)");
        $x("//a[@href=\"/605-lizhka/lizhko-byanko-3393\"]").click();

    }
}


