package StepObject;

import DataObject.LoginPageData;
import PageObject.LoginPage;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.$;

public class LoginPageSteps extends LoginPage {
    @Step("ავთენთიფიკაციაზე გადასვლა")
    public LoginPageSteps ClickOnFormAuth(){
        _formAuth.click();
        return this;
    }
    @Step("Login ღილაკზე დაჭერა")
    public LoginPageSteps ClickOnLoginButton(){
        _loginButton.click();
        return this;
    }
    @Step("იუზერნეიმის შეყვანა")
    public LoginPageSteps InputUsername(){
        _usernameField.setValue(LoginPageData._username);
        return this;
    }
    @Step("პაროლი შეყვანა")
    public LoginPageSteps InputPassword(){
        _passwordField.sendKeys(LoginPageData._password);
        return this;
    }
    @Step("RememberMe-ს მონიშვნა")
    public LoginPageSteps ClickRememberMe(){
        _rememberMeButton.click();
        return this;
    }
    @Step
    public SelenideElement LogInButton(){
        return $(".login-button");
    }
    @Step
    public SelenideElement RememberMe(){
        return _rememberMeButton;
    }

}
