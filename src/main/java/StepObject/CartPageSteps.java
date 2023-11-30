package StepObject;

import PageObject.CartPage;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class CartPageSteps extends CartPage {
    @Step("კალათში გადასვლა")
    public CartPageSteps ClickOnCartButton(){
        _cartButton.click();
        $(".cart-table-section").$(By.tagName("thead")).shouldNot(Condition.empty, Duration.ofMillis(1000));
        return this;
    }
    @Step("პროდუქტის და არომატის არჩევა")
    public CartPageSteps SelectItemAndFlavor(){
        _searchBar.val("კაზეინი").pressEnter();
        ElementsCollection items = $$(byClassName("product-grid-item"));
        items.get(0).click();
        _flavorSelector.selectOption("შოკოლადი");
        return this;
    }
    @Step("კალათში დამატება")
    public CartPageSteps AddItemInCart(){
        $(byName("add-to-cart")).click();
        return this;
    }
    @Step("დავხუროთ გვერდითა პანელი")
    public CartPageSteps CloseSidePanelWidget(){
        $(".close-side-widget").click();
        return this;
    }
    @Step("კალათში დამატება")
    public CartPageSteps DeleteItemFromCart(){
        $(".cart-table-section").$(".remove").click();
        $(".cart-table-section").$(By.tagName("tbody")).shouldBe(Condition.empty, Duration.ofMillis(1000));
        return this;
    }
    @Step
    public SelenideElement Cart(){
        return $(".cart-table-section").$(".cart");
    }


}
