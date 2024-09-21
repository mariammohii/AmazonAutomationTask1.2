package Sample.Vois_Task12;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.time.Duration;

public class todayDeals {
    WebDriver driver;

    @BeforeTest
    public void openBrowser() throws InterruptedException {
    	System.setProperty("webdriver.chrome.driver",
				"C:\\Driver\\chromedriver.exe");
    	driver = new ChromeDriver();
        //Set Browser resolution
        driver.manage().window().setSize(new Dimension(1024, 768));
        //Open amazon site
        driver.navigate().to("https://www.amazon.com/");
        Thread.sleep(10000);
    }

    @Test
    public void ValidData() throws InterruptedException {
        //Open amazon site
        driver.navigate().to("https://www.amazon.com/");
        //Open today's deals
        driver.findElement(By.xpath("//*[@id=\"nav-xshop\"]/a[1]")).click();
        
        //from the left side filters select Grocery & Gourmet Food
        driver.findElement(By.xpath("//*[@id=\"departments\"]")).click();
        // Click on see more 
        driver.findElement(By.xpath("//*[@id=\"DealsGridScrollAnchor\"]/div[2]/div[1]/button")).click();
        //choose Grocery & Gourmet Food
        driver.findElement(By.xpath("//*[@id=\"DealsGridScrollAnchor\"]/div[2]/div[1]/div/span[14]/div/label/i")).click();
        //from the Discount part 
        driver.findElement(By.xpath("//*[@id=\"DealsGridScrollAnchor\"]/div[2]/div[5]")).click();
        // choose 10% off or more 
        driver.findElement(By.xpath("//*[@id=\"DealsGridScrollAnchor\"]/div[2]/div[5]/div/span[2]/div/label/i")).click();
        Thread.sleep(5000);
        
        //select item
        driver.findElement(By.xpath("//*[@id=\"DealsGridScrollAnchor\"]/div[3]/div/div/div[2]/div[1]/div/div/div[1]")).click();
        //Add item to the cart
        driver.findElement(By.xpath("//*[@id=\"dealsx_atc_btn\"]/span/a")).click();
        Thread.sleep(2000);
    }
    
    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}