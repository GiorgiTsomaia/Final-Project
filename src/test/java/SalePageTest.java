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
import java.time.Duration;
import java.util.Collections;

import static com.codeborne.selenide.Selenide.*;

public class SalePageTest extends ChromeRunner {
    SalePageSteps salePageSteps = new SalePageSteps();
    @Test
    @Description("შევამოწმოთ რომ ფასდაკლებული პროდუქტები არსებობს")
    public void CheckIfSaleExists(){
        salePageSteps
                .OpenSalePage();
        Assert.assertFalse(salePageSteps.ReturnProductItems().isEmpty());
    }
    @Test
    @Description("შევამოწმოთ რომ ფასდაკლებული ფასი ნაკლებია ორიგინალი ფასის")
    @Severity(SeverityLevel.CRITICAL)
    public void CheckIfSalePriceIsLowerThanOriginal(){
        salePageSteps
                .OpenSalePage();
        Assert.assertTrue(salePageSteps.CheckSalePrice());

    }
}
