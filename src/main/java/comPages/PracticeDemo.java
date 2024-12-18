package comPages;

import java.time.Duration;
import java.util.List;
import java.util.TreeSet;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
		driver.get("https://www.amazon.in/");
		driver.navigate().refresh();
		driver.navigate().refresh();
		// driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.getElementById('twotabsearchtextbox').value='iphone'");
		driver.findElement(By.id("nav-search-submit-button")).click();
		WebElement parent = driver.findElement(By.id("search"));
		List<WebElement> link = parent.findElements(By.xpath("//span[@class='a-price-whole']"));
		TreeSet set = new TreeSet();
		for (int i = 0; i < link.size(); i++) {
			String price = link.get(i).getText();
			set.add(price);
		}
		String lowPrice = set.getFirst().toString();
		for (int i = 0; i < link.size(); i++) {
			String price = link.get(i).getText();
			if (lowPrice.equalsIgnoreCase(price)) {
				link.get(i).click();
			}
		}

//		String[] str = new String[link.size()];
//		String price = null;
//		int size = link.size();
//		int count = 0;
//		for (int i = 0; i < link.size(); i++) {
//			price = link.get(i).getText();
//			str[i] = price;
//			System.out.println(str[i]);
//		}
//		Arrays.sort(str);
//		// Arrays.toString(str);
//		System.out.println(str[2] + " hhh");
//		for (int i = 0; i < link.size(); i++) {
//			price = link.get(i).getText();
//			if (str[0].equalsIgnoreCase(price)) {
//				link.get(i).click();
//			}
//		}
//
//		Set<String> set = driver.getWindowHandles();
//		Iterator it = set.iterator();
//
//		while (it.hasNext()) {
//			String win = (String) it.next();
//			driver.switchTo().window(win);
//			System.out.println(driver.getTitle());
//		}

		// driver.close();

	}
}
