package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import methods.configReader;

import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class amazonPage extends BasePage {

    JavascriptExecutor js = (JavascriptExecutor) driver;

    @FindBy(id = "twotabsearchtextbox")
    WebElement searchBox;
    @FindBy(id = "ap_email_login")
    WebElement username;
    @FindBy(id = "ap_password")
    WebElement password;
    @FindBy(id = "//span[@id='continue-announce']")
    WebElement continueBtn;
    @FindBy(id = "signInSubmit")
    WebElement signinBtn;
    @FindBy(id = "//a[@class='nav-a nav-a-2   nav-progressive-attribute']/div")
    WebElement signin;
    @FindBy(id = "//a[@class='a-link-normal s-line-clamp-2 s-link-style a-text-normal']")
    List<WebElement> itemNames;
    @FindBy(id = "//span[@class='a-price']")
    List<WebElement> itemPrices;

    public amazonPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void openLoginPage() {

        String pageTitle = "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
        String pageS = driver.getTitle();
        System.out.println("Page Title: " + pageS);
        Assert.assertEquals(pageS, pageTitle);
        WebElement signin = driver.findElement(By.xpath("//span[contains(text(), 'Account & Lists')]"));
        js.executeScript("arguments[0].click();", signin);
        wait.until(ExpectedConditions.visibilityOf(username));
        username.sendKeys("anup.singh3t@gmail.com");
        WebElement continueBtn = driver.findElement(By.id("continue"));
        wait.until(ExpectedConditions.visibilityOf(continueBtn));
        continueBtn.click();
        wait.until(ExpectedConditions.visibilityOf(password));
        password.sendKeys("Deloitte@123");
        wait.until(ExpectedConditions.visibilityOf(signinBtn));
        signinBtn.click();
    }

    public void login() {
        String urlAm = configReader.getProperty("urlA");
        driver.get(urlAm);
    }

    public void searchBox() {

        wait.until(ExpectedConditions.visibilityOf(searchBox));
        searchBox.click();
        searchBox.sendKeys("iphone" + Keys.ENTER);
    }

    public void grabAndClickOnItem() throws InterruptedException {

        Thread.sleep(5000);
        List<WebElement> itemNames = driver.findElements(By.xpath("//a[@class='a-link-normal s-line-clamp-2 s-link-style a-text-normal']"));
        List<WebElement> itemPrices = driver.findElements(By.xpath("//span[@class='a-price']"));
        System.out.println("Items List Size: " + itemNames.size());
        System.out.println("Prices List Size: " + itemPrices.size());
        Map<String, String> hm = new HashMap<>();

        for (int i = 0; i < itemNames.size(); i++) {
            String itemText = itemNames.get(i).getText().trim();
            String priceText = itemPrices.get(i).getText().trim();
            hm.put(itemText, priceText);
        }
        for (Map.Entry<String, String> entry : hm.entrySet()) {
            System.out.println("HashMap values: " + entry.getValue() + "Map Item: " + entry
                    .getKey());
        }
    }
}
