package pages;

import elements.Button;
import elements.Input;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait, "https://github.com/login");

        driver.get(URL);
    }

    private Input getUsernameInput() {
        return new Input("//input[@id='login_field']",
                driver, wait);
    }

    private Input getPasswordInput() {
        return new Input("//input[@id='password']",
                driver, wait);
    }

    private Button getSignInButton() {
        return new Button("//input[@data-signin-label='Sign in']",
                driver, wait);
    }

    public HomePage login(String username, String password) {
        logger.info("Entering login method");

        getUsernameInput().setText(username);
        getPasswordInput().setText(password);
        getSignInButton().click();

        logger.info("Leaving login method");
        return new HomePage(driver, wait);
    }
}