package PageObject;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    public SelenideElement
            _formAuth = $(".login-button"),
            _usernameField = $("#username"),
            _passwordField = $("#password"),
            _loginButton = $(byName("login")),
            _rememberMeButton = $(byName("rememberme"));
}
