package comPages;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class PracticeDemo {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\atulk\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.icicibank.com/");
		List<WebElement> link = driver.findElements(By.tagName("link"));
		for (WebElement ele : link) {
			String str = ele.getAttribute("href");
			driver.get(str);
		}
		Set<String> linkId = driver.getWindowHandles();
		Iterator<String> itr = linkId.iterator();
		while (itr.hasNext()) {
			int a = 9;

			System.out.println(driver.getTitle());
		}
	}

}
