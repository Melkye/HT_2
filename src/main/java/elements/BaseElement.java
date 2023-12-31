package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.Keys;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BaseElement {
    protected String xPath;
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Logger logger;
    public BaseElement(WebDriver driver, WebDriverWait wait, String xPath) {
        this.driver = driver;
        this.wait = wait;
        this.xPath = xPath;

        logger = LogManager.getLogger();
    }

    public BaseElement click() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xPath)));

        driver.findElement(By.xpath(xPath)).click();

        logger.info(String.format("Clicked element. XPath: %s", xPath));

        return this;
    }

    public BaseElement pressKey(Keys key) {

        var actions = new Actions(driver);

        actions.click(wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xPath))))
                .keyDown(key)
                .keyUp(key)
                .build()
                .perform();

        logger.info(String.format("Pressed key on element. XPath: %s. Key: %s", xPath, key));

        return this;
    }
}
