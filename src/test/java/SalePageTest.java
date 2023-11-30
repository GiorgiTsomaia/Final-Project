import StepObject.CartPageSteps;
import StepObject.SalePageSteps;
import Utils.ChromeRunner;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.text.NumberFormat;
import java.util.Collections;

import static com.codeborne.selenide.Selenide.*;

public class SalePageTest extends ChromeRunner {
    SalePageSteps salePageSteps = new SalePageSteps();
    @Test
    @Description("შევამოწმოთ რომ ფასდაკლებული პროდუქტები არსებობს")
    public void CheckIfSaleExists(){
        salePageSteps
                .OpenSalePage();
        sleep(1000);
        ElementsCollection _products = $$(".product-wrapper");
        Assert.assertFalse(_products.isEmpty());
    }
    @Test
    @Description("შევამოწმოთ რომ ფასდაკლებული ფასი ნაკლებია ორიგინალი ფასის")
    @Severity(SeverityLevel.CRITICAL)
    public void CheckIfSalePriceIsLowerThanOriginal(){
        salePageSteps
                .OpenSalePage();
        sleep(200);
        ElementsCollection _products = $$(".product-wrapper");

        for (SelenideElement element : _products) {
            float _previousValue = Float.valueOf((element.$(".price").$(By.tagName("del")).$(".amount").getText()));
            float _saleValue = Float.valueOf(element.$(".price").$(By.tagName("ins")).$(".amount").getText().replaceFirst(".$",""));
            Assert.assertFalse( _previousValue < _saleValue);
        }

    }
}
