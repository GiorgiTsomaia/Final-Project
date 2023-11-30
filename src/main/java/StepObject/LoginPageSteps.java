package StepObject;

import DataObject.LoginPageData;
import PageObject.LoginPage;
import io.qameta.allure.Step;

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

}
