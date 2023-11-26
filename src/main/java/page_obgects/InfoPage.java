package page_obgects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class InfoPage {
    @Step("TC-007.Step_3:Verify that the title info page\"Умови продажу на TABURETKA.UA \"is title \" Умови продажу на TABURETKA.UA\"")
    public String titleInfoPage() {
        return $("[class='crumb-current']").getText();

    }

    @Step("TC-009.Step_3:Check availability of information \"Меблеві салони та пункти видачі\"")
    public String availabilityInformation() {
        Selenide.executeJavaScript("window.scrollBy(0, 1200)");
        return $x("//div[contains(text(),'Меблеві салони та пункти видачі')]").getText();

    }

    @Step("TC-010.Step_2:Verify that the schedule work is available on the page\"Контакти\"")
    public String scheduleWorkCallCenter() {
        return $("[class='left call-time']").getText();
    }

    @Step("TC-020.Step_2;Verify that the button 'Статті' open info page 'Статті'")
    public String infoPageArticles() {
        $("[class='crumb-current']").shouldBe(Condition.visible);
        return $("[class='crumb-current']").getText();

    }
}


