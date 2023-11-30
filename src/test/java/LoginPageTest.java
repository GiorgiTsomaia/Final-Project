import StepObject.LoginPageSteps;
import Utils.ChromeRunner;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.commands.ShouldBe;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

public class LoginPageTest extends ChromeRunner {
    LoginPageSteps loginPageSteps = new LoginPageSteps();
    @Test
    @Description("ავტორიზაცია მცდარი მონაცემებით")
    public void FailedLogin(){
        loginPageSteps.ClickOnFormAuth()
                .InputUsername()
                .InputPassword()
                .ClickOnLoginButton();
                SelenideElement _formAuth = $(".login-button");
                Assert.assertTrue(_formAuth.isDisplayed(), "მცდარი ავტორიზაცია, ვამოწმებთ რომ ვერ გაიარა ავტორიზაცია");
    }
    @Test
    @Description("ავტორიზაცია იუზერის სახელის გარეშე")
    public void FailedLoginWithoutUsername(){
        loginPageSteps.ClickOnFormAuth()
                .InputPassword()
                .ClickOnLoginButton();
        SelenideElement _formAuth = $(".login-button");
        Assert.assertTrue(_formAuth.isDisplayed(), "მცდარი ავტორიზაცია უზერის სახელის გარეშე, ვამოწმებთ რომ ვერ გაიარა ავტორიზაცია");
    }
    @Test
    @Description("ავტორიზაცია იუზერის პაროლის გარეშე")
    public void FailedLoginWithoutPassword(){
        loginPageSteps.ClickOnFormAuth()
                .InputUsername()
                .ClickOnLoginButton();
        SelenideElement _formAuth = $(".login-button");
        Assert.assertTrue(_formAuth.isDisplayed(), "მცდარი ავტორიზაცია იუზერის პაროლის გარეშე, ვამოწმებთ რომ ვერ გაიარა ავტორიზაცია");
    }
    @Test
    @Description("შევამოწმოთ რომ ეჭირება დამახსოვრების ღილაკს")
    public void PressRememberMeButton(){
        loginPageSteps.ClickOnFormAuth()
                .ClickRememberMe();
        SelenideElement _rememberMeButton = $(byName("rememberme"));
        Assert.assertTrue(_rememberMeButton.isSelected());
    }

}
