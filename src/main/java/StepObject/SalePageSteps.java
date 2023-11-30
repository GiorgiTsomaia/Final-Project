package StepObject;

import PageObject.SalePage;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class SalePageSteps extends SalePage {
    @Step
    public SalePageSteps OpenSalePage(){
        _saleButton.click();
        _SaleItems.shouldBe(Condition.visible, Duration.ofMillis(4000));
        return this;
    }

    @Step
    public ElementsCollection ReturnProductItems(){
        return _products;
    }
    @Step
    public boolean CheckSalePrice(){
        boolean _checker = true;
        for (SelenideElement element : _products) {
            float _previousValue = Float.valueOf((element.$(".price").$(By.tagName("del")).$(".amount").getText()));
            float _saleValue = Float.valueOf(element.$(".price").$(By.tagName("ins")).$(".amount").getText().replaceFirst(".$",""));
            if (_previousValue < _saleValue)
                _checker = false;
                return _checker;
        }
        return _checker;
    }
}
