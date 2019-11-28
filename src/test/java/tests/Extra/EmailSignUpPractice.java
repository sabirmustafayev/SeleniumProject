package tests.Extra;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserFactory;

public class EmailSignUpPractice {
    private WebDriver driver;

    @Test
    public void testCase6() throws InterruptedException {
//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();
        driver = BrowserFactory.getDriver("chrome");
        // Step 1 Go to the following website:
        driver.get("https://www.tempmailaddress.com/");
        //Step 2 copy and save email address
        String email = driver.findElement(By.id("email")).getText();
        System.out.println(email);
        //Step 3 Navigate to the practice website
        driver.navigate().to("https://practice-cybertekschool.herokuapp.com");
        // Step 4 Got to the Sign up mailing page
        driver.findElement(By.linkText("Sign Up For Mailing List")).click();
        //Step 5 Enter a valid name
        driver.findElement(By.name("full_name")).sendKeys("Jon Smith");

        /*
                By.name("full_name")
                By.cssSelector"[name = 'full_name']"


         */
        //Step 6 Enter valid email from step 2
        driver.findElement(By.cssSelector("[name='email']"))  .sendKeys(email);
         //Step 7 click sign up
        driver.findElement(By.name("wooden_spoon")).click();
        //Step 8 Verify sign up message
        String expectedSignUp = "Thank you for signing up. Click the button below to return to the home page.";
        String actualSignUp = driver.findElement(By.cssSelector("[name='signup_message']")).getText();
        Assert.assertEquals(actualSignUp,expectedSignUp,"Sign up message is wrong");
        //Step 9 Go back to temporary email website
        driver.get("https://www.tempmailaddress.com/");
        Thread.sleep(10000);
        // Step 10 Verify that you recieved an email from cybertek
        String expectedReceviedMail = "do-not-reply@practice.cybertekschool.com" ;
        WebElement ReceivedMail = driver.findElement(By.xpath("//td[contains(text(), 'do-not-reply@practice.cybertekschool.com')]"));
        String actualReceivedMail = ReceivedMail.getText();
        actualReceivedMail = actualReceivedMail.trim();
        Assert.assertEquals(actualReceivedMail,expectedReceviedMail,"Mail is not received");
        //Step 11 Click on email and open
              ReceivedMail.click();
        //Step 12 Verify that email is from Cybertek
            String expectedFrom ="do-not-reply@practice.cybertekschool.com";
            String actualFrom = driver.findElement(By.id("odesilatel")).getText();
            Assert.assertEquals(actualFrom,expectedFrom,"Mail is not from Cybertek");
        //Step 13 Verify that subject is correct
            String expectedSubject ="Thanks for subscribing to practice.cybertekschool.com!";
            String actualSubject =driver.findElement(By.id("predmet")).getText();
            Assert.assertEquals(actualSubject,expectedSubject,"Subject is wrong");





        driver.quit();
    }
}
