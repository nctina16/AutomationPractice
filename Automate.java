import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Automate {
    public static WebDriver driver;

    public static void main(String args[]) {
        // Setting browser driver
        System.setProperty("webdriver.chrome.driver","/Users/nivethaclementinad/Downloads/chromedriver");
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        // Navigating to Base URL
        driver.get("http://automationpractice.com/index.php");

        //Locating input Element
        driver.findElement(By.linkText("Sign in")).click();

        driver.findElement(By.id("email_create")).sendKeys("nivetha00@yahoo.comm");
        driver.findElement(By.xpath("//button[@name=\"SubmitCreate\"]")).click();

        System.out.println("Initial Creation");

        WebElement genderSelector = driver.findElement(By.xpath("//*[@id=\"id_gender2\"]"));
        genderSelector.click();
        driver.findElement(By.id("customer_firstname")).sendKeys("Nivetha");
        driver.findElement(By.id("customer_lastname")).sendKeys("Clementina");
        driver.findElement(By.id("passwd")).sendKeys("Nivetha16");
        driver.findElement(By.id("firstname")).sendKeys("Nivetha");
        driver.findElement(By.id("lastname")).sendKeys("Clementina");
        driver.findElement(By.id("company")).sendKeys("TestVagrant");
        driver.findElement(By.id("address1")).sendKeys("Indiranagar, Bangalore");
        driver.findElement(By.id("city")).sendKeys("Bengaluru");
        WebElement statedropdown = driver.findElement(By.id("id_state"));
        Select sSelect = new Select(statedropdown);
        sSelect.selectByValue("11");
        driver.findElement(By.id("postcode")).sendKeys("00000");
        WebElement countrydropdown = driver.findElement(By.id("id_country"));
        Select cSelect = new Select(countrydropdown);
        cSelect.selectByVisibleText("United States");
        driver.findElement(By.id("phone_mobile")).sendKeys("2345678901");
        driver.findElement(By.xpath("//input[@name=\"alias\"]")).clear();
        driver.findElement(By.xpath("//input[@name=\"alias\"]")).sendKeys("Office");
        driver.findElement(By.id("submitAccount")).click();
        System.out.println(("User registered successfully"));

        //Selecting item
        driver.findElement(By.id("search_query_top")).sendKeys("Top"+ Keys.RETURN);

        //adding element to cart
        driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li/div/div[1]/div/a[1]/img")).click();
        WebElement itemName = driver.findElement(By.xpath("//*[@id=\"center_column\"]/div/div/div[3]/h1"));
        System.out.println("Item Name:" +itemName.getText());
        WebElement addedToCart = driver.findElement(By.xpath("//*[@id=\"add_to_cart\"]/button"));
        addedToCart.click();
        System.out.println("Item "+itemName.getText()+ " Successfully added");

        //Quit browser
        driver.quit();

    }
}
