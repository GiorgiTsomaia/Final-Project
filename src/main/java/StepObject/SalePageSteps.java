package StepObject;

import PageObject.SalePage;
import io.qameta.allure.Step;

public class SalePageSteps extends SalePage {
    @Step
    public SalePageSteps OpenSalePage(){
        _saleButton.click();
        return this;
    }
}
