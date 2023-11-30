package PageObject;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CartPage {
    public SelenideElement
        _cartButton = $(byTitle("საყიდლების კალათა")),
        _searchBar = $(byName("search")),
        _flavorSelector = $(byCssSelector("select")),
        _itemList = $(byText("საყიდლების კალათა")),
        _sumOfAllItems = $(".shopping-cart-widget-footer").$(".total").$(".amount"),
        _deleteFromCart = $(".woodmart-cart-opened").$(".remove_from_cart_button"),
        _noCartItems = $("woodmart-cart-opened").$(byText("თქვენ კალათში პროდუქტები არ არის."));
}
