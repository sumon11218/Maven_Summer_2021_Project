package Day9_081421;

import Reusable_Classes.Reusable_Methods;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.IOException;

public class mlcalc_with_resuable_concepts {
    public static void main(String[] args) throws IOException, InterruptedException {

        WebDriver driver = Reusable_Methods.setDriver();

        //navigate to mlcalc
        driver.navigate().to("https://www.mlcalc.com");
        Thread.sleep(2500);
        //clear and enter a purchase price
        Reusable_Methods.sendKeysMethod(driver,"//*[@id='ma']","400000","Purchase Price");
        //clear and enter down payment
        Reusable_Methods.sendKeysMethod(driver,"//*[@id='dp']","25","Down Payment");



    }//end of main
}//end of java class
