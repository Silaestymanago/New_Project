package page_obgects;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.*;

public class ProductDetailsPage {
    @Step("TC-012.Step_4:Verify that the description of product on the page is correct")
    public String descriptionOfProduct() {
        return $("[class='crumb-current']").getText();

    }

    @Step("TC-013.Step_4:Click on the button \"Додати до порівняння\"")
    public void addToCompare() {
        $("[class='product-compare-selected-text']").click();
    }

    @Step("TC-013.Step_5:Click the button \"scales\"")
    public void buttonScales() {
       $("[class='compare-icon']").click();
    }

    @Step("TC-013.Step_6:Check that the kitchen model has been added to the comparison form")
    public int isModelAddedToComparison() {
        return $x("//span[contains(text(),'1')]").exists() ? 1 : 0;

    }

    @Step("TC-013;Step_7.Click in the button\"cancel\"")
    public void buttonCancel() {
        $x("//a[@data-href='https://www.taburetka.ua/porivnyannya/c/54']").shouldBe(Condition.visible);
        $x("//a[@data-href='https://www.taburetka.ua/porivnyannya/c/54']").click();

    }

    @Step("TC-013; Step_8. Verify that the message \"У Вас недостатньо товарів... :(\" in the comparison form is displayed")
    public String messageInTheFormComparison() {
        $("[class='compare-wrapper-empty']").shouldBe(Condition.visible);
        return $("[class='compare-wrapper-empty']").getText();


    }

    @Step("TC-017,Step_4;Check that the selected a sofa corresponding description on the details page ")
    public String descriptionProduct() {
        $("[class='header']").shouldBe(Condition.visible);
        return $("[class='crumb-current']").getText();

    }
    @Step("TC-018;Step_2;Click on the button 'Ще 22 товари'")
    public void button22MoreProducts(){
        $("[class='backmore']").click();
    }
    @Step("TC-018;Step_3; Find the mirror 'Дзеркало \"Амбер\"'and click on the product")
    public void buttonMirror(){
        $$("[class='product-cart-title']").get(19).click();
    }


    @Step("TC-018;Step_4;Check that the description of the found product on the details page is correctly ")
    public String descriptionProductOnThePage (){
        $("[class='header']").shouldBe(Condition.visible);
        return $("[class='crumb-current']").getText();

    }

    @Step("TC-019;Step_3;Verify that the title product 'Ліжко 'Б'янко' on the detail page is 'Ліжко 'Б'янко'")
    public  String titleBed(){
        return $("[class='crumb-current']").getText();

    }
}

