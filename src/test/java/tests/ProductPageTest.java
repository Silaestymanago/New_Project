package tests;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import page_obgects.HomePage;
import page_obgects.ProductPage;
import utils.listeners.ListenersTest;

@Listeners({ListenersTest.class})
public class ProductPageTest {
    private HomePage homePage = new HomePage();

    @Test(description = "TC-001")
    @Description("Verify that the popup filter is available on the product page \"Шафа\"")
    public void verifyFilterPopUpAppeared() {
        homePage.openHomePage();
        homePage.clickOnCabinetsButton();
        ProductPage productPage = new ProductPage();
        productPage.isFilterPopupDisplay();
        Assert.assertTrue(productPage.isFilterPopupDisplay());


    }

    @Test(description = "TC-008")
    @Description("Product search through the search field by word")
    public void productSearchThroughSearchField() {
        String searchWord = "передпокої";
        homePage.openHomePage();
        homePage.searchProductBYWord(searchWord);
        ProductPage productPage = new ProductPage();
        String actualTitle = productPage.titleProductPage();
        Assert.assertEquals(actualTitle, searchWord);

    }


    @Test(description = "TC-011")
    @Description("Check that the models of kitchen are loaded in the specified number.")
    public void kitchenModelsAreLoaded() {
        homePage.openHomePage();
        homePage.clickPopupButtonYes();
        homePage.buttonKitchen();
        ProductPage productPage = new ProductPage();
        productPage.buttonModelStar();
        int expectedKitchenModelsCount = 23;
        int actualModelsKitchenCount = productPage.countModelsKitchen();
        Assert.assertEquals(actualModelsKitchenCount, expectedKitchenModelsCount);


    }

    @Test(description = "TC-014")
    @Description("Check that the models of dining tables are loaded in the specified number ")
    public void diningTablesAreLoading() {
        homePage.openHomePage();
        homePage.buttonDiningTables();
        ProductPage productPage = new ProductPage();
        int actualModelsDiningTables = productPage.CountModelsDiningTables();
        int expectedModelsDiningTables = 26;
        Assert.assertEquals(actualModelsDiningTables, expectedModelsDiningTables);


    }

    @Test(description = "TC-015")
    @Description("Check that the selected length of the table is displayed correctly on the webSite ")
    public void lengthDiningTable() {
        homePage.openHomePage();
        homePage.buttonDiningTables();
        String widthTable = "800";
        String lengthTable = "1000";
        ProductPage productPage = new ProductPage();
        productPage.enterRequiredMinLengthTable(widthTable);
        productPage.requiredMaxLengthTable(lengthTable);
        String givenLength = productPage.specifiedLength();
        Assert.assertEquals(givenLength, "Довжина, мм: 800 - 1000");


    }

    @Test(description = "TC-016")
    @Description("Check that the selected width of the table is displayed correctly on the webSite ")
    public void widthOfDiningTable() {
        homePage.openHomePage();
        homePage.buttonDiningTables();
        String minWidthTable = "600";
        String maxWidthTable = "700";
        ProductPage productPage = new ProductPage();
        productPage.requiredMinWidthTable(minWidthTable);
        productPage.requiredMaxWidthTable(maxWidthTable);
        String specifiedWidthOhTheTable = productPage.specifiedWidth();
        Assert.assertEquals(specifiedWidthOhTheTable, "Ширина, мм: 600 - 700");

    }


}
