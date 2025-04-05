package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class SignUpPageInsta extends BasePage {
  public SignUpPageInsta(WebDriver driver) {
    super(driver);
    PageFactory.initElements(driver, this);
  }



  @FindBy(xpath = "//span[text()='Sign up']")
  WebElement signupBtn;

  @FindBy(xpath = "//input[@aria-label='Mobile Number or Email']")
  WebElement emailTxtBox;

  @FindBy(xpath = "//input[@aria-label='Password']")
  WebElement pwdTxtBox;

  @FindBy(xpath = "//input[@aria-label='Full Name']")
  WebElement nameTxtBox;

  @FindBy(xpath = "//input[@aria-label='Username']")
  WebElement usernameTxtBox;

  @FindBy(xpath = "//button[text()='Sign up']")
  WebElement signupBtn1;

  @FindBy(xpath = "//div[text()='Another account is using the same email.']")
  WebElement emailError;

  @FindBy(xpath = "//div[text()='This username isn't available. Please try another.']")
  WebElement usernameError;

  @FindBy(xpath = "//select[@title='Month:']")
  WebElement monthDropDwn;

  @FindBy(xpath = "//select[@title='Day:']")
  WebElement dayDropDwn;

  @FindBy(xpath = "//select[@title='Year:']")
  WebElement yearDropDwn;
  @FindBy(xpath = "//button[text()='Next']")
  WebElement nextBtn;

  @FindBy(xpath = "//input[@class='ycptinput']")
  WebElement emailInput;

  @FindBy(xpath="//div[@id='dismiss-button']")
  WebElement crossBtn;

  public void openSignupPage() {
    driver.get("https://www.instagram.com/");
    wait.until(ExpectedConditions.visibilityOf(signupBtn));
  }

  public void clickSignUp() {
    signupBtn.click();
  }

  public void fillSignupDetails() throws InterruptedException {

    wait.until(ExpectedConditions.visibilityOf(emailTxtBox));
    emailTxtBox.sendKeys(email);
    System.out.println("email1 : " + email);
    pwdTxtBox.sendKeys("Test@123");
    nameTxtBox.sendKeys("Sourav");
    usernameTxtBox.sendKeys(username);
    Thread.sleep(2000);
//    if (isElementVisible(emailError)) {
////      emailTxtBox.click();
//      // emailTxtBox.clear();
//        Actions actions = new Actions(driver);
//        actions.moveToElement(emailTxtBox).click().sendKeys(Keys.CONTROL + "a").sendKeys(Keys.DELETE).perform();
//      emailTxtBox.sendKeys(generateRandomEmail());
//      System.out.println("Email error is visible on the page.");
//    } else {
//      System.out.println("Email error is not visible on the page.");
//    }
//    Thread.sleep(5000);
//    if (isElementVisible(usernameError)) {
//      usernameTxtBox.clear();
//      usernameTxtBox.sendKeys(generateRandomUsername());
//      System.out.println("Username error is visible on the page.");
//    } else {
//      System.out.println("Username error is not visible on the page.");
//    }
    signupBtn1.click();
  }

  private boolean isElementVisible(WebElement element) {
    try {
      // Wait until the element is visible
      wait.until(ExpectedConditions.visibilityOf(element));
      return element.isDisplayed();
    } catch (Exception e) {
      return false;
    }
  }


  public void fillBirthDetails(int day, String month, int year) {
    wait.until(ExpectedConditions.visibilityOf(monthDropDwn));
    Select monthSelect = new Select(monthDropDwn);
    List<WebElement> monthList = monthSelect.getOptions();
    for (WebElement option : monthList) {
      if (option.getText().equalsIgnoreCase(month)) {
        option.click();
        break;
      }
    }
    wait.until(ExpectedConditions.visibilityOf(yearDropDwn));
    Select yearSelect = new Select(yearDropDwn);
    List<WebElement> yearList = yearSelect.getOptions();
    for (WebElement option : yearList) {
      int optionYear = Integer.parseInt(option.getText());
      if (optionYear < 2000) {
        if (optionYear == year) {
          option.click();
          break;
        }
      }
    }

    wait.until(ExpectedConditions.visibilityOf(dayDropDwn));
    Select daySelect = new Select(dayDropDwn);
    List<WebElement> dayList = daySelect.getOptions();
    for (WebElement option : dayList) {
      int optionDay = Integer.parseInt(option.getText());
      if (optionDay == day) {
        option.click();
        break;
      }
    }
    nextBtn.click();
  }

  public void enterOtp() {

    JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
    jsExecutor.executeScript("window.open('https://yopmail.com/', '_blank');");
wait.until(ExpectedConditions.visibilityOf(emailInput));
    emailInput.sendKeys(generateRandomEmail());
    wait.until(ExpectedConditions.visibilityOf(crossBtn)).click();



//    // Switch to the new tab (Assuming the new tab is the last one)
//    Set<String> allWindows = driver.getWindowHandles();
//    String newTabHandle = (String) allWindows.toArray()[allWindows.size() - 1];
//    driver.switchTo().window(newTabHandle);
//
//    // Navigate to the Yopmail website
//    driver.get("https://yopmail.com/");
  }


  public void persistData() {
    writeCSV("src/test/resources/testData/creds.csv");
   // email,password
    //code to create excel and update,but read first
    // and then find last line append line after the last line

    //keep in map
  }
}
