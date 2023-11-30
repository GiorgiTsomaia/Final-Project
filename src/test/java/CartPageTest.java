import StepObject.CartPageSteps;
import Utils.ChromeRunner;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.*;
public class CartPageTest extends ChromeRunner {
    CartPageSteps cartPageSteps = new CartPageSteps();
    @Test
    @Description("კალათში დამატება და შევამოწმოთ რომ ნამდვილად დაემატა")
    public void SuccessfullAddToCart(){
        cartPageSteps
                .SelectItemAndFlavor()
                .AddItemInCart()
                .CloseSidePanelWidget()
                .ClickOnCartButton();
        sleep(1000);
        SelenideElement _table = $(".cart-table-section").$(".cart");
        Assert.assertFalse(_table.find(By.cssSelector("tbody")).is(Condition.empty),"შევამოწმოთ რომ ნამდვილად დაემატა კალათში");
    }
    @Test
    @Description("წარმატებული კალათიდან წაშლა, და შევამოწმოთ რომ ნამდვილად წაიშალა")
    public void DeleteItemFromCart(){
        cartPageSteps
                .SelectItemAndFlavor()
                .AddItemInCart()
                .CloseSidePanelWidget()
                .ClickOnCartButton()
                .DeleteItemFromCart();
        sleep(500);
        SelenideElement _table = $(".cart-table-section").$(".cart");
        Assert.assertTrue(_table.find(By.cssSelector("tbody")).is(Condition.empty),"შევამოწმოთ რომ ნამდვილად წაიშალა კალათიდან");
    }
}
