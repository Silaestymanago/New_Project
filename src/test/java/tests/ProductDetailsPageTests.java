package tests;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import page_obgects.HomePage;
import page_obgects.ProductDetailsPage;
import page_obgects.ProductPage;
import utils.listeners.ListenersTest;

@Listeners({ListenersTest.class})
public class ProductDetailsPageTests {
    HomePage homePage = new HomePage();

    @Test(description = "TC-012")
    @Description("Verify that the description of product on the page is correct")
    public void verifyCorrectlyDescriptionProductPage() {
        homePage.openHomePage();
        homePage.buttonKitchen();
        ProductPage productPage = new ProductPage();
        productPage.clickButtonModel();
        ProductDetailsPage productDetailPage = new ProductDetailsPage();
        String actualDescription = productDetailPage.descriptionOfProduct();
        Assert.assertEquals(actualDescription, "Модульна кухня \"Mono | Моно\"");

    }

    @Test(description = "TC-013")
    @Description("Verify that the kitchen model can be added to the comparison form.After removing the product" +
            "from the form ,A message appears \"У Вас недостатньо товарів... :(\"")
    public void functionAddToCompare() {
        homePage.openHomePage();
        homePage.buttonKitchen();
        ProductPage productPage = new ProductPage();
        productPage.clickButtonModel();
        ProductDetailsPage productDetailPage = new ProductDetailsPage();
        productDetailPage.addToCompare();
        productDetailPage.buttonScales();
        int isModelAdd = productDetailPage.isModelAddedToComparison();

        Assert.assertEquals(isModelAdd, 1);

        productDetailPage.buttonCancel();
        String messageInFormComparison = productDetailPage.messageInTheFormComparison();
        Assert.assertEquals(messageInFormComparison, "У Вас недостатньо товарів... :(");


    }

    @Test(description = "TC-017")
    @Description("Check that the description of the sofa on the page detail corresponding selected product")
    public void productAddedToTheCart() {
        homePage.openHomePage();
        homePage.buttonUpholsteredFurniture();
        ProductPage productPage = new ProductPage();
        productPage.buttonShapeAngular();
        productPage.buttonSofa();
        ProductDetailsPage productDetailPage = new ProductDetailsPage();
        String actualDescription = productDetailPage.descriptionProduct();
        Assert.assertEquals(actualDescription, "М'які меблі");

    }

    @Test(description = "TC-018")
    @Description("Check that the description of the found product on the description page is correctly ")
    public void sampleOfMetalCoating() {
        String productSearchThroughTheSearchField = "Дзеркало";
        homePage.openHomePage();
        homePage.searchProductByFiefSearch(productSearchThroughTheSearchField);
        ProductDetailsPage productDetailPage = new ProductDetailsPage();
        productDetailPage.button22MoreProducts();
        productDetailPage.buttonMirror();
        String actualDescriptionProduct = productDetailPage.descriptionProductOnThePage();
        Assert.assertEquals(actualDescriptionProduct, "Дзеркало");


    }

    @Test(description = "TC-019")
    @Description("Verify that the description product on the detail page responds selected product")
    public void bed() {
        homePage.openHomePage();
        homePage.buttonBed();
        ProductPage productPage = new ProductPage();
        productPage.buttonBedBianco();
        ProductDetailsPage productDetailPage = new ProductDetailsPage();
        String actual = productDetailPage.titleBed();
        Assert.assertEquals(actual, "Ліжко \"Б'янко\"");
    }

}

