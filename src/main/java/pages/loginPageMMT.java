package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.List;


public class loginPageMMT extends BasePage {

    JavascriptExecutor js = (JavascriptExecutor) driver;

    @FindBy(id = "logout")
    WebElement btn_logout;

    @FindBy(xpath = "//*[@data-acctype='personal']")
    WebElement personal_btn;

    @FindBy(xpath = "//span[@data-cy='closeModal']")
    WebElement closePopup;

    @FindBy(xpath = "//p[text()='Login or Create Account']")
    WebElement loginBtn;
    @FindBy(xpath = "//input[@placeholder='Enter Mobile Number']")
    WebElement mobileTxtBox;
    @FindBy(id = "fromCity")
    WebElement fromCity;
    @FindBy(xpath = "//input[@placeholder='From']")
    WebElement fromCitySearchBox;
    @FindBy(xpath = "//input[@id='toCity']")
    WebElement toCity;
    @FindBy(xpath = "//input[@placeholder='To']")
    WebElement toCitySearchBox;


    public loginPageMMT(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void openLoginPage() {

        driver.get("https://www.makemytrip.com/");
        wait.until(ExpectedConditions.visibilityOf(personal_btn));
        Assert.assertEquals(personal_btn.getText(), "PERSONAL ACCOUNT");
    }

    public void closePopup() {
        closePopup.click();
        wait.until(ExpectedConditions.visibilityOf(loginBtn));
        Assert.assertEquals("Login or Create Account", loginBtn.getText());
    }

    public void clickLogin() {
        loginBtn.click();
        wait.until(ExpectedConditions.visibilityOf(mobileTxtBox));

    }

    public void selectFromCity() throws InterruptedException {

        wait.until(ExpectedConditions.visibilityOf(fromCity));
        fromCity.click();
        wait.until(ExpectedConditions.visibilityOf(fromCitySearchBox));
        fromCitySearchBox.sendKeys("Del");
        List<WebElement> fromCity = driver.findElements(By.xpath("//p[@class='font14 appendBottom5 blackText']"));
        System.out.println("Size of from City list: " + fromCity.size());
        for (int i = 0; i < fromCity.size(); i++) {
            String city = fromCity.get(i).getText().trim();
            System.out.println("From City name: " + city);
            if (city.equalsIgnoreCase("New Delhi, India")) {
                fromCity.get(i).click();
                break;
            }
        }
        Thread.sleep(1000);
        toCity.click();
        wait.until(ExpectedConditions.visibilityOf(toCitySearchBox));
        toCitySearchBox.sendKeys("bang");
        List<WebElement> toCity = driver.findElements(By.xpath("//p[@class='font14 appendBottom5 blackText']"));
        System.out.println("Size of tO City list: " + toCity.size());
        for (int i = 0; i < toCity.size(); i++) {
            String city2 = toCity.get(i).getText().trim();
            System.out.println("To City name: " + city2);
            if (city2.equalsIgnoreCase("Bengaluru, India")) {
                toCity.get(i).click();
                break;
            }
        }
    }
}

