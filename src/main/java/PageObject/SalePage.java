package PageObject;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class SalePage {
    public SelenideElement
        _saleButton = $(byText("ფასდაკლებები"));

}
