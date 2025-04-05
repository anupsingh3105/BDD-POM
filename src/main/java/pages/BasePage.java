package pages;

import com.opencsv.CSVWriter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.util.Random;


public class BasePage {
  protected WebDriver driver;
  protected WebDriverWait wait;

  // Constructor to initialize WebDriver and WebDriverWait
  public BasePage(WebDriver driver) {
    this.driver = driver;
    this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Customize timeout if needed
  }

  // Method to generate a random email address
  public static String generateRandomEmail() {
    // Define the Yopmail domain
    String domain = "yopmail.com";

    // Define characters for the random part of the email
    String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    // Create a random object to generate random values
    Random random = new Random();

    // Set the length of the random part (email prefix)
    int length = 10;

    // Generate the random email prefix
    StringBuilder emailPrefix = new StringBuilder();
    for (int i = 0; i < length; i++) {
      int index = random.nextInt(characters.length());
      emailPrefix.append(characters.charAt(index));
    }

    String email=emailPrefix.toString() + "@" + domain;
    // Return the full email address
    return email;
  }




        // Method to generate a random username
        public static String generateRandomUsername() {
            // Define characters for the random part of the username
            String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

            // Create a random object to generate random values
            Random random = new Random();

            // Set the length of the random username
            int length = 8; // You can change the length as desired

            // Generate the random username
            StringBuilder username = new StringBuilder();
            for (int i = 0; i < length; i++) {
                int index = random.nextInt(characters.length());
                username.append(characters.charAt(index));
            }

            // Return the random username
            return username.toString();
        }
    String email = generateRandomEmail();
    String username=generateRandomUsername();

    public  void writeCSV(String filePath)
    {
        // first create file object for file placed at location
        // specified by filepath
        File file = new File(filePath);
        try {
            // create FileWriter object with file as parameter
            FileWriter outputfile = new FileWriter(file, true);

            // create CSVWriter object filewriter object as parameter
            CSVWriter writer = new CSVWriter(outputfile);

            // adding header to csv
            if (file.length() == 0) {
                String[] header = { "email", "password" };
                writer.writeNext(header);
            }
            // add data to csv
            String[] data1 = { email, "Test@123" };
            writer.writeNext(data1);

            // closing writer connection
            writer.close();
        }
        catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}


