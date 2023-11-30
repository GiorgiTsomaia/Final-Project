package PageObject;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class SalePage {
    public SelenideElement
        _saleButton = $(byText("ფასდაკლებები")),
        _SaleItems = $("#tab-featured-0");

    public ElementsCollection
            _products = $$(".product-wrapper");
}
