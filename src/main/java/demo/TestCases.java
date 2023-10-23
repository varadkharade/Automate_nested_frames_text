package demo;

import java.util.concurrent.TimeUnit;

import org.bouncycastle.oer.Switch;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;


public class TestCases {
    ChromeDriver driver;
    public TestCases()
    {
        System.out.println("Constructor: TestCases");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    public void endTest()
    {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }

    
    public  void testCase01() throws InterruptedException{
        System.out.println("Start Test case: testCase01");

        //Navigate to url:https://the-internet.herokuapp.com/nested_frames  
        driver.get("https://the-internet.herokuapp.com/nested_frames");
        
        // Switch to frame "frame-top" Using Locator "Name" "frame-top"
            String frame_Top = "frame-top";
            driver.switchTo().frame(frame_Top); 
        
        // Switch to frame "frame-left" Using Locator "Name" "frame-left"
        String frame_left = "frame-left";
        driver.switchTo().frame(frame_left); 
    
        // Select the body and find the text Using Locator "XPath" "frame-left"
        String text = driver.findElement(By.xpath("//body")).getText();
        System.out.println("\nText in Left frame is :"+ text);
        Thread.sleep(2000);
        
        // Switch to Parent frame "frame-top"  using driver.switchTo.parentFrame()
        driver.switchTo().parentFrame();
        
        // Switch to frame "frame-middle" Using Locator "Name" "frame-middle"
        String frame_middle = "frame-middle";
        driver.switchTo().frame(frame_middle); 
        
        // Select the body and find the text Using Locator "XPath" //body[contains(text(),'MIDDLE')] and getText()
        String text1 = driver.findElement(By.xpath("//body")).getText();
        System.out.println("Text in middle frame is :"+ text1);
        Thread.sleep(2000);
       
        // Switch to Parent frame "frame-top"  using driver.switchTo.parentFrame()
        driver.switchTo().parentFrame();
       
        // Switch to frame "frame-right" Using Locator "Name" "frame-right"
        String frame_right = "frame-right";
        driver.switchTo().frame(frame_right); 

        // Select the body and find the text Using Locator "XPath" //body[contains(text(),'RIGHT')] and getText()
        String text2 = driver.findElement(By.xpath("//body")).getText();
        System.out.println("Text in right frame is :"+ text2);
        Thread.sleep(2000);
        
        // Switch to default content  using driver.switchTo.defaultContent()
        driver.switchTo().defaultContent();

        // Switch to frame "frame-bottom" Using Locator "Name" "frame-bottom"
        String frame_bottom = "frame-bottom";
        driver.switchTo().frame(frame_bottom); 
        
        // Select the body and find the text Using Locator "XPath" //body[contains(text(),'BOTTOM')] and getText()
        String text3 = driver.findElement(By.xpath("//body")).getText();
        System.out.println("Text in bottom frame is :"+ text3);
        Thread.sleep(2000);
        
        // Switch to default content  using driver.switchTo.defaultContent()
        driver.switchTo().defaultContent();



        System.out.println("\nEnd Test case: testCase01");
    }


}
