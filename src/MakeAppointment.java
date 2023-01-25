import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

class MakeAppointment {

	@Test
    void TC1001MakeAppointment_Success() throws InterruptedException  {
        WebDriver driver = null;

        System.setProperty("webdriver.chrome.driver", "D:\\webdriver\\chromedriver.exe");
        driver = new ChromeDriver();

        driver.get("https://katalon-demo-cura.herokuapp.com/");
                driver.findElement(By.xpath("//*[@id=\"btn-make-appointment\"]")).click();
                driver.findElement(By.xpath("//*[@id=\"txt-username\"]")).click();
                driver.findElement(By.xpath("//*[@id=\"txt-username\"]")).sendKeys("John Doe");
                driver.findElement(By.xpath("//*[@id=\"txt-password\"]")).click();
                driver.findElement(By.xpath("//*[@id=\"txt-password\"]")).sendKeys("ThisIsNotAPassword");
                driver.findElement(By.xpath("//*[@id=\"btn-login\"]")).click();
                Select option = new Select(driver.findElement(By.xpath("//*[@id=\"combo_facility\"]")));
                option.selectByVisibleText("Seoul CURA Healthcare Center");
                driver.findElement(By.xpath("//*[@id=\"appointment\"]/div/div/form/div[2]/div/label")).click();
                driver.findElement(By.xpath("//*[@id=\"appointment\"]/div/div/form/div[3]/div/label[2]")).click();
                driver.findElement(By.xpath("//*[@id=\"txt_visit_date\"]")).click();
                driver.findElement(By.xpath("//*[@id=\"txt_visit_date\"]")).sendKeys("25/01/2023");
                driver.findElement(By.xpath("//*[@id=\"txt_comment\"]")).click();
                driver.findElement(By.xpath("//*[@id=\"txt_comment\"]")).sendKeys("Warframe 75%");
                driver.findElement(By.xpath("//*[@id=\"btn-book-appointment\"]")).click();
                
                String result = driver.findElement(By.xpath("//*[@id=\"comment\"]")).getText();
                if(result.equalsIgnoreCase("Warframe 75%"))
                	System.out.println("Pass");
                else
                	System.out.println("Fail");
                Thread.sleep(500);
                driver.quit();
                //driver = null;
                
                
                
    }
}
