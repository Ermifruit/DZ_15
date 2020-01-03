import com.applitools.eyes.EyesRunner;
import com.applitools.eyes.MatchLevel;
import com.applitools.eyes.RectangleSize;
import com.applitools.eyes.TestResultsSummary;
import com.applitools.eyes.selenium.ClassicRunner;
import com.applitools.eyes.selenium.Eyes;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
    public static void main(String[] args) {
        EyesRunner runner = new ClassicRunner();
        Eyes eyes = new Eyes(runner);
        eyes.setApiKey("FQaJOvlm105woXNdtbtDY8JpKit1hZqJDbfyj1IGn4N2U110");
        System.setProperty("webdriver.chrome.driver", "C:/Users/ermif/Downloads/Новая папка/Пример с junit/visual_15/src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://mail.ru");
        eyes.open(driver, "SomeSite", "Test", new RectangleSize(1280, 768));
        eyes.setMatchLevel(MatchLevel.CONTENT);
        WebElement mail = driver.findElement(By.xpath("//a[@class='logo__img']"));
        eyes.checkElement(mail);
        driver.get("https://yandex.ru");
        WebElement yandex = driver.findElement(By.xpath("//*[@aria-label='Яндекс']"));
        eyes.checkElement(yandex);
        driver.get("https://google.com");
        WebElement google = driver.findElement(By.xpath("//img[@alt='Google']"));
        eyes.checkElement(google);




        eyes.closeAsync();
        driver.quit();
        eyes.abortIfNotClosed();

        TestResultsSummary allTestResults = runner.getAllTestResults();
        System.out.println(allTestResults);
    }
}
